package com.vailsys.persephony.api.phoneNumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class CallingNumberCreateOptionsTest {
    private CallingNumberCreateOptions options;

    @Given("^a CallingNumberCreateOptions object$")
    public void create(){
        options = new CallingNumberCreateOptions();
    }

    @Then("^verify the CallingNumberCreateOptions fields are null$")
    public void checkNull(){
        assertThat(options.getPhoneNumber(), is(nullValue()));
        assertThat(options.getAlias(), is(nullValue()));
    }

    @Then("^set the CallingNumberCreateOptions alias to (.*)$")
    public void setAlias(String alias){
        options.setAlias(alias);
    }

    @Then("^set the CallingNumberCreateOptions phoneNumber to (.*)$")
    public void setPhoneNumber(String phoneNumber){
        options.setPhoneNumber(phoneNumber);
    }

    @Then("^the CallingNumberCreateOptions alias field should be (.*)$")
    public void assertAlias(String alias){
        assertThat(options.getAlias(), is(alias));
    }

    @Then("^the CallingNumberCreateOptions phoneNumber field should be (.*)$")
    public void assertPhoneNumber(String phoneNumber){
        assertThat(options.getPhoneNumber(), is(phoneNumber));
    }
}
