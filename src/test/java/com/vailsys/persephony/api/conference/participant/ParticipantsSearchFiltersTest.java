package com.vailsys.persephony.api.conference.participant;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import cucumber.api.java.en.When;


import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParticipantsSearchFiltersTest {
    private ParticipantsSearchFilters psf;

    @Given("^an empty ParticipantsSearchFilters object$")
    public void createPSF() {
        this.psf = new ParticipantsSearchFilters();
    }

    @Then("^check that all fields in ParticipantsSearchFilters are null$")
    public void checkAllFieldsAreNull() throws Throwable {
        assertThat(this.psf.getTalk(), nullValue());
        assertThat(this.psf.getListen(), nullValue());
    }

    @When("^set the ParticipantsSearchFilters talk field to (true|false)$")
    public void setTalk(String value){
        this.psf.setTalk(Boolean.parseBoolean(value));
    }

    @When("^set the ParticipantsSearchFilters listen field to (true|false)$")
    public void setListen(String value){
        this.psf.setListen(Boolean.parseBoolean(value));
    }

    @Then("^check that the ParticipantsSearchFilters talk field is (true|false)$")
    public void checkTalk(String value){
        assertThat(this.psf.getTalk(), is(Boolean.parseBoolean(value)));
    }

    @Then("^check that the ParticipantsSearchFilters listen field is (true|false)$")
    public void checkListen(String value){
        assertThat(this.psf.getListen(), is(Boolean.parseBoolean(value)));
    }
}
