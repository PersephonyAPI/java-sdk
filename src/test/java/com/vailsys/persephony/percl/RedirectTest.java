package com.vailsys.persephony.percl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class RedirectTest {
    private Redirect command;

    @Given("^a Redirect object with actionUrl (.*)$")
    public void create(String actionUrl){
        this.command = new Redirect(actionUrl);
    }

    @Then("^check that the Redirect actionUrl is (.*)$")
    public void getActionUrl(String actionUrl){
        assertThat(this.command.getActionUrl(), is(actionUrl));
    }

    @Then("^set the Redirect actionUrl to (.*)$")
    public void setActionUrl(String actionUrl){
        this.command.setActionUrl(actionUrl);
    }

}
