package com.vailsys.persephony.percl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;

public class AddToConferenceTest {
    private AddToConference command;

    @Given("^an AddToConference command with conferenceId (.*) and callId (.*)$")
    public void createCommand(String conferenceId, String callId) {
        command = new AddToConference(conferenceId, callId);
    }

    @Then("^check all optional fields in AddToConference are null$")
    public void checkOptionalAreNull() {
        assertThat(this.command.getStartConfOnEnter(), nullValue());
        assertThat(this.command.getTalk(), nullValue());
        assertThat(this.command.getListen(), nullValue());
        assertThat(this.command.getLeaveConferenceUrl(), nullValue());
        assertThat(this.command.getNotificationUrl(), nullValue());
        assertThat(this.command.getAllowCallControl(), nullValue());
        assertThat(this.command.getCallControlSequence(), nullValue());
        assertThat(this.command.getCallControlUrl(), nullValue());
    }

    @Then("^set AddToConference conferenceId to (.*)$")
    public void setConferenceId(String conferenceId){
        this.command.setConferenceId(conferenceId);
    }

    @Then("^check that conferenceId equals (.*) in AddToConference object$")
    public void getConferenceId(String conferenceId){
        assertThat(this.command.getConferenceId(), is(conferenceId));
    }

    @Then("^set AddToConference callId to (.*)$")
    public void setCallId(String callId){
        this.command.setCallId(callId);
    }

    @Then("^check that callId equals (.*) in AddToConference object$")
    public void getCallId(String callId) {
        assertThat(this.command.getCallId(), is(callId));
    }

    @Then("^set AddToConference optional properties$")
    public void setOptional(){
        this.command.setStartConfOnEnter(true);
        this.command.setTalk(true);
        this.command.setListen(false);
        this.command.setLeaveConferenceUrl("some url");
        this.command.setNotificationUrl("some other url");
        this.command.setAllowCallControl(false);
        this.command.setCallControlSequence("1");
        this.command.setCallControlUrl("yet another url");
    }

    @Then("^check AddToConference optional properties$")
    public void checkOptional(){
        assertThat(this.command.getStartConfOnEnter(), is(true));
        assertThat(this.command.getTalk(), is(true));
        assertThat(this.command.getListen(), is(false));
        assertThat(this.command.getLeaveConferenceUrl(), is("some url"));
        assertThat(this.command.getNotificationUrl(), is("some other url"));
        assertThat(this.command.getAllowCallControl(), is(false));
        assertThat(this.command.getCallControlSequence(), is("1"));
        assertThat(this.command.getCallControlUrl(), is("yet another url"));
    }


}
