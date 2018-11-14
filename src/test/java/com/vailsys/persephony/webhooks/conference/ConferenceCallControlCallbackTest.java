package com.vailsys.persephony.webhooks.conference;

import com.vailsys.persephony.api.call.CallStatus;
import com.vailsys.persephony.webhooks.RequestType;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;

public class ConferenceCallControlCallbackTest {
    private ConferenceCallControlCallback cccc;
    private static String CCCC_JSON = " { \"requestId\":\"RA1766ca5ee92fc6c528b72aff5e8b48f4e056e8\", \"callId\":\"CA12345\", \"accountId\":\"ACae05391ecca1352e9108d545482a1e6f384e7a49\", \"from\":\"+17083168669\", \"to\":\"+12248806211\",\"callStatus\":\"inProgress\", \"direction\":\"inbound\", \"conferenceId\":\"CFbde0362aef3d228b3a39baafa9e4f0204e724966\", \"queueId\":null, \"parentCallId\":null, \"digits\":\"1\", \"requestType\":\"conferenceCallControl\"}";

    @Given("^a ConferenceCallControlCallback$")
    public void newCccc() throws Throwable {
        this.cccc = ConferenceCallControlCallback.createFromJson(CCCC_JSON);
    }

    @Then("^verify the ConferenceCallControlCallback's contents$")
    public void verifyContents(){
        assertThat(this.cccc.getRequestType(), is(RequestType.CONFERENCE_CALL_CONTROL));
        assertTrue(this.cccc.getConferenceId() != null);
        assertTrue(this.cccc.getCallId() != null);
        assertThat(this.cccc.getDigits(), is("1"));
    }

}
