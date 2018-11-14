package com.vailsys.persephony.api.conference;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConferenceListTest {
    private static String testConference = "{\"uri\" : \"/Accounts/AC5c60401972d2a2cfeb35fce3901af375c3c1e981/Conferences/CF6af689f06309b29e9f0c91cec4691147661de97e\", \"revision\" : 1, \"dateCreated\" : \"Mon, 31 Oct 2016 19:12:33 GMT\", \"dateUpdated\" : \"Mon, 31 Oct 2016 19:12:33 GMT\", \"conferenceId\" : \"CF6af689f06309b29e9f0c91cec4691147661de97e\", \"accountId\" : \"AC5c60401972d2a2cfeb35fce3901af375c3c1e981\", \"alias\" : \"53870ac2\", \"playBeep\" : \"always\", \"record\" : false, \"status\" : \"terminated\", \"waitUrl\" : \"http://6f4f.40ab1f12.8d.9f/eea393a0\", \"actionUrl\" : \"http://4c9f.bc57ab94.98.f2/5022ed9c\", \"statusCallbackUrl\" : \"http://2f81.08143fe1.d0.f3/2c2bf957\", \"subresourceUris\" : {\"participants\" : \"/Accounts/AC5c60401972d2a2cfeb35fce3901af375c3c1e981/Conferences/CF6af689f06309b29e9f0c91cec4691147661de97e/Participants\", \"recordings\" : \"/Accounts/AC5c60401972d2a2cfeb35fce3901af375c3c1e981/Conferences/CF6af689f06309b29e9f0c91cec4691147661de97e/Recordings\"}}";
    private static String inputJson = "{\"total\": 1, \"start\": 0, \"end\": 0, \"page\": 0, \"numPages\": 1, \"pageSize\": 1, \"nextPageUri\": null, \"conferences\": [" + ConferenceListTest.testConference + "]}";

    private ConferenceList list;

    @Given("^a ConferenceList object$")
    public void makeListFromJson() throws Throwable {
        this.list = new ConferenceList("ACCOUNTID", "AUTHTOKEN", ConferenceListTest.inputJson);
    }

    @Then("^check that the ConferenceList was built correctly$")
    public void checkList() {
        assertThat(this.list.getLocalSize(), is(1));
    }
}
