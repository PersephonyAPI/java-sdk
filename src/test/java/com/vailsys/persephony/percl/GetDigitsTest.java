package com.vailsys.persephony.percl;

import java.util.LinkedList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class GetDigitsTest {

	private GetDigits command;

	@Given("^a GetDigits command with actionUrl (.*)$")
	public void makeTestCommand(String actionUrl) {
		command = new GetDigits(actionUrl);
	}

	@Then("^check all optional fields in GetDigits are null$")
	public void checkAllAreNull() {
		assertThat(this.command.getInitialTimeoutMs(), nullValue());
		assertThat(this.command.getDigitTimeoutMs(), nullValue());
		assertThat(this.command.getFinishOnKey(), nullValue());
		assertThat(this.command.getMinDigits(), nullValue());
		assertThat(this.command.getMaxDigits(), nullValue());
		assertThat(this.command.getFlushBuffer(), nullValue());
		assertThat(this.command.getPrompts(), nullValue());
	}

	@Then("^set GetDigits actionUrl to (.*)$")
	public void setActionUrl(String actionUrl) {
		this.command.setActionUrl(actionUrl);
	}

	@Then("^set GetDigits initialTimeoutMs to (\\d+)$")
	public void setInitialTimeoutMs(Integer initialTimeoutMs) {
		this.command.setInitialTimeoutMs(initialTimeoutMs);
	}

	@Then("^set GetDigits digitTimeoutMs to (\\d+)$")
	public void setDigitTimeoutMs(Integer digitTimeoutMs) {
		this.command.setDigitTimeoutMs(digitTimeoutMs);
	}

	@Then("^set GetDigits finishOnKey to ([0-9\\*#]{1})$")
	public void setFinishOnKey(String finishOnKey) {
		this.command.setFinishOnKey(RecordUtteranceTest.StringToFinishOnKey(finishOnKey));
	}

	@Then("^set GetDigits minDigits to (\\d+)$")
	public void setMinDigits(Integer minDigits) {
		this.command.setMinDigits(minDigits);
	}

	@Then("^set GetDigits maxDigits to (\\d+)$")
	public void setMaxDigits(Integer maxDigits) {
		this.command.setMaxDigits(maxDigits);
	}

	@Then("^set GetDigits flushBuffer to (true|false)$")
	public void setFlushBuffer(Boolean flushBuffer) {
		this.command.setFlushBuffer(flushBuffer);
	}

	@Then("^set GetDigits prompts to empty list$")
	public void setPrompts() {
		this.command.setPrompts(new LinkedList<GetDigitsNestable>());
	}

	@Then("^set GetDigits prompts to a Say and Pause list$")
	public void setPromptsFull(){
		LinkedList<GetDigitsNestable> prompts = new LinkedList<>();
		Say say = new Say("test");
		Pause pause = new Pause(100);
		prompts.add(say);
		prompts.add(pause);
		this.command.setPrompts(prompts);
	}

	@Then("^check that actionUrl equals (.*) in GetDigits object$")
	public void getActionUrl(String actionUrl) {
		assertThat(this.command.getActionUrl(), is(actionUrl));
	}

	@Then("^check that initialTimeoutMs equals (\\d+) in GetDigits object$")
	public void getInitialTimeoutMs(Integer initialTimeoutMs) {
		assertThat(this.command.getInitialTimeoutMs(), is(initialTimeoutMs));
	}

	@Then("^check that digitTimeoutMs equals (\\d+) in GetDigits object$")
	public void getDigitTimeoutMs(Integer digitTimeoutMs) {
		assertThat(this.command.getDigitTimeoutMs(), is(digitTimeoutMs));
	}

	@Then("^check that finishOnKey equals ([0-9#*]{1}) in GetDigits object$")
	public void getFinishOnKey(String finishOnKey) {
		assertThat(this.command.getFinishOnKey(), is(RecordUtteranceTest.StringToFinishOnKey(finishOnKey)));
	}

	@Then("^check that minDigits equals (\\d+) in GetDigits object$")
	public void getMinDigits(Integer minDigits) {
		assertThat(this.command.getMinDigits(), is(minDigits));
	}

	@Then("^check that maxDigits equals (\\d+) in GetDigits object$")
	public void getMaxDigits(Integer maxDigits) {
		assertThat(this.command.getMaxDigits(), is(maxDigits));
	}

	@Then("^check that flushBuffer equals (true|false) in GetDigits object$")
	public void getFlushBuffer(Boolean flushBuffer) {
		assertThat(this.command.getFlushBuffer(), is(flushBuffer));
	}

	@Then("^check that prompts equals empty list in GetDigits object$")
	public void getPrompts() {
		assertThat(this.command.getPrompts(), is(new LinkedList<GetDigitsNestable>()));
	}

	@Then("^check that the GetDigits command serializes properly$")
	public void checkSerialize(){
		String serialized = this.command.toJson();
		assertThat(serialized, is("{\"GetDigits\":{\"actionUrl\":\"http://action.url/end/point\",\"prompts\":[{\"Say\":{\"text\":\"test\"}},{\"Pause\":{\"length\":100}}]}}"));
	}
}
