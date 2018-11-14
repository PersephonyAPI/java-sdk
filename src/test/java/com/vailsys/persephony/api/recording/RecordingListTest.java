package com.vailsys.persephony.api.recording;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class RecordingListTest {

	private static String testRecording = "{ \"uri\": \"/Accounts/AC02d3270e16623d8f8c66d915cb00788370eff67e/Recordings/RE75570c2ca7a37c6d3c66f3d1e93dde884065f114\", \"revision\": 1, \"dateCreated\": \"Mon, 25 Jul 2016 16:37:27 GMT\", \"dateUpdated\": \"Mon, 25 Jul 2016 16:37:27 GMT\", \"recordingId\": \"RE75570c2ca7a37c6d3c66f3d1e93dde884065f114\", \"accountId\": \"AC02d3270e16623d8f8c66d915cb00788370eff67e\", \"callId\": \"CA06f14ae326d325a5eda311d4f3454eef357b4d09\", \"durationSec\": 5 }";


	private static String inputJson = "{\"total\": 1, \"start\": 0, \"end\": 0, \"page\": 0, \"numPages\": 1, \"pageSize\": 1, \"nextPageUri\": null, \"recordings\": ["+RecordingListTest.testRecording+"]}";

	private RecordingList list;
	
	@Given("^a RecordingList object.$")
	public void makeListFromJson() throws Throwable {
		this.list = new RecordingList("ACCOUNTID", "AUTHTOKEN", RecordingListTest.inputJson);
	}

	@Then("^check that the RecordingList was built correctly.$")
	public void checkList() {
		assertThat(this.list.getLocalSize(), is(1));
	}
}
