package com.vailsys.persephony.api;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CommonFieldsTest {
    public CommonFields fields;

    @Given("^an empty CommonFields object$")
    public void createCommonFields() { this.fields = new CommonFields(); }

    @Then("^check that all CommonFields fields are null$")
    public void checkFieldsAreNull() {
        assertThat(this.fields.getRequestId(), nullValue());
    }

    @When("^requestId is set to (RQ[a-fA-F0-9]{40}) in CommonFields$")
    public void setRequestId(String value){
        this.fields.setRequestId(value);
    }

    @Then("^check that requestId is (RQ[a-fA-F0-9]{40}) in CommonFields$")
    public void checkRequestId(String value){
        assertThat(this.fields.getRequestId(), is(value));
    }
}
