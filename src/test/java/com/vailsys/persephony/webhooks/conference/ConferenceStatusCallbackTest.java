package com.vailsys.persephony.webhooks.conference;

import com.vailsys.persephony.api.conference.ConferenceStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class ConferenceStatusCallbackTest {
    private ConferenceStatusCallback csc;
    private static String csc_json = " { \"requestId\":\"RA1766ca5ee92fc6c528b72aff5e8b48f4e056e8\", \"requestType\":\"conferenceStatus\", \"callId\":null, \"accountId\":\"ACae05391ecca1352e9108d545482a1e6f384e7a49\", \"from\":null, \"to\":null,\"callStatus\":null, \"direction\":null, \"conferenceId\":\"CFbde0362aef3d228b3a39baafa9e4f0204e724966\", \"queueId\":null, \"callerInfo\":null, \"parentCallId\":null, \"callDuration\":null, \"recordingUrl\":\"http://www.persephony.com/recordings/CF34244a34e745ce98b7\", \"recordingId\":\"RC12345\", \"recordingDuration\" : 22, \"status\":\"populated\"}";

    @Given("^a ConferenceStatusCallbackObject$")
    public void newCsc() throws Throwable {
        this.csc = ConferenceStatusCallback.createFromJson(csc_json);
    }

    @Then("^verify the ConferenceStatusCallback's content$")
    public void verifyContents() throws Throwable {
        assertThat(this.csc.getStatus(), is(ConferenceStatus.POPULATED));
    }
}
