package com.vailsys.persephony.percl;

import java.util.LinkedList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;

public class HangupTest {

	Hangup command;

	@Given("^a Hangup$")
	public void createHangup() {
		this.command = new Hangup();
	}

	@Then("^check that the non-default fields are null in the Hangup object$")
	public void checkareNull() {
		assertThat(this.command.getCallId(), nullValue());
		assertThat(this.command.getReason(), nullValue());
	}
	@Then("^check that callId is (CA[0-9a-fA-F]{40}) in the Hangup object$")
	public void checkCallId(String callId) {
		assertThat(this.command.getCallId(), is(callId));
	}
	@Then("^check that reason is (.*) in the Hangup object$")
	public void checkReason(String reason) {
		assertThat(this.command.getReason(), is(reason));
	}
	@Then("^set reason to (.*) in Hangup object$")
	public void setReason(String reason) {
		this.command.setReason(reason);	
	}
	@Then("^set callId to (CA[0-9a-fA-F]{40}) in Hangup object$")
	public void setCallId(String callId) {
		this.command.setCallId(callId);	
	}
}
