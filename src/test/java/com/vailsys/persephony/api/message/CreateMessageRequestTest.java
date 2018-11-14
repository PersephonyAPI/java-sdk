package com.vailsys.persephony.api.message;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class CreateMessageRequestTest {

	String to = "+13125551234";
	String from = "+17735558245";

	String text = "Outbound Message";

	MessageOptions options = null;
	String notificationUrl = null;

	CreateMessageRequest request;

	@Given("^a CreateMessageRequest without options.$")
	public void createWithoutOptions() {
		this.notificationUrl = null;
		this.options = null;

		this.request = new CreateMessageRequest(this.to, this.from, this.text, this.options);
	}

	@Given("^a CreateMessageRequest with options.$")
	public void createWithOptions() {
		this.notificationUrl = "http://myapp.com/notification-url";

		this.options = new MessageOptions();
		this.options.setNotificationUrl(this.notificationUrl);

		this.request = new CreateMessageRequest(this.to, this.from, this.text, this.options);
	}

	@Then("^check that it set all CreateMessageRequest fields correctly.$")
	public void checkFields() {
		assertThat(this.request.to, is(this.to));
		assertThat(this.request.from, is(this.from));
		assertThat(this.request.text, is(this.text));
		assertThat(this.request.options, is(this.options));
	}

	@Then("^check that it can produce JSON for a create message request from the object without options.$")
	public void checkJsonWithoutOptions() {
		String json = "{\"to\":\""+this.request.to+"\",\"from\":\""+this.request.from+"\",\"text\":\""+this.request.text+"\"}";
		assertThat(this.request.toJson(), is(json));
	}

	@Then("^check that it can produce JSON for a create message request from the object with options.$")
	public void checkJsonWithOptions() {
		String json = "{\"to\":\""+this.request.to+"\",\"from\":\""+this.request.from+"\",\"text\":\""+this.request.text+"\",\"notificationUrl\":\""+this.notificationUrl + "\"}";
		assertThat(this.request.toJson(), is(json));
	}

}

