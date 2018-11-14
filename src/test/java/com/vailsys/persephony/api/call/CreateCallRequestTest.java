package com.vailsys.persephony.api.call;

import static com.vailsys.persephony.json.PersyGson.gson;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class CreateCallRequestTest {

	String to = "+13125551234";
	String from = "+17735558245";

	String applicationId = null;

	String callConnectUrl = null;
	String statusCallbackUrl = null;

	CallOptions options = null;
	String sendDigits = null;
	IfMachine ifMachine = null;
	Integer timeout = null;

	CreateCallRequest request;

	@Given("^an applicationId based CreateCallRequest without options.$")
	public void createWithApplicationId() {
		this.callConnectUrl = null;
		this.statusCallbackUrl = null;
		this.applicationId = "AP1234567890123456789012345678901234567890";

		this.sendDigits = null;
		this.ifMachine = null;
		this.timeout = null;
		this.options = null;

		this.request = new CreateCallRequest(this.to, this.from, this.applicationId, null);
	}

	@Given("^an url based CreateCallRequest without options.$")
	public void createWithUrls() {
		this.callConnectUrl = "127.0.0.1/call";
		this.statusCallbackUrl = "127.0.0.1/status";
		this.applicationId = null;

		this.sendDigits = null;
		this.ifMachine = null;
		this.timeout = null;
		this.options = null;

		this.request = new CreateCallRequest(this.to, this.from, this.callConnectUrl, this.statusCallbackUrl, null);
	}

	@Given("^an applicationId based CreateCallRequest with options.$")
	public void createWithApplicationIdAndOptions() {
		this.statusCallbackUrl = null;
		this.applicationId = null;
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

	@Given("^an url based CreateCallRequest with options.$")
	public void createWithUrlsAndOptions() {
		this.callConnectUrl = "127.0.0.1/call";
		this.statusCallbackUrl = "127.0.0.1/status";
		this.applicationId = null;

		this.sendDigits = "1234";
		this.ifMachine = IfMachine.HANGUP;
		this.timeout = 16;

		this.options = new CallOptions();
		this.options.setSendDigits(this.sendDigits);
		this.options.setIfMachine(this.ifMachine);
		this.options.setTimeout(this.timeout);

		this.request = new CreateCallRequest(this.to, this.from, this.callConnectUrl, this.statusCallbackUrl, this.options);
	}

	@Then("^check that it set all fields correctly.$")
	public void checkToField() {
		assertThat(this.request.to, is(this.to));
		assertThat(this.request.from, is(this.from));
		assertThat(this.request.applicationId, is(this.applicationId));
		assertThat(this.request.callConnectUrl, is(this.callConnectUrl));
		assertThat(this.request.statusCallbackUrl, is(this.statusCallbackUrl));
		assertThat(this.request.options, is(this.options));
	}

	@Then("^check that it can produce JSON from the applicationId based object.$")
	public void checkJsonAppIdNoOptions() {
		String json = "{\"to\":\""+this.request.to+"\",\"from\":\""+this.request.from+"\",\"applicationId\":\""+this.request.applicationId+"\"}";
		assertThat(this.request.toJson(), is(json));
	}

	@Then("^check that it can produce JSON from the url based object with options.$")
	public void checkJsonUrlWithOptions() {
		String json = "{\"to\":\""+this.request.to+"\",\"from\":\""+this.request.from+"\",\"callConnectUrl\":\""+this.request.callConnectUrl+"\",\"statusCallbackUrl\":\""+this.request.statusCallbackUrl+"\",\"sendDigits\":\""+this.sendDigits+"\",\"ifMachine\":\"hangup\",\"timeout\":"+this.timeout+"}";
		assertThat(this.request.toJson(), is(json));
	}

}
