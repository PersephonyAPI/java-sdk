package com.vailsys.persephony.webhooks.call;

import com.vailsys.persephony.api.call.AnsweredBy;
import com.vailsys.persephony.api.call.CallStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class VoiceCallbackTest {
    private VoiceCallback csb;
    private static String json = "{\"accountId\":\"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\",\"callId\": \"CAf640c8d89e0f7f812d9266b8bd523e3b2b188072\", \"dialCallStatus\": \"ringing\",\"conferenceId\": null,\"direction\": \"inbound\",\"from\": \"+17735699774\",\"parentCallId\": null,\"queueId\": null,\"requestType\": \"callStatus\",\"to\": \"+13122356088\", \"answeredBy\":\"machine\" }";
    @Given("^some JSON create a VoiceCallback$")
    public void createCSB() throws Throwable {
        csb = VoiceCallback.createFromJson(json);
    }

    @Then("^verify the VoiceCallback's contents$")
    public void verifyContents(){
        assertThat(this.csb.getAnsweredBy(), is(AnsweredBy.MACHINE));
        assertThat(this.csb.getDialCallStatus(), is(CallStatus.RINGING));
    }


}
