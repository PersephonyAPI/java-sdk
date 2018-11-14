package com.vailsys.persephony.percl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;

public class SendDigitsTest {

	private SendDigits command;

	@Given("^a SendDigits command with digits (.*)$")
	public void makeTestCommand(String digits) {
		command = new SendDigits(digits);
	}

	@Then("^check all optional fields in SendDigits are null$")
	public void checkAllAreNull() {
		assertThat(this.command.getPauseMs(), nullValue());
	}

	@Then("^set SendDigits digits to (.*)$")
	public void setDigits(String digits) {
		this.command.setDigits(digits);
	}

	@Then("^set SendDigits pauseMs to (\\d+)$")
	public void setPauseMs(Integer pauseMs) {
		this.command.setPauseMs(pauseMs);
	}

	@Then("^check that digits equals (.*) in SendDigits object$")
	public void getDigits(String digits) {
		assertThat(this.command.getDigits(), is(digits));
	}

	@Then("^check that pauseMs equals (\\d+) in SendDigits object$")
	public void getPauseMs(Integer pauseMs) {
		assertThat(this.command.getPauseMs(), is(pauseMs));
	}
}
