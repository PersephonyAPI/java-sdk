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

public class ConferenceUpdateOptionsTest {

	ConferenceUpdateOptions options;

	@Given("^An empty ConferenceUpdateOptions object.$")
	public void createConferenceUpdateOptions() {
		this.options = new ConferenceUpdateOptions();
	}

	@Then("^check that all ConferenceUpdateOptions fields are null.$")
	public void checkFieldsAreNull() {
		assertThat(this.options.getAlias(), nullValue());
		assertThat(this.options.getPlayBeep(), nullValue());
		assertThat(this.options.getStatus(), nullValue());
	}

	@Then("^check that alias is (.*) in ConferenceUpdateOptions$")
	public void checkGetAlias(String alias) {
		assertThat(this.options.getAlias(), is(alias));
	}
	@Then("^check that playBeep is (always|never|entryOnly|exitOnly) in ConferenceUpdateOptions$")
	public void checkGetPlayBeep(String pb) {
		PlayBeep playBeep;
		if(pb == "always") {
			playBeep = PlayBeep.ALWAYS;
		} else if (pb == "never"){
			playBeep = PlayBeep.NEVER;
		} else if (pb == "entryOnly") {
			playBeep = PlayBeep.ENTRY_ONLY;
		} else {
			playBeep = PlayBeep.EXIT_ONLY;
		}
		assertThat(this.options.getPlayBeep(), is(playBeep));
	}
	@Then("^check that status is (empty|terminated) in ConferenceUpdateOptions$")
	public void checkGetStatus(String statusStr) {
		ConferenceStatus status;
		if(statusStr == "terminated") {
			status = ConferenceStatus.TERMINATED;
		} else {
			status = ConferenceStatus.EMPTY;
		}
		assertThat(this.options.getStatus(), is(status));
	}

	@Then("^set alias to (.*) in ConferenceUpdateOptions$")
	public void setAlias(String alias) {
		this.options.setAlias(alias);
	}
	@Then("^set playBeep to (always|never|entryOnly|exitOnly) in ConferenceUpdateOptions$")
	public void setPlayBeep(String pb) {
		PlayBeep playBeep;
		if(pb == "always") {
			playBeep = PlayBeep.ALWAYS;
		} else if (pb == "never"){
			playBeep = PlayBeep.NEVER;
		} else if (pb == "entryOnly") {
			playBeep = PlayBeep.ENTRY_ONLY;
		} else {
			playBeep = PlayBeep.EXIT_ONLY;
		}
		this.options.setPlayBeep(playBeep);
	}
	@Then("^set status to (empty|terminated) in ConferenceUpdateOptions$")
	public void setStatus(String statusStr) {
		ConferenceStatus status;
		if(statusStr == "terminated"){
			status = ConferenceStatus.TERMINATED;
		} else {
			status = ConferenceStatus.EMPTY;
		}
		this.options.setStatus(status);
	}
}
