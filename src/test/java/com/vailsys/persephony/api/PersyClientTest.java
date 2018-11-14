package com.vailsys.persephony.api;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class PersyClientTest {
	private PersyClient client;

	@Given("^a PersyClient with accountId (AC[0-9A-Fa-f]{40}) and authtoken ([0-9A-Fa-f]{40})$")
	public void makePersyClient(String credAccountId, String credAuthToken) throws Throwable {
		this.client = new PersyClient(credAccountId, credAuthToken);
	}

	@Given("^a PersyClient with accountId (AC[0-9A-Fa-f]{40}) and authtoken ([0-9A-Fa-f]{40}) but using accountId (AC[0-9A-Fa-f]{40})$")
	public void makePersyClientDiff(String credAccountId, String credAuthToken, String accountId) throws Throwable {
		this.client = new PersyClient(credAccountId, credAuthToken, accountId);
	}

	@Then("^verify a PersyClient with accountId (AC[0-9A-Fa-f]{40}) and authtoken ([0-9A-Fa-f]{40})$")
	public void verifyPersyClient(String credAccountId, String credAuthToken) {
		assertThat(this.client.getCredAccountId(), is(credAccountId));
		assertThat(this.client.getCredAuthToken(), is(credAuthToken));
	}

	@Then("^verify a PersyClient with accountId (AC[0-9A-Fa-f]{40}) and authtoken ([0-9A-Fa-f]{40}) but using accountId (AC[0-9A-Fa-f]{40})$")
	public void verifyPersyClientDiff(String credAccountId, String credAuthToken, String accountId) {
		assertThat(this.client.getCredAccountId(), is(credAccountId));
		assertThat(this.client.getCredAuthToken(), is(credAuthToken));
		assertThat(this.client.getAccountId(), is(accountId));
	}
}
