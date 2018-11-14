package com.vailsys.persephony.api.call;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CallListTest {

	private static String testCall = "{ \"uri\": \"/Accounts/AC142c48f2ee663e214c19ea459516068c/Calls/CA42ed11f93dc08b952027ffbc406d0868\", \"dateCreated\": \"Tue, 12 Aug 2014 08:02:17 GMT\", \"dateUpdated\": \"Tue, 12 Aug 2014 08:02:47 GMT\", \"revision\": 1, \"callId\": \"CA42ed11f93dc08b952027ffbc406d0868\", \"parentcallId\": null, \"accountId\": \"AC142c48f2ee663e214c19ea459516068c\", \"to\": \"+14153855708\", \"from\": \"+14158141819\", \"phoneNumberId\": null, \"status\": \"completed\", \"startTime\": \"Tue, 12 Aug 2014 08:02:31 GMT\", \"endTime\": \"Tue, 12 Aug 2014 08:02:47 GMT\", \"duration\": \"16\", \"direction\": \"outboundAPI\", \"answeredBy\": null, \"callerName\": null, \"subresourceUris\": { \t\"notifications\": \"/Accounts/AC142c48f2ee663e214c19ea459516068c/Calls/CAe1644a7eed5088b159577c5802d8be38/Notifications\", \t\"recordings\": \"/Accounts/AC142c48f2ee663e214c19ea459516068c/Calls/CAe1644a7eed5088b159577c5802d8be38/Recordings\" } }";


	private static String inputJson = "{\"total\": 1, \"start\": 0, \"end\": 0, \"page\": 0, \"numPages\": 1, \"pageSize\": 1, \"nextPageUri\": null, \"calls\": ["+CallListTest.testCall+"]}";

	private CallList list;
	
	@Given("^a CallList object.$")
	public void makeListFromJson() throws Throwable {
		this.list = new CallList("ACCOUNTID", "AUTHTOKEN", CallListTest.inputJson);
	}

	@Then("^check that it was built correctly.$")
	public void checkList() {
		assertThat(this.list.getLocalSize(), is(1));
	}
}
