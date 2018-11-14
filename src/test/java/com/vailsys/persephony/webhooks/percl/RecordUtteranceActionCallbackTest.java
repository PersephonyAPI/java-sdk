package com.vailsys.persephony.webhooks.percl;

import com.vailsys.persephony.api.call.CallStatus;
import com.vailsys.persephony.api.call.Direction;
import com.vailsys.persephony.webhooks.RequestType;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.notNullValue;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class RecordUtteranceActionCallbackTest {
	
	private RecordUtteranceActionCallback rusc;
	private static final String RUSC_JSON = "{ \"accountId\": \"ACae05391ecca1352e9108d545482a1e6f384e7a49\", \"callDuration\": 41, \"callId\": \"CAbde0362aef3d228b3a39baafa9e4f0204e724966\", \"callStatus\": \"completed\", \"conferenceId\": null, \"direction\": \"inbound\", \"from\": \"+17083168669\", \"parentCallId\": null, \"queueId\": null, \"requestId\": \"RQa766ca5ee92fc6c528b72aff5e8b48f5f4e056e8\", \"requestType\": \"record\", \"to\": \"+12248806211\", \"recordingSize\": 1002, \"recordingFormat\": \"wav\", \"recordingDurationSec\": 22, \"termReason\": \"timeout\", \"recordingUrl\":\"http://some.url\", \"recordingId\":\"RE123456789a123456789b123456789c123456789d\"}";

	@Given("^A RecordUtteranceActionCallback object$")
	public void newRUSC() {
		try {
			this.rusc = RecordUtteranceActionCallback.createFromJson(RecordUtteranceActionCallbackTest.RUSC_JSON);
		} catch(Exception e) {
			fail(e.getMessage());
		}
		assertThat(this.rusc, notNullValue());
	}

	@Then("^verify the RecordUtteranceActionCallback's contents$")
	public void verifyContents() throws Throwable {
		assertThat(this.rusc.getAccountId(), is("ACae05391ecca1352e9108d545482a1e6f384e7a49"));
		assertThat(this.rusc.getCallId(), is("CAbde0362aef3d228b3a39baafa9e4f0204e724966"));
		assertThat(this.rusc.getCallStatus(), is(CallStatus.COMPLETED));
		assertThat(this.rusc.getConferenceId(), is(nullValue()));
		assertThat(this.rusc.getDirection(), is(Direction.INBOUND));
		assertThat(this.rusc.getFrom(), is("+17083168669"));
		assertThat(this.rusc.getQueueId(), is(nullValue()));
		assertThat(this.rusc.getRequestId(), is("RQa766ca5ee92fc6c528b72aff5e8b48f5f4e056e8"));
		assertThat(this.rusc.getRequestType(), is(RequestType.RECORD));
		assertThat(this.rusc.getTo(), is("+12248806211"));

		assertThat(this.rusc.getRecordingUrl(), is("http://some.url"));
		assertThat(this.rusc.getRecordingId(), is("RE123456789a123456789b123456789c123456789d"));
		assertThat(this.rusc.getRecordingSize(), is(1002));
		assertThat(this.rusc.getRecordingFormat(), is("wav"));
		assertThat(this.rusc.getRecordingDurationSec(), is(22));
		assertThat(this.rusc.getTermReason(), is(TermReason.TIMEOUT));
	}

}
