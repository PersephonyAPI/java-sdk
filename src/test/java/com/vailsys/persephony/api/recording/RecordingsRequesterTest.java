package com.vailsys.persephony.api.recording;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.BufferedInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import com.vailsys.persephony.KnownSizeInputStream;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import world.Helper;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class RecordingsRequesterTest {

	private static final String aTestRecording = "{\"revision\": 1, \"dateCreated\": \"Tue, 12 Aug 2014 08:02:17 GMT\", \"dateUpdated\": \"Tue, 12 Aug 2014 08:02:17 GMT\", \"recordingId\": \"RE1234567890123456789012345678901234567890\", \"accountId\": \"ACe1006ad515dbfc486dcb75d08db1445b928aef08\", \"callId\": \"CA038a78c97b3667488d553032621c66a8c6368764\", \"durationSec\": 13, \"conferenceId\": \"CF1234567890123456789012345678901234567890\"}";

	private static final String aTestRecordingList = "{\"total\": 4, \"start\": 0, \"end\": 0, \"page\": 0, \"numPages\": 1, \"pageSize\": 20, \"nextPageUri\": null, \"recordings\": ["+RecordingsRequesterTest.aTestRecording+","+RecordingsRequesterTest.aTestRecording+","+RecordingsRequesterTest.aTestRecording+","+RecordingsRequesterTest.aTestRecording+"]}";

	private static final byte[] testRecordingFile = aTestRecordingList.getBytes();

	public RecordingsRequester recordingsR;

	@Given("^a RecordingsRequester with the credentials (AC[0-9A-Fa-f]{40}) and ([0-9A-Fa-f]{40}) and using the accountId (AC[0-9A-Fa-f]{40})$")
	public void buildRecordingsRequester(String credAccountId, String credAuthToken, String actingAccountId) throws Throwable {
		this.recordingsR = new RecordingsRequester(credAccountId, credAuthToken, actingAccountId);
		this.recordingsR.setPersyUrl("http://127.0.0.1:"+ Helper.getServerPort());
	}
	
	@Then("^check the acting accountId in the RecordingsRequester is (AC[0-9A-Fa-f]{40})$")
	public void checkActingAccountId(String accountId) {
		assertThat(this.recordingsR.getActingAccountId(), is(accountId));
	}
	
	@Then("^check the path in the RecordingsRequester is (/.*/AC[0-9A-Fa-f]{40}/[^\\s]*)$")
	public void checkPath(String path) {
		assertThat(this.recordingsR.getPath(), is(path));
	}

	@Then("^delete a recording with id (RE[0-9A-Fa-f]{40})$")
	public void canDeleteRecording(String recordingId) throws Throwable {
		Helper.getMockServer().when(
			request().withMethod("DELETE").withPath(this.recordingsR.getPath()+"/"+recordingId)
		).respond(
			response().withStatusCode(200)
		);

		this.recordingsR.delete(recordingId);

	}

	@Then("^get a recording with id (RE[0-9A-Fa-f]{40})$")
	public void canGetRecording(String recordingId) throws Throwable {
		Helper.getMockServer().when(
			request().withMethod("GET").withPath(this.recordingsR.getPath()+"/"+recordingId)
		).respond(
			response().withStatusCode(200).withBody(RecordingsRequesterTest.aTestRecording)
		);

		assertTrue(this.recordingsR.getMetaByRecordingId(recordingId).equals(Recording.fromJson(RecordingsRequesterTest.aTestRecording)));
	}

	@Then("^get a list of all recordings$")
	public void canGetRecordingsMeta() throws Throwable {
		Helper.getMockServer().when(
			request().withMethod("GET").withPath(this.recordingsR.getPath())
		).respond(
			response().withStatusCode(200).withBody(RecordingsRequesterTest.aTestRecordingList)
		);

		RecordingList rl = this.recordingsR.getMeta();
		RecordingList orig = new RecordingList("ACCOUNTID", "AUTHTOKEN", RecordingsRequesterTest.aTestRecordingList);
		assertThat(rl.getTotalSize(), is(orig.getTotalSize()));
		assertThat(rl.getLocalSize(), is(orig.getLocalSize()));
	}

	@Then("^get a list of recordings based on filters$")
	public void canGetFilteredRecordingsMeta() throws Throwable {
		String callId = "CAe1644a7eed5088b159577c5802d8be38";
		String conferenceId = "CFe1644a7eed5088b159577c5802d8be38";

		RecordingsSearchFilters filters = new RecordingsSearchFilters();
		HashMap<String, List<String>> listQuery = new HashMap<String,List<String>>();

		filters.setCallId(callId);
		filters.setConferenceId(conferenceId);
		listQuery.put("callId", new ArrayList<String>(Arrays.asList(callId)));
		listQuery.put("conferenceId", new ArrayList<String>(Arrays.asList(conferenceId)));


		Helper.getMockServer().when(
			request().withMethod("GET").withPath(this.recordingsR.getPath()).withQueryStringParameters(listQuery)
		).respond(
			response().withStatusCode(200).withBody(RecordingsRequesterTest.aTestRecordingList)
		);

		RecordingList rl = this.recordingsR.getMeta(filters);
		RecordingList orig = new RecordingList("ACCOUNTID", "AUTHTOKEN", RecordingsRequesterTest.aTestRecordingList);
		assertThat(rl.getTotalSize(), is(orig.getTotalSize()));
		assertThat(rl.getLocalSize(), is(orig.getLocalSize()));
	}

	@Then("^download a recording with id (RE[0-9A-Fa-f]{40}) using a Path$")
	public void downloadToFileWithPath(String recordingId) throws Throwable {
		Helper.getMockServer().when(
			request().withMethod("GET").withPath(this.recordingsR.getPath()+"/"+recordingId+"/Download")
		).respond(
			response().withStatusCode(200).withBody(RecordingsRequesterTest.testRecordingFile)
		);

		Path path = Files.createTempFile("RecByPath_", ".wav");

		Integer length = this.recordingsR.download(recordingId, path);

		this.checkDownloadResults(path);
	}

	@Then("^download a recording with id (RE[0-9A-Fa-f]{40}) using a File$")
	public void downloadToFileWithFile(String recordingId) throws Throwable {
		Helper.getMockServer().when(
			request().withMethod("GET").withPath(this.recordingsR.getPath()+"/"+recordingId+"/Download")
		).respond(
			response().withStatusCode(200).withBody(RecordingsRequesterTest.testRecordingFile)
		);

		Path path = Files.createTempFile("RecByFile_", ".wav");
		File file = path.toFile();

		Integer length = this.recordingsR.download(recordingId, file);

		this.checkDownloadResults(path);
	}

	@Then("^download a recording with id (RE[0-9A-Fa-f]{40}) using a String$")
	public void downloadToFileWithString(String recordingId) throws Throwable {
		//TODO - remove this println if it's no longer needed
		System.out.println(this.recordingsR.getPath()+"/"+recordingId);
		Helper.getMockServer().when(
			request().withMethod("GET").withPath(this.recordingsR.getPath()+"/"+recordingId+"/Download")
		).respond(
			response().withStatusCode(200).withBody(RecordingsRequesterTest.testRecordingFile)
		);

		Path path = Files.createTempFile("RecByString_", ".wav");

		Integer length = this.recordingsR.download(recordingId, path.toString());

		this.checkDownloadResults(path);
	}

	private void checkDownloadResults(Path path) throws Throwable {
		assertThat(Files.readAllBytes(path), is(RecordingsRequesterTest.testRecordingFile));

		Files.delete(path);
	}

	@Then("^download a recording with id (RE[0-9A-Fa-f]{40}) into a byte array$")
	public void downloadToArray(String recordingId) throws Throwable {
		Helper.getMockServer().when(
			request().withMethod("GET").withPath(this.recordingsR.getPath()+"/"+recordingId+"/Download")
		).respond(
			response().withStatusCode(200).withBody(RecordingsRequesterTest.testRecordingFile)
		);
		
		byte[] recordingBytes  = this.recordingsR.download(recordingId);
		assertTrue(recordingBytes.length > 0);
	}

	public void streamRecording(String recordingId) throws Throwable {
		Helper.getMockServer().when(
			request().withMethod("GET").withPath(this.recordingsR.getPath()+"/"+recordingId+"/Stream")
		).respond(
			response().withStatusCode(200).withBody(RecordingsRequesterTest.testRecordingFile)
		);

		KnownSizeInputStream ksis = this.recordingsR.stream(recordingId);

		int length = ksis.size();

		byte[] byts = new byte[length];
		BufferedInputStream bis = new BufferedInputStream(ksis);
		bis.read(byts, 0, length);
		assertThat(byts, is(RecordingsRequesterTest.testRecordingFile));
	}
}
