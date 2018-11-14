package com.vailsys.persephony.percl;

import java.util.LinkedList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;

public class PlayEarlyMediaTest {

	PlayEarlyMedia command;
	@Given("^a PlayEarlyMedia with file (.+)$")
	public void createPlayEarlyMedia(String file) {
		this.command = new PlayEarlyMedia(file);
	}

	@Then("^set file to (.+) in PlayEarlyMedia object$")
	public void setFile(String file) {
		this.command.setFile(file);
	}

	@Then("^check that file is (.+) in the PlayEarlyMedia object$")
	public void getFile(String file) {
		assertThat(this.command.getFile(), is(file));
	}
}
