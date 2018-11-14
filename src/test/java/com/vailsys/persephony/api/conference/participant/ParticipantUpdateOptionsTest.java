package com.vailsys.persephony.api.conference.participant;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParticipantUpdateOptionsTest {
    public ParticipantUpdateOptions options;

    @Given("^an empty ParticipantUpdateOptions object$")
    public void createParticipantUpdateOptions() { this.options = new ParticipantUpdateOptions(); }

    @Then("^check that all ParticipantUpdateOptions fields are null$")
    public void checkFieldsAreNull() {
        assertThat(this.options.getTalk(), nullValue());
        assertThat(this.options.getListen(), nullValue());
    }

    @When("^talk is set to (true|false) in ParticipantUpdateOptions$")
    public void setTalk(String value){
        this.options.setTalk(Boolean.parseBoolean(value));
    }

    @When("^listen is set to (true|false) in ParticipantUpdateOptions$")
    public void setListen(String value){
        this.options.setListen(Boolean.parseBoolean(value));
    }

    @When("^requestId is set to (RQ[a-fA-F0-9]{40}) in ParticipantUpdateOptions$")
    public void setRequestId(String value){
        this.options.setRequestId(value);
    }

    @Then("^check that talk is (true|false) in ParticipantUpdateOptions$")
    public void checkTalk(String value){
        assertThat(this.options.getTalk(), is(Boolean.parseBoolean(value)));
    }

    @Then("^check that listen is (true|false) in ParticipantUpdateOptions$")
    public void checkListen(String value){
        assertThat(this.options.getListen(), is(Boolean.parseBoolean(value)));
    }

    @Then("^check that requestId is (RQ[a-fA-F0-9]{40}) in ParticipantUpdateOptions$")
    public void checkRequestId(String value){
        assertThat(this.options.getRequestId(), is(value));
    }

}
