package com.vailsys.persephony.webhooks;

import com.vailsys.persephony.api.call.CallStatus;
import com.vailsys.persephony.api.call.Direction;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;

public class StatusCallbackTest {
	private StatusCallback sc;

	@Given("^Given Some JSON create a StatusCallback$")
	public void createStatusCallback() throws Throwable {
		this.sc = StatusCallback.fromJson("{ \"accountId\": \"ACae05391ecca1352e9108d545482a1e6f384e7a49\", \"callDuration\": 41, \"callId\": \"CAbde0362aef3d228b3a39baafa9e4f0204e724966\", \"callStatus\": \"completed\", \"conferenceId\": null, \"direction\": \"inbound\", \"from\": \"+17083168669\", \"parentCallId\": null, \"queueId\": null, \"requestId\": \"RQa766ca5ee92fc6c528b72aff5e8b48f5f4e056e8\", \"requestType\": \"callStatus\", \"to\": \"+12248806211\", \"recordingUrl\":\"http://some.url\", \"recordingId\":\"RE123456789a123456789b123456789c123456789d\",\"recordingDurationSec\":13 }");
	}	

	@Then("^verify the StatusCallback's contents$")
	public void verifyContents() {
		assertThat(this.sc.getAccountId(), is("ACae05391ecca1352e9108d545482a1e6f384e7a49"));
		assertThat(this.sc.getCallDuration(), is(41));
		assertThat(this.sc.getCallId(), is("CAbde0362aef3d228b3a39baafa9e4f0204e724966"));
		assertThat(this.sc.getCallStatus(), is(CallStatus.COMPLETED));
		assertThat(this.sc.getConferenceId(), is(nullValue()));
		assertThat(this.sc.getDirection(), is(Direction.INBOUND));
		assertThat(this.sc.getFrom(), is("+17083168669"));
		assertThat(this.sc.getParentCallId(), is(nullValue()));
		assertThat(this.sc.getQueueId(), is(nullValue()));
		assertThat(this.sc.getRequestId(), is("RQa766ca5ee92fc6c528b72aff5e8b48f5f4e056e8"));
		assertThat(this.sc.getRequestType(), is(RequestType.CALL_STATUS));
		assertThat(this.sc.getTo(), is("+12248806211"));
		assertThat(this.sc.getRecordingUrl(), is("http://some.url"));
		assertThat(this.sc.getRecordingId(), is("RE123456789a123456789b123456789c123456789d"));
		assertThat(this.sc.getRecordingDurationSec(), is(13));
		assertThat(this.sc.getParentCallId(), is(nullValue()));
	}
}

