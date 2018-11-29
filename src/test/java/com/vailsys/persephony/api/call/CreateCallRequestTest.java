package com.vailsys.persephony.api.call;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class CreateCallRequestTest {

	String to = "+13125551234";
	String from = "+17735558245";

	String applicationId = null;


	CallOptions options = null;
	String sendDigits = null;
	IfMachine ifMachine = null;
	Integer timeout = null;

	CreateCallRequest request;

	@Given("^a CreateCallRequest without options.$")
	public void create() {
		this.applicationId = "AP1234567890123456789012345678901234567890";

		this.sendDigits = null;
		this.ifMachine = null;
		this.timeout = null;
		this.options = null;

		this.request = new CreateCallRequest(this.to, this.from, this.applicationId, null);
	}

	@Given("^a CreateCallRequest with options.$")
	public void createWithOptions() {
		this.applicationId = "AP1234567890123456789012345678901234567890";

		this.sendDigits = "1234";
		this.ifMachine = IfMachine.HANGUP;
		this.timeout = 16;

		this.options = new CallOptions();
		this.options.setSendDigits(this.sendDigits);
		this.options.setIfMachine(this.ifMachine);
		this.options.setTimeout(this.timeout);

		this.request = new CreateCallRequest(this.to, this.from, this.applicationId, this.options);
	}

	@Then("^check that it set all fields correctly.$")
	public void checkToField() {
		assertThat(this.request.to, is(this.to));
		assertThat(this.request.from, is(this.from));
		assertThat(this.request.applicationId, is(this.applicationId));
		assertThat(this.request.options, is(this.options));
	}

	@Then("^check that it can produce JSON from the base object.$")
	public void checkJson() {
		String json = "{\"to\":\""+this.request.to+"\",\"from\":\""+this.request.from+"\",\"applicationId\":\""+this.request.applicationId+"\"}";
		assertThat(this.request.toJson(), is(json));
	}

}
