package com.vailsys.persephony.webhooks.percl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;

public class GetDigitsActionCallbackTest {
    private GetDigitsActionCallback gdac;
    private static final String GDAC_JSON = "{ \"accountId\": \"ACae05391ecca1352e9108d545482a1e6f384e7a49\", \"callDuration\": 41, \"callId\": \"CAbde0362aef3d228b3a39baafa9e4f0204e724966\", \"callStatus\": \"completed\", \"conferenceId\": null, \"direction\": \"inbound\", \"from\": \"+17083168669\", \"parentCallId\": null, \"queueId\": null, \"requestId\": \"RQa766ca5ee92fc6c528b72aff5e8b48f5f4e056e8\", \"requestType\": \"getDigits\", \"to\": \"+12248806211\", \"digits\":\"123\", \"reason\":\"minDigits\"}";

    @Given("^A GetDigitsActionCallback object$")
    public void newGDAC() throws Throwable {
        this.gdac = GetDigitsActionCallback.createFromJson(GetDigitsActionCallbackTest.GDAC_JSON);
    }

    @Then("^verify the GetDigitsActionCallback's contents$")
    public void verifyContents() throws Throwable {
        assertThat(this.gdac.getAccountId(), is("ACae05391ecca1352e9108d545482a1e6f384e7a49"));
        assertThat(this.gdac.getReason(), is(DigitReason.MIN_DIGITS));
        assertThat(this.gdac.getDigits().toString(), is("123"));
    }
}
