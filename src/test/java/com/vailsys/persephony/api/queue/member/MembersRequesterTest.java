package com.vailsys.persephony.api.queue.member;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.mockserver.model.JsonBody;
import world.Helper;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertTrue;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;


public class MembersRequesterTest {
    private MembersRequester memR;

    private static String testMember = "{\"uri\":\"/Accounts/AC3109606ad01a4f367ea2e54f1e44d5c187b7c837/Queues/QUeda341f1fba015aa029a3342f23a3ae0c45e302b/Members/CAb933917ae0d3547bd65da77a4aa50e0329850401\",\"callId\":\"CAb933917ae0d3547bd65da77a4aa50e0329850401\",\"waitTime\":0,\"position\":1,\"dateEnqueued\":\"Thu, 13 Oct 2016 18:28:58 GMT\"}";
    private static String testMemberList = "{\"total\": 1, \"start\": 0, \"end\": 0, \"page\": 0, \"numPages\": 1, \"pageSize\": 1, \"nextPageUri\": null, \"queueMembers\": [" + MembersRequesterTest.testMember + "]}";

    @Given("^a MembersRequester with the credentials (.*) and (.*) and using the accountId (.*) and using the queuePath (.*)$")
    public void createMembersRequester(String credId, String credAuth, String accountId, String queuePath){
        this.memR = new MembersRequester(credId, credAuth, accountId, queuePath);
        this.memR.setPersyUrl("http://127.0.0.1:" + Helper.getServerPort());
    }

    @Then("^check the MembersRequester acting accountId is (.*)$")
    public void getActingAccountId(String accountId){
        assertThat(this.memR.getActingAccountId(), is(accountId));
    }

    @Then("^check the MembersRequester path is (.*)$")
    public void getPath(String path){
        assertThat(this.memR.getPath(), is(path));
    }

    @Then("^get a list of members$")
    public void getMemberList() throws Throwable {
        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.memR.getPath())
        ).respond(
                response().withStatusCode(200).withBody(MembersRequesterTest.testMemberList)
        );

        MemberList ml = this.memR.get();
        MemberList orig = new MemberList("ACCOUNTID", "AUTHTOKEN", MembersRequesterTest.testMemberList);
        assertThat(ml.getTotalSize(), is(orig.getTotalSize()));
        assertThat(ml.getLocalSize(), is(orig.getLocalSize()));
    }

    @Then("^get a member by callId$")
    public void getMemberByCallId() throws Throwable {
        String callId = "CAb933917ae0d3547bd65da77a4aa50e0329850401";
        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.memR.getPath() + "/" + callId)
        ).respond(
                response().withStatusCode(200).withBody(MembersRequesterTest.testMember)
        );

        Member m = this.memR.get(callId);
        Member orig = Member.fromJson(MembersRequesterTest.testMember);
        assertTrue(m.equals(orig));
    }

    @Then("^get a member by Front$")
    public void getMemberByFront() throws Throwable {
        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.memR.getPath() + "/Front")
        ).respond(
                response().withStatusCode(200).withBody(MembersRequesterTest.testMember)
        );

        Member m = this.memR.getFront();
        Member orig = Member.fromJson(MembersRequesterTest.testMember);
        assertTrue(m.equals(orig));
    }

    @Then("^dequeue a member by callId$")
    public void dequeueMemberByCallId() throws Throwable {
        String callId = "CAb933917ae0d3547bd65da77a4aa50e0329850401";
        Helper.getMockServer().when(
                request().withMethod("POST").withPath(this.memR.getPath() + "/" + callId)
        ).respond(
                response().withStatusCode(200).withBody(MembersRequesterTest.testMember)
        );

        Member m = this.memR.dequeue(callId);
        Member orig = Member.fromJson(MembersRequesterTest.testMember);
        assertTrue(m.equals(orig));
    }

    @Then("^dequeue a member by callId with requestId (.*)$")
    public void dequeueMemberByCallId(String requestId) throws Throwable {
        String callId = "CAb933917ae0d3547bd65da77a4aa50e0329850401";
        Helper.getMockServer().when(
                request().withMethod("POST").withPath(this.memR.getPath() + "/" + callId).withBody(new JsonBody("{requestId:'" + requestId +"'}"))
        ).respond(
                response().withStatusCode(200).withBody(MembersRequesterTest.testMember)
        );

        Member m = this.memR.dequeue(callId, requestId);
        Member orig = Member.fromJson(MembersRequesterTest.testMember);
        assertTrue(m.equals(orig));
    }

    @Then("^dequeue a member by Front$")
    public void dequeueMemberByFront() throws Throwable {
        Helper.getMockServer().when(
                request().withMethod("POST").withPath(this.memR.getPath() + "/Front")
        ).respond(
                response().withStatusCode(200).withBody(MembersRequesterTest.testMember)
        );

        Member m = this.memR.dequeueFront();
        Member orig = Member.fromJson(MembersRequesterTest.testMember);
        assertTrue(m.equals(orig));
    }

    @Then("^dequeue a member by Front with requestId (.*)$")
    public void dequeueMemberByFront(String requestId) throws Throwable {
        Helper.getMockServer().when(
                request().withMethod("POST").withPath(this.memR.getPath() + "/Front").withBody(new JsonBody("{requestId:'"+ requestId + "'}"))
        ).respond(
                response().withStatusCode(200).withBody(MembersRequesterTest.testMember)
        );

        Member m = this.memR.dequeueFront(requestId);
        Member orig = Member.fromJson(MembersRequesterTest.testMember);
        assertTrue(m.equals(orig));
    }

}
