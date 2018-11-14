package com.vailsys.persephony.api.log;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.JsonBody;
import org.mockserver.verify.VerificationTimes;
import world.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.vailsys.persephony.json.PersyGson.gson;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class LogRequesterTest {
    private LogRequester requester;
    private String logJson = "{\"hostname\":\"spv07vcs10\",\"subsystem\":\"vcsserver\",\"timestamp\":1486067190316387,\"scope\":\"public\",\"level\":\"info\",\"accountId\":\"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\",\"requestId\":\"RQ6e194dc130b821bbc809b92ab3aeaecdc913e9d4\",\"callId\":\"CA6e194dc130b821bbc809b92ab3aeaecdc913e9d4\",\"message\":\"Customer Request : POST http://ahaynes-ltw.vpn.vail:8080/QueueingTutorial/InboundCall\",\"metadata\":{\"requestBody\":{\"accountId\":\"AC6910fbcfaffb781e7dda33864003df692dc6c5ac\",\"callId\":\"CA6e194dc130b821bbc809b92ab3aeaecdc913e9d4\",\"callStatus\":\"ringing\",\"conferenceId\":null,\"direction\":\"inbound\",\"from\":\"+13124237329\",\"parentCallId\":null,\"queueId\":null,\"requestType\":\"inboundCall\",\"to\":\"+13126514126\"},\"requestHeaders\":{\"X-Pulse-Signature\":\"3086d3d55e1f7e2fabbf18d4afa607f386f912dc\",\"X-Pulse-Timestamp\":1486067190,\"url\":\"http://ahaynes-ltw.vpn.vail:8080/QueueingTutorial/InboundCall\"}}}";

    private String listJson = "{\"total\":1, \"start\":0, \"end\":0, \"page\":0,\"numPages\":1,\"pageSize\":1, \"nextPageUri\":null, \"logs\": [" + this.logJson + "]}";


    @Given("^a LogRequester with the credentials (.*) and (.*) and using the accountId (.*)$")
    public void create(String accountId, String authToken, String actingId) throws Throwable {
        requester = new LogRequester(accountId, authToken, actingId);
        requester.setPersyUrl("http://127.0.0.1:" + Helper.getServerPort());
    }

    @Then("^check the LogRequester acting accountId is (.*)$")
    public void assertActingId(String acting){
        assertThat(requester.getActingAccountId(), is(acting));
    }

    @Then("^check the LogRequester path is (.*)$")
    public void assertPath(String path){
        assertThat(requester.getPath(), is(path));
    }

    @Then("^list logs without a query$")
    public void getList() throws Throwable {
        Helper.getMockServer().when(
                request().withMethod("GET").withPath(requester.getPath())
        ).respond(
                response().withStatusCode(200).withBody(listJson)
        );
        LogList ll = requester.get();
        LogList orig = new LogList("AccountID", "AUTHTOKEN", listJson);
        assertThat(ll.getLocalSize(), is(orig.getLocalSize()));
        assertThat(ll.getTotalSize(), is(orig.getTotalSize()));
        assertTrue(ll.get(0).equals(orig.get(0)));
    }

    @Then("^list logs with a query$")
    public void getFilteredList() throws Throwable {
        LogSearchFilters filters = new LogSearchFilters();
        filters.setPql("level=\"info\"");

        Helper.getMockServer().when(
                request().withMethod("POST").withPath(requester.getPath()).withBody(gson.toJson(filters))
        ).respond(
                response().withStatusCode(200).withBody(listJson)
        );

        LogList ll = requester.get(filters);
        LogList orig = new LogList("ACCOUNTID", "AUTHTOKEN", listJson);

        assertThat(ll.getLocalSize(), is(orig.getLocalSize()));
        assertThat(ll.getTotalSize(), is(orig.getTotalSize()));
        assertTrue(ll.get(0).equals(orig.get(0)));
    }

    @Then("^list logs with a query and requestId (.*)$")
    public void getFilteredList(String requestId) throws Throwable {
        LogSearchFilters filters = new LogSearchFilters();
        filters.setPql("level=\"info\"");
        filters.setRequestId(requestId);

        Helper.getMockServer().when(
                request().withMethod("POST").withPath(requester.getPath()).withBody(gson.toJson(filters))
        ).respond(
                response().withStatusCode(200).withBody(listJson)
        );

        LogList ll = requester.get(filters);
        LogList orig = new LogList("ACCOUNTID", "AUTHTOKEN", listJson);

        assertThat(ll.getLocalSize(), is(orig.getLocalSize()));
        assertThat(ll.getTotalSize(), is(orig.getTotalSize()));
        assertTrue(ll.get(0).equals(orig.get(0)));

        Helper.getMockServer().verify(
                request().withMethod("POST").withPath(requester.getPath()).withBody(new JsonBody("{pql:'" + filters.getPql() + "',requestId:'" + requestId + "'}")), VerificationTimes.exactly(1)
        );
    }
}
