package com.vailsys.persephony.api.conference.participant;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class ParticipantListTest {
    private static String testParticipant = "{ \"accountId\":\"ACea5735de286cb68f47e78316f647d19522b81d00\", \"conferenceId\":\"CFd0cc3ab95118aaa597039793a1692313fa9c4936\", \"callId\":\"CAef219e4e9152a4b31888620cf391adcae5b6f18c\", \"uri\":\"/Accounts/ACea5735de286cb68f47e78316f647d19522b81d00/Conferences/CFd0cc3ab95118aaa597039793a1692313fa9c4936/Participants/CAef219e4e9152a4b31888620cf391adcae5b6f18c\", \"dateCreated\":\"Thu, 13 Oct 2016 18:23:31 GMT\", \"dateUpdated\":\"Thu, 13 Oct 2016 18:23:31 GMT\", \"revision\":1, \"talk\":true, \"listen\":true, \"startConfOnEnter\":true }";

    private static String inputJson = "{\"total\": 1, \"start\": 0, \"end\": 0, \"page\": 0, \"numPages\": 1, \"pageSize\": 1, \"nextPageUri\": null, \"participants\": [" + ParticipantListTest.testParticipant + "]}";

    private ParticipantList list;

    @Given("^a ParticipantList object$")
    public void makeListfromJson() throws Throwable {
        this.list = new ParticipantList("ACCOUNTID", "AUTHTOKEN", ParticipantListTest.inputJson);
    }

    @Then("^check that it was built correctly$")
    public void checkList() { assertThat(this.list.getLocalSize(), is(1));
    }
}
