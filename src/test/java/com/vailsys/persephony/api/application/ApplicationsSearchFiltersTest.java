package com.vailsys.persephony.api.application;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class ApplicationsSearchFiltersTest {
    private ApplicationsSearchFilters filters;

    @Given("^an empty ApplicationsSearchFilters object$")
    public void createFilters() { this.filters = new ApplicationsSearchFilters();}

    @Then("^check that all fields in ApplicationsSearchFilters are null$")
    public void checkAllFieldsAreNull(){
        assertThat(filters.getAlias(), nullValue());
    }

    @Then("^set the ApplicationsSearchFilters alias field to (.*)$")
    public void setAlias(String value){
        this.filters.setAlias(value);
    }

    @Then("^check that the ApplicationsSearchFilters alias field is (.*)$")
    public void checkAlias(String value){
        assertThat(this.filters.getAlias(), is(value));
    }
}
