package com.vailsys.persephony.percl;

import java.util.LinkedList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;

public class RecordUtteranceTest {
	static FinishOnKey StringToFinishOnKey(String strKey) {
		FinishOnKey response = null;
		switch (strKey) {
			case "1":
				response = FinishOnKey.ONE;
				break;
			case "2":
				response = FinishOnKey.TWO;
				break;
			case "3":
				response = FinishOnKey.THREE;
				break;
			case "4":
				response = FinishOnKey.FOUR;
				break;
			case "5":
				response = FinishOnKey.FIVE;
				break;
			case "6":
				response = FinishOnKey.SIX;
				break;
			case "7":
				response = FinishOnKey.SEVEN;
				break;
			case "8":
				response = FinishOnKey.EIGHT;
				break;
			case "9":
				response = FinishOnKey.NINE;
				break;
			case "0":
				response = FinishOnKey.ZERO;
				break;
			case "#":
				response = FinishOnKey.POUND;
				break;
			case "*":
				response = FinishOnKey.STAR;
				break;
		}
		return response;
	}

	RecordUtterance command;
	@Given("^a RecordUtterance with actionUrl (.+)$")
	public void createRecordUtterance(String actionUrl) {
		this.command = new RecordUtterance(actionUrl);
	}

	@Then("^set actionUrl to (.+) in the RecordUtterance object$")
	public void setActionUrl(String actionUrl) {
		this.command.setActionUrl(actionUrl);
	}

	@Then("^set silenceTimeoutMs to (\\d+) in the RecordUtterance object$")
	public void setSilenceTimeoutMs(Integer silenceTimeoutMs) {
		this.command.setSilenceTimeoutMs(silenceTimeoutMs);
	}
	@Then("^set finishOnKey to ([0-9\\*#]{1}) in the RecordUtterance object$")
	public void setFinishOnKey(String finishOnKey) {
		this.command.setFinishOnKey(StringToFinishOnKey(finishOnKey));
	}
	@Then("^set maxLengthSec to (\\d+) in the RecordUtterance object$")
	public void setMaxLengthSec(Integer maxLengthSec) {
		this.command.setMaxLengthSec(maxLengthSec);
	}
	@Then("^set playBeep to (true|false) in the RecordUtterance object$")
	public void setPlayBeep(Boolean playBeep) {
		this.command.setPlayBeep(playBeep);
	}
	@Then("^set autoStart to (true|false) in the RecordUtterance object$")
	public void setAutoStart(Boolean autoStart) {
		this.command.setAutoStart(autoStart);
	}

	@Then("^check that actionUrl is (.+) in the RecordUtterance object$")
	public void getActionUrl(String actionUrl) {
		assertThat(this.command.getActionUrl(), is(actionUrl));
	}
	@Then("^check that silenceTimeoutMs is (\\d+) in the RecordUtterance object$")
	public void getSilenceTimeoutMs(Integer silenceTimeoutMs) {
		assertThat(this.command.getSilenceTimeoutMs(), is(silenceTimeoutMs));
	}
	@Then("^check that finishOnKey is ([0-9\\*#]{1}) in the RecordUtterance object$")
	public void getFinishOnKey(String finishOnKey) {
		assertThat(this.command.getFinishOnKey(), is(StringToFinishOnKey(finishOnKey)));
	}
	@Then("^check that maxLengthSec is (\\d+) in the RecordUtterance object$")
	public void getMaxLengthSec(Integer maxLengthSec) {
		assertThat(this.command.getMaxLengthSec(), is(maxLengthSec));
	}
	@Then("^check that playBeep is (true|false) in the RecordUtterance object$")
	public void getPlayBeep(Boolean playBeep) {
		assertThat(this.command.getPlayBeep(), is(playBeep));
	}
	@Then("^check that autoStart is (true|false) in the RecordUtterance object$")
	public void getAutoStart(Boolean autoStart) {
		assertThat(this.command.getAutoStart(), is(autoStart));
	}
}
