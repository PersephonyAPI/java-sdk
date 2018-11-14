package com.vailsys.persephony.percl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class SmsTest {
    private Sms command;

    @Given("^an Sms command with to (.*) and from (.*) and text (.*)$")
    public void createCommand(String to, String from, String text) {
        command = new Sms(to, from, text);
    }

    @Then("^set the Sms command notificationUrl to (.*)$")
    public void setNotification(String notificationUrl) {
        command.setNotificationUrl(notificationUrl);
    }

    @Then("^check that to equals (.*) in Sms object$")
    public void getTo(String value) {
        assertThat(this.command.getTo(), is(value));
    }

    @Then("^check that from equals (.*) in Sms object$")
    public void getFrom(String value) {
        assertThat(this.command.getFrom(), is(value));
    }

    @Then("^check that text equals (.*) in Sms object$")
    public void getText(String value) {
        assertThat(this.command.getText(), is(value));
    }

    @Then("^check that notificationUrl equals (.*) in Sms object$")
    public void getNotificationUrl(String value) {
        assertThat(this.command.getNotificationUrl(), is(value));
    }
}
