package com.vailsys.persephony.api.queue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class QueuesSearchFiltersTest {
    private QueuesSearchFilters rsf;

    @Given("^an empty QueuesSearchFilters object$")
    public void createRSF() {
        this.rsf = new QueuesSearchFilters();
    }

    @Then("^check that all fields in QueuesSearchFilters are null$")
    public void checkAllFieldsAreNull() throws Throwable {
        assertThat(this.rsf.getAlias(), nullValue());
    }


    @Then("^check that the QueuesSearchFilters alias field is (.*)$")
    public void getAlias(String alias) {
        assertThat(this.rsf.getAlias(), is(alias));
    }


    @Then("^set the QueuesSearchFilters alias field to (.*)$")
    public void setAlias(String alias) {
        this.rsf.setAlias(alias);
    }


}
