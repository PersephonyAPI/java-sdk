package com.vailsys.persephony.percl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class SetTalkTest {
    private SetTalk command;

    @Given("^a SetTalk command with the callId (.*)$")
    public void createCommand(String callId) {
        command = new SetTalk(callId);
    }

    @Then("^the callId of the SetTalk should be (.*)$")
    public void getCallId(String callId) {
        assertThat(command.getCallId(), is(callId));
    }

    @Then("^check all optional fields in SetTalk are null$")
    public void checkOptional() {
        assertThat(command.getTalk(), nullValue());
    }

    @Then("^set the callId of the SetTalk command to (.*)$")
    public void setCallId(String callId) {
        command.setCallId(callId);
    }

    @Then("^set the talk of the SetTalk command to (true|false)$")
    public void setTalk(String value) {
        command.setTalk(Boolean.parseBoolean(value));
    }

    @Then("^the talk of the SetTalk command should be (true|false)$")
    public void getTalk(String value) {
        assertThat(command.getTalk(), is(Boolean.parseBoolean(value)));
    }

}
