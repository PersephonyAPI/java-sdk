package com.vailsys.persephony.api.phoneNumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class AvailablePhoneNumberSearchFiltersTest {
    private AvailablePhoneNumberSearchFilters filters;

    @Given("^an empty AvailablePhoneNumberSearchFilters object$")
    public void create(){
        filters = new AvailablePhoneNumberSearchFilters();
    }

    @Then("^check that all fields in AvailablePhoneNumberSearchFilters are null$")
    public void checkNull(){
        assertThat(filters.getAlias(), is(nullValue()));
        assertThat(filters.getPhoneNumber(), is(nullValue()));
    }

    @Then("^set the AvailablePhoneNumberSearchFilters alias to (.*)$")
    public void setAlias(String alias){
        filters.setAlias(alias);
    }

    @Then("^set the AvailablePhoneNumberSearchFilters phoneNumber to (.*)$")
    public void setPhoneNumber(String phoneNumber){
        filters.setPhoneNumber(phoneNumber);
    }

    @Then("^check that the AvailablePhoneNumberSearchFilters alias field is (.*)$")
    public void assertAlias(String alias){
        assertThat(filters.getAlias(), is(alias));
    }

    @Then("^check that the AvailablePhoneNumberSearchFilters phoneNumber field is (.*)$")
    public void assertPhoneNumber(String number){
        assertThat(filters.getPhoneNumber(), is(number));
    }



}
