package com.vailsys.persephony.api.queue.member;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class MemberListTest {
    private static String testMember = "{\"uri\":\"/Accounts/AC3109606ad01a4f367ea2e54f1e44d5c187b7c837/Queues/QUeda341f1fba015aa029a3342f23a3ae0c45e302b/Members/CAb933917ae0d3547bd65da77a4aa50e0329850401\",\"callId\":\"CAb933917ae0d3547bd65da77a4aa50e0329850401\",\"waitTime\":0,\"position\":1,\"dateEnqueued\":\"Thu, 13 Oct 2016 18:28:58 GMT\"}";
    private static String inputJSON = "{\"total\": 1, \"start\": 0, \"end\": 0, \"page\": 0, \"numPages\": 1, \"pageSize\": 1, \"nextPageUri\": null, \"queueMembers\": [" + MemberListTest.testMember + "]}";

    private MemberList list;

    @Given("^a MemberList object$")
    public void createList() throws Throwable {
        this.list = new MemberList("ACCOUNTID", "AUTHTOKEN", MemberListTest.inputJSON);
    }

    @Then("^check that the MemberList was built correctly$")
    public void checkMemberList(){
        assertThat(this.list.getLocalSize(), is(1));
    }
}
