package com.vailsys.persephony.api.log;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

public class LogListTest {
    private LogList list;

    private String logJson = "{\"hostname\":\"spv07vcs10\",\"subsystem\":\"vcsserver\",\"timestamp\":1486067190316387,\"scope\":\"public\",\"level\":\"info\",\"accountId\":\"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\",\"requestId\":\"RQ6e194dc130b821bbc809b92ab3aeaecdc913e9d4\",\"callId\":\"CA6e194dc130b821bbc809b92ab3aeaecdc913e9d4\",\"message\":\"Customer Request : POST http://ahaynes-ltw.vpn.vail:8080/QueueingTutorial/InboundCall\",\"metadata\":{\"requestBody\":{\"accountId\":\"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\",\"callId\":\"CA6e194dc130b821bbc809b92ab3aeaecdc913e9d4\",\"callStatus\":\"ringing\",\"conferenceId\":null,\"direction\":\"inbound\",\"from\":\"+13124237329\",\"parentCallId\":null,\"queueId\":null,\"requestType\":\"inboundCall\",\"to\":\"+13126514126\"},\"requestHeaders\":{\"X-Pulse-Signature\":\"3086d3d55e1f7e2fabbf18d4afa607f386f912dc\",\"X-Pulse-Timestamp\":1486067190,\"url\":\"http://ahaynes-ltw.vpn.vail:8080/QueueingTutorial/InboundCall\"}}}";

    private String listJson = "{\"total\":1, \"start\":0, \"end\":0, \"page\":0,\"numPages\":1,\"pageSize\":1, \"nextPageUri\":null, \"logs\": [" + this.logJson + "]}";


    @Given("^a LogList object$")
    public void create() throws Throwable {
        list = new LogList("ACCOUNTID", "AUTHTOKEN", listJson);
    }

    @Then("^check that the LogList was built correctly$")
    public void checkList() throws Throwable{
        assertThat(list.getLocalSize(), is(1));
        assertThat(list.getTotalSize(), is(1));
        assertTrue(list.get(0).equals(Log.fromJson(logJson)));
    }

}
