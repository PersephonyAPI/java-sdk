package com.vailsys.persephony.percl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;

public class RemoveFromConferenceTest {
    private RemoveFromConference command;

    @Given("^a RemoveFromConference with callId (.*)$")
    public void createCommand(String callId){
        command = new RemoveFromConference(callId);
    }

    @Then("^check that the callId of the RemoveFromConference is (.*)$")
    public void getCallId(String callId){
        assertThat(command.getCallId(), is(callId));
    }

    @Then("^set the callId of the RemoveFromConference to (.*)$")
    public void setCallId(String callId){
        command.setCallId(callId);
    }
}
