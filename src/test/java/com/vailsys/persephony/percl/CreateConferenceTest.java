package com.vailsys.persephony.percl;

import com.vailsys.persephony.api.conference.PlayBeep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;

public class CreateConferenceTest {

    private CreateConference command;

    @Given("^a CreateConference command with actionUrl (.*)$")
    public void makeTestCommand(String actionUrl){
        command = new CreateConference(actionUrl);
    }

    @Then("^check all options fields in CreateConference are null$")
    public void checkAllAreNull(){
        assertThat(this.command.getAlias(), nullValue());
        assertThat(this.command.getPlayBeep(), nullValue());
        assertThat(this.command.getRecord(), nullValue());
        assertThat(this.command.getWaitUrl(), nullValue());
        assertThat(this.command.getStatusCallbackUrl(), nullValue());
    }

    @Then("^set CreateConference actionUrl to (.*)$")
    public void setActionUrl(String url){
        this.command.setActionUrl(url);
    }

    @Then("^check that actionUrl equals (.*) in CreateConference object$")
    public void getActionUrl(String actionUrl){
        assertThat(this.command.getActionUrl(), is(actionUrl));
    }

    @Then("^set CreateConference optional properties$")
    public void setOptional(){
        this.command.setAlias("test alias");
        this.command.setPlayBeep(PlayBeep.EXIT_ONLY);
        this.command.setRecord(false);
        this.command.setWaitUrl("http://wait.url/end/point");
        this.command.setStatusCallbackUrl("http://status.callback/end/point");
    }

    @Then("^check CreateConference optional properties$")
    public void checkOptional(){
        assertThat(this.command.getAlias(), is("test alias"));
        assertThat(this.command.getPlayBeep(), is(PlayBeep.EXIT_ONLY));
        assertThat(this.command.getRecord(), is(false));
        assertThat(this.command.getWaitUrl(), is("http://wait.url/end/point"));
        assertThat(this.command.getStatusCallbackUrl(), is("http://status.callback/end/point"));
    }
}
