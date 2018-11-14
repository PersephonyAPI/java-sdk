package com.vailsys.persephony.percl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;

public class TerminateConferenceTest {
    private TerminateConference command;

    @Given("^a TerminateConference with conferenceId (.*)$")
    public void createCommand(String conferenceId){
        command = new TerminateConference(conferenceId);
    }

    @Then("^check that the conferenceId of the TerminateConference is (.*)$")
    public void getConferenceId(String confId){
        assertThat(command.getConferenceId(), is(confId));
    }

    @Then("^set the conferenceId of the TerminateConference to (.*)$")
    public void setConferenceId(String confId){
        command.setConferenceId(confId);
    }
}
