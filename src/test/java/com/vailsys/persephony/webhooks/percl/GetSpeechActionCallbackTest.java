package com.vailsys.persephony.webhooks.percl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class GetSpeechActionCallbackTest {
    private GetSpeechActionCallback gsac;
    private static final String GSAC_JSON= " { \"requestId\":\"RA1766ca5ee92fc6c528b72aff5e8b48f4e056e8\", \"requestType\":\"getSpeech\", \"callId\":\"CAbde0362aef3d228b3a39baafa9e4f0204e724966\", \"accountId\":\"ACae05391ecca1352e9108d545482a1e6f384e7a49\", \"from\":\"+17083168669\", \"to\":\"+12248806211\",\"callStatus\":\"completed\", \"direction\":\"inbound\", \"conferenceId\":null, \"queueId\":null, \"callerInfo\":null, \"reason\":\"recognition\", \"recognitionResult\":\"yellow\", \"confidence\":55 }";

    @Given("^A GetSpeechActionCallback object$")
    public void newGSAC() throws Throwable{
        this.gsac = GetSpeechActionCallback.createFromJson(GSAC_JSON);
    }

    @Then("^verify the GetSpeechActionCallback's contents$")
    public void verifyContents() throws Throwable{
        assertThat(this.gsac.getReason(), is(SpeechReason.RECOGNITION));
        assertThat(this.gsac.getRecognitionResult(), is("yellow"));
        assertThat(this.gsac.getConfidence(), is(55));
    }

}
