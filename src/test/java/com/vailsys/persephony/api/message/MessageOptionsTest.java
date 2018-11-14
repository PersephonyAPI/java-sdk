package com.vailsys.persephony.api.message;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;

public class MessageOptionsTest {

	MessageOptions options;

	@Given("^An empty MessageOptions object.$")
	public void createMessageOptions() {
		this.options = new MessageOptions();
	}

	@Then("^check that all MessageOptions fields are null.$")
	public void checkFieldsAreNull() {
		assertThat(this.options.getNotificationUrl(), nullValue());
	}

	@Then("^check that setNotificationUrl\\(\\) and getNotificationUrl\\(\\) are setting and retrieving the correct value.$")
	public void checkSetGetNotificationUrl() {
		String notificationUrl = "http://myapp.com/notification-url";
		this.options.setNotificationUrl(notificationUrl);
		assertThat(this.options.getNotificationUrl(), is(notificationUrl));
	}
}

