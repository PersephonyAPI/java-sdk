package com.vailsys.persephony.percl;

import java.util.LinkedList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;

public class SayTest {

	Say command;
	@Given("^a Say with text (.+)$")
	public void createSay(String text) {
		this.command = new Say(text);
	}

	@Then("^check that the non-default fields are null in the Say object$")
	public void checkareNull() {
		assertThat(this.command.getLoop(), nullValue());
		assertThat(this.command.getConferenceId(), nullValue());
	}

	@Then("^set text to (.+) in Say object$")
	public void setText(String text) {
		this.command.setText(text);
	}
	@Then("^set language to en-US in Say object$")
	public void setLanguage() {
		this.command.setLanguage(Language.ENGLISH_US);
	}
	@Then("^set loop to (\\d+) in Say object$")
	public void setLoop(Integer loop) {
		this.command.setLoop(loop);
	}
	@Then("^set conferenceId to (CF[0-9a-fA-F]{40}) in Say object$")
	public void setConferenceId(String conferenceId) {
		this.command.setConferenceId(conferenceId);
	}

	@Then("^check that text is (.+) in the Say object$")
	public void getText(String text) {
		assertThat(this.command.getText(), is(text));
	}
	@Then("^check that language is en-US in the Say object$")
	public void getLanguage() {
		assertThat(this.command.getLanguage(), is(Language.ENGLISH_US));
	}
	@Then("^check that loop is (\\d+) in the Say object$")
	public void getLoop(Integer loop) {
		assertThat(this.command.getLoop(), is(loop));
	}
	@Then("^check that conferenceId is (CF[0-9a-fA-F]{40}) in the Say object$")
	public void getConferenceId(String conferenceId) {
		assertThat(this.command.getConferenceId(), is(conferenceId));
	}
}
