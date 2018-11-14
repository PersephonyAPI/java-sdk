package com.vailsys.persephony.percl;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class PauseTest {

    Pause command;

    @Given("^a Pause with length (\\d+)$")
    public void createPause(Integer length) {
        this.command = new Pause(length);
    }


    @Then("^set length to (\\d+) in Pause object$")
    public void setLength(Integer length) {
        this.command.setLength(length);
    }


    @Then("^check that length is (\\d+) in the Pause object$")
    public void getLength(Integer length) {
        assertThat(this.command.getLength(), is(length));
    }

}
