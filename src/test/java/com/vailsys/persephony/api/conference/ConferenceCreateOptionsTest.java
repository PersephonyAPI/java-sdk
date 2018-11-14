package com.vailsys.persephony.api.conference;

import java.lang.reflect.Type;

import com.google.gson.LongSerializationPolicy;
import com.google.gson.reflect.TypeToken;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ConferenceCreateOptionsTest {

	ConferenceCreateOptions options;

	@Given("^An empty ConferenceCreateOptions object.$")
	public void createConferenceCreateOptions() {
		this.options = new ConferenceCreateOptions();
	}

	@Then("^check that all ConferenceCreateOptions fields are null.$")
	public void checkFieldsAreNull() {
		assertThat(this.options.getAlias(), nullValue());
		assertThat(this.options.getPlayBeep(), nullValue());
	}

	@Then("^check that alias is (.*) in ConferenceCreateOptions$")
	public void checkGetAlias(String alias) {
		assertThat(this.options.getAlias(), is(alias));
	}
	@Then("^check that playBeep is (always|never|entryOnly|exitOnly) in ConferenceCreateOptions$")
	public void checkGetPlayBeep(String playBeep) {
		PlayBeep pb;
		if (playBeep.equals("always")) {
			pb = PlayBeep.ALWAYS;
		} else if (playBeep.equals("never")) {
			pb = PlayBeep.NEVER;
		} else if (playBeep.equals("exitOnly")) {
			pb = PlayBeep.EXIT_ONLY;
		} else {
			pb = PlayBeep.ENTRY_ONLY;
		}
		assertThat(this.options.getPlayBeep(), is(pb));
	}
	@Then("^check that record is (true|false) in ConferenceCreateOptions$")
	public void checkGetRecord(Boolean record) {
		assertThat(this.options.getRecord(), is(record));
	}
	@Then("^check that statusCallbackUrl is (.*) in ConferenceCreateOptions$")
	public void checkGetStatusCallbackUrl(String statusCallbackUrl) {
		assertThat(this.options.getStatusCallbackUrl(), is(statusCallbackUrl));
	}
	@Then("^check that waitUrl is (.*) in ConferenceCreateOptions$")
	public void checkGetWaitUrl(String waitUrl) {
		assertThat(this.options.getWaitUrl(), is(waitUrl));
	}

	@Then("^set alias to (.*) in ConferenceCreateOptions$")
	public void setAlias(String alias) {
		this.options.setAlias(alias);
	}
	@Then("^set playBeep to (always|never|exitOnly|entryOnly) in ConferenceCreateOptions$")
	public void setPlayBeep(String playBeep) {
		PlayBeep pb;
		if (playBeep.equals("always")) {
			pb = PlayBeep.ALWAYS;
		} else if (playBeep.equals("never")) {
			pb = PlayBeep.NEVER;
		} else if (playBeep.equals("exitOnly")) {
			pb = PlayBeep.EXIT_ONLY;
		} else {
			pb = PlayBeep.ENTRY_ONLY;
		}
		this.options.setPlayBeep(pb);
	}
	@Then("^set record to (true|false) in ConferenceCreateOptions$")
	public void setRecord(Boolean record) {
		this.options.setRecord(record);
	}
	@Then("^set statusCallbackUrl to (.*) in ConferenceCreateOptions$")
	public void setStatusCallbackUrl(String statusCallbackUrl) {
		this.options.setStatusCallbackUrl(statusCallbackUrl);
	}
	@Then("^set waitUrl to (.*) in ConferenceCreateOptions$")
	public void setWaitUrl(String waitUrl) {
		this.options.setWaitUrl(waitUrl);
	}
}
