package com.vailsys.persephony.api.recording;

import java.util.HashMap;
import java.lang.reflect.Type;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.FieldPosition;

import static com.vailsys.persephony.json.PersyGson.PersyDateFormat;
import static com.vailsys.persephony.json.PersyGson.gson;

import com.google.gson.LongSerializationPolicy;
import com.google.gson.reflect.TypeToken;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class RecordingTest {
	private String origJSON;
	private String differentJSON;
	private Recording theRecording;

	@Given("^Some JSON representing a recording.$")
	public void storeJSON() {
		this.origJSON = "{ \"uri\": \"/Accounts/AC02d3270e16623d8f8c66d915cb00788370eff67e/Recordings/RE75570c2ca7a37c6d3c66f3d1e93dde884065f114\", \"revision\": 1, \"dateCreated\": \"Mon, 25 Jul 2016 16:37:27 GMT\", \"dateUpdated\": \"Mon, 25 Jul 2016 16:37:27 GMT\", \"recordingId\": \"RE75570c2ca7a37c6d3c66f3d1e93dde884065f114\", \"accountId\": \"AC02d3270e16623d8f8c66d915cb00788370eff67e\", \"callId\": \"CA06f14ae326d325a5eda311d4f3454eef357b4d09\", \"durationSec\": 5 }";
		this.differentJSON = "{ \"uri\": \"/Accounts/AC02d3270e16623d8f8c66d915cb00788370eff67e/Recordings/RE75570c2ca7a37c6d3c66f3d1e93dde884065f114\", \"revision\": 1, \"dateCreated\": \"Mon, 25 Jul 2016 16:37:27 GMT\", \"dateUpdated\": \"Mon, 25 Jul 2016 16:37:27 GMT\", \"recordingId\": \"RE75570c2ca7a37c6d3c66f3d1e93dde884065f114\", \"accountId\": \"02d3270e16623d8f8c66d915cb00788370eff67e\", \"callId\": \"CA06f14ae326d325a5eda311d4f3454eef357b4d09\", \"durationSec\": 5 }";
	}

	@Then("^build a Recording object from that JSON.$")
	public void buildRecording() throws Throwable {
		this.theRecording = Recording.fromJson(origJSON);
	}

	@Then("^check that it can be checked for equality$")
	public void checkEquals() throws Throwable {
		assertTrue(this.theRecording.equals(Recording.fromJson(this.origJSON)));
		assertFalse(this.theRecording.equals(Recording.fromJson(this.differentJSON)));
	}

}
