package com.vailsys.persephony.percl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;

public class SetListenTest {
    private SetListen command;

    @Given("^a SetListen command with the callId (.*)$")
    public void createCommand(String callId){
        command = new SetListen(callId);
    }

    @Then("^the callId of the SetListen should be (.*)$")
    public void getCallId(String callId){
        assertThat(command.getCallId(), is(callId));
    }

    @Then("^check all optional fields in SetListen are null$")
    public void checkOptional(){
        assertThat(command.getListen(), nullValue());
    }

    @Then("^set the callId of the SetListen command to (.*)$")
    public void setCallId(String callId)
    {
        command.setCallId(callId);
    }

    @Then("^set the listen of the SetListen command to (true|false)$")
      public void setListen(String value){
          command.setListen(Boolean.parseBoolean(value));
      }

      @Then("^the listen of the SetListen command should be (true|false)$")
    public void getListen(String value){
          assertThat(command.getListen(), is(Boolean.parseBoolean(value)));
      }


}
