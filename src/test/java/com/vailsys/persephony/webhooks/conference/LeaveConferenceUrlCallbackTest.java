package com.vailsys.persephony.webhooks.conference;

import com.vailsys.persephony.api.call.CallStatus;
import com.vailsys.persephony.webhooks.RequestType;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;

public class LeaveConferenceUrlCallbackTest {
    private LeaveConferenceUrlCallback lcuc;
    //requestType is explicitly absent, the identifying factor is having both a callId and conferenceId.
    private static String LCUC_JSON = " { \"requestId\":\"RA1766ca5ee92fc6c528b72aff5e8b48f4e056e8\", \"callId\":\"CA12345\", \"accountId\":\"ACae05391ecca1352e9108d545482a1e6f384e7a49\", \"from\":\"+17083168669\", \"to\":\"+12248806211\",\"callStatus\":\"inProgress\", \"direction\":\"inbound\", \"conferenceId\":\"CFbde0362aef3d228b3a39baafa9e4f0204e724966\", \"queueId\":null, \"callerInfo\":null, \"parentCallId\":null, \"requestType\":\"leaveConference\"}";

    @Given("^a LeaveConferenceUrlCallback$")
    public void newCcac() throws Throwable {
        this.lcuc = LeaveConferenceUrlCallback.createFromJson(LCUC_JSON);
    }

    @Then("^verify the LeaveConferenceUrlCallback's contents$")
    public void verifyContents(){
        assertThat(this.lcuc.getRequestType(), is(RequestType.LEAVE_CONFERENCE));
        assertTrue(this.lcuc.getConferenceId() != null);
        assertTrue(this.lcuc.getCallId() != null);
        assertThat(this.lcuc.getCallStatus(), is(CallStatus.IN_PROGRESS));
    }

}
