package com.vailsys.persephony.api.log;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static com.vailsys.persephony.json.PersyGson.gson;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

public class LogTest {
    private Log log;
    private String logJson;

    @Given("^some JSON representing a log$")
    public void initialize(){
        logJson = "{\"hostname\":\"spv07vcs10\",\"subsystem\":\"vcsserver\",\"timestamp\":1486067190316387,\"scope\":\"public\",\"level\":\"info\",\"accountId\":\"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\",\"requestId\":\"RQ6e194dc130b821bbc809b92ab3aeaecdc913e9d4\",\"callId\":\"CA6e194dc130b821bbc809b92ab3aeaecdc913e9d4\",\"message\":\"Customer Request : POST http://ahaynes-ltw.vpn.vail:8080/QueueingTutorial/InboundCall\",\"metadata\":{\"requestBody\":{\"accountId\":\"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\",\"callId\":\"CA6e194dc130b821bbc809b92ab3aeaecdc913e9d4\",\"callStatus\":\"ringing\",\"conferenceId\":null,\"direction\":\"inbound\",\"from\":\"+13124237329\",\"parentCallId\":null,\"queueId\":null,\"requestType\":\"inboundCall\",\"to\":\"+13126514126\"},\"requestHeaders\":{\"X-Pulse-Signature\":\"3086d3d55e1f7e2fabbf18d4afa607f386f912dc\",\"X-Pulse-Timestamp\":1486067190,\"url\":\"http://ahaynes-ltw.vpn.vail:8080/QueueingTutorial/InboundCall\"}}}";
    }

    @Then("^build a Log object from that JSON$")
    public void build() throws Throwable {
        log = Log.fromJson(logJson);
    }

    @Then("^check the contents of the Log$")
    public void checkContents(){
        assertThat(log.getTimestamp(), is(1486067190316387L));
        assertThat(log.getLevel(), is(Level.INFO));
        assertThat(log.getAccountId(), is("AC6910fbcfaffb781e7dda33864003df692dc6c5ac"));
        assertThat(log.getRequestId(), is("RQ6e194dc130b821bbc809b92ab3aeaecdc913e9d4"));
        assertThat(log.getCallId(), is("CA6e194dc130b821bbc809b92ab3aeaecdc913e9d4"));
        assertThat(log.getMessage(), is("Customer Request : POST http://ahaynes-ltw.vpn.vail:8080/QueueingTutorial/InboundCall"));

        JsonObject rb = new JsonObject();
        rb.addProperty("accountId", "AC6910fbcfaffb781e7dda33864003df692dc6c5ac");
        rb.addProperty("callId", "CA6e194dc130b821bbc809b92ab3aeaecdc913e9d4");
        rb.addProperty("callStatus", "ringing");
        rb.add("conferenceId", null);
        rb.addProperty("direction","inbound");
        rb.addProperty("from", "+13124237329");
        rb.add("parentCallId", null);
        rb.add("queueId", null);
        rb.addProperty("requestType", "inboundCall");
        rb.addProperty("to", "+13126514126");

        JsonObject rh = new JsonObject();
        rh.addProperty("X-Pulse-Signature", "3086d3d55e1f7e2fabbf18d4afa607f386f912dc");
        rh.addProperty("X-Pulse-Timestamp",1486067190);
        rh.addProperty("url","http://ahaynes-ltw.vpn.vail:8080/QueueingTutorial/InboundCall");

        JsonObject meta = new JsonObject();
        meta.add("requestBody", rb);
        meta.add("requestHeaders", rh);


        assertThat(log.getMetadata(), is(meta));
    }

    @Then("^compare the Log to equal and unequal objects$")
    public void compare() throws Throwable {
        assertTrue(log.equals(Log.fromJson(logJson)));
        logJson = "{\"hostname\":\"spv07vcs10\",\"subsystem\":\"vcsserver\",\"timestamp\":1486067190316387,\"scope\":\"public\",\"level\":\"info\",\"accountId\":\"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\",\"requestId\":\"RQ6e194dc130b821bbc809b92ab3aeaecdc913e9d4\",\"callId\":\"CA6e194dc130b821bbc809b92ab3aeaecdc913e9d4\",\"message\":\"Different Message\",\"metadata\":{\"requestBody\":{\"accountId\":\"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\",\"callId\":\"CA6e194dc130b821bbc809b92ab3aeaecdc913e9d4\",\"callStatus\":\"ringing\",\"conferenceId\":null,\"direction\":\"inbound\",\"from\":\"+13124237329\",\"parentCallId\":null,\"queueId\":null,\"requestType\":\"inboundCall\",\"to\":\"+13126514126\"},\"requestHeaders\":{\"X-Pulse-Signature\":\"3086d3d55e1f7e2fabbf18d4afa607f386f912dc\",\"X-Pulse-Timestamp\":1486067190,\"url\":\"http://ahaynes-ltw.vpn.vail:8080/QueueingTutorial/InboundCall\"}}}";

        assertFalse(log.equals(Log.fromJson(logJson)));
    }
}
