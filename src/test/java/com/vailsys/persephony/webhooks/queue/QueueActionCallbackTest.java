package com.vailsys.persephony.webhooks.queue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class QueueActionCallbackTest {
    private QueueActionCallback qac;
    private static String qac_json = "{\"requestId\":\"RA1766ca5ee92fc6c528b72aff5e8b48f4e056e8\", \"requestType\":\"dequeue\", \"callId\":\"CAbde0362aef3d228b3a39baafa9e4f0204e724966\", \"accountId\":\"ACae05391ecca1352e9108d545482a1e6f384e7a49\", \"from\":\"+17083168669\", \"to\":\"+12248806211\", \"callStatus\":\"queued\", \"direction\":\"inbound\", \"conferenceId\":null, \"queueId\":\"QU123432345678432345783a34c327d324b42398f\",\"callerInfo\":null, \"queueTime\":23, \"queueResult\":\"dequeued\"}";

    @Given("^a QueueActionCallbackObject$")
    public void newQac() throws Throwable {
        this.qac = QueueActionCallback.createFromJson(qac_json);
    }

    @Then("^verify the QueueActionCallback's content$")
    public void verifyContents(){
        assertThat(this.qac.getQueueResult(), is(QueueResult.DEQUEUED));
        assertThat(this.qac.getQueueTime(), is(23));

    }

}
