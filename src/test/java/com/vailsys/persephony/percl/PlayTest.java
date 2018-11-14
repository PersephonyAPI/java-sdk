package com.vailsys.persephony.percl;

import java.util.LinkedList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;

public class PlayTest {

	Play command;
	@Given("^a Play with file (.+)$")
	public void createPlay(String file) {
		this.command = new Play(file);
	}

	@Then("^check that the non-default fields are null in the Play object$")
	public void checkareNull() {
		assertThat(this.command.getLoop(), nullValue());
		assertThat(this.command.getConferenceId(), nullValue());
	}

	@Then("^set file to (.+) in Play object$")
	public void setFile(String file) {
		this.command.setFile(file);
	}
	@Then("^set loop to (\\d+) in Play object$")
	public void setLoop(Integer loop) {
		this.command.setLoop(loop);
	}
	@Then("^set conferenceId to (CF[0-9a-fA-F]{40}) in Play object$")
	public void setConferenceId(String conferenceId) {
		this.command.setConferenceId(conferenceId);
	}

	@Then("^check that file is (.+) in the Play object$")
	public void getFile(String file) {
		assertThat(this.command.getFile(), is(file));
	}
	@Then("^check that loop is (\\d+) in the Play object$")
	public void getLoop(Integer loop) {
		assertThat(this.command.getLoop(), is(loop));
	}
	@Then("^check that conferenceId is (CF[0-9a-fA-F]{40}) in the Play object$")
	public void getConferenceId(String conferenceId) {
		assertThat(this.command.getConferenceId(), is(conferenceId));
	}
}
