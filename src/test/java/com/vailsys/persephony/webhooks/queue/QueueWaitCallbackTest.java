package com.vailsys.persephony.webhooks.queue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class QueueWaitCallbackTest {
    private QueueWaitCallback qwc;
    private static String qwc_json = "{\"requestId\":\"RA1766ca5ee92fc6c528b72aff5e8b48f4e056e8\", \"requestType\":\"queueWait\", \"callId\":\"CAbde0362aef3d228b3a39baafa9e4f0204e724966\", \"accountId\":\"ACae05391ecca1352e9108d545482a1e6f384e7a49\", \"from\":\"+17083168669\", \"to\":\"+12248806211\", \"callStatus\":\"queued\", \"direction\":\"inbound\", \"conferenceId\":null, \"queueId\":\"QU123432345678432345783a34c327d324b42398f\",\"callerInfo\":null, \"queuePosition\":1, \"queueTime\":12,\"averageQueueTime\":32,\"currentQueueSize\":3 }";

    @Given("^a QueueWaitCallbackObject$")
    public void newQwc() throws Throwable {
        this.qwc = QueueWaitCallback.createFromJson(qwc_json);
    }

    @Then("^verify the QueueWaitCallback's content$")
    public void verifyContents() throws Throwable {
        assertThat(this.qwc.getQueuePosition(), is(1));
        assertThat(this.qwc.getQueueTime(), is(12));
        assertThat(this.qwc.getAverageQueueTime(), is(32));
        assertThat(this.qwc.getCurrentQueueSize(), is(3));
    }
}
