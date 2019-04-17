package com.vailsys.persephony.api.call;

import java.util.HashMap;
import java.lang.reflect.Type;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.FieldPosition;

import static com.vailsys.persephony.json.PersyGson.PersyDateFormat;
import static com.vailsys.persephony.json.PersyGson.gson;
import com.vailsys.persephony.api.call.AnsweredBy;
import com.vailsys.persephony.api.call.Direction;
import com.vailsys.persephony.api.call.CallStatus;

import com.google.gson.LongSerializationPolicy;
import com.google.gson.reflect.TypeToken;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CallTest {
	private String origJSON;
	private String otherJSON = "{ \"uri\": \"/Accounts/AC142c48f2ee663e214c19ea459516068c/Calls/CA42ed11f93dc08b952027ffbc406d0868\", \"dateCreated\": \"Tue, 12 Aug 2014 08:02:17 GMT\", \"dateUpdated\": \"Tue, 12 Aug 2014 08:02:47 GMT\", \"revision\": 1, \"callId\": \"CA42ed11f93dc08b952027ffbc40600000\", \"parentcallId\": null, \"accountId\": \"AC142c48f2ee663e214c19ea459516068c\", \"to\": \"+14153855708\", \"from\": \"+14158141819\", \"phoneNumberId\": null, \"status\": \"completed\", \"startTime\": \"Tue, 12 Aug 2014 08:02:31 GMT\", \"connectTime\": \"Tue, 12 Aug 2014 08:02:50 GMT\", \"endTime\": \"Tue, 12 Aug 2014 08:02:47 GMT\", \"duration\": 16, \"connectDuration\": 13, \"direction\": \"outboundAPI\", \"answeredBy\": null, \"callerName\": null, \"subresourceUris\": { \t\"notifications\": \"/Accounts/AC142c48f2ee663e214c19ea459516068c/Calls/CAe1644a7eed5088b159577c5802d8be38/Notifications\", \t\"recordings\": \"/Accounts/AC142c48f2ee663e214c19ea459516068c/Calls/CAe1644a7eed5088b159577c5802d8be38/Recordings\" } }";
	private Call theCall;

	@Given("^Some JSON representing a call.$")
	public void storeJSON() {
		this.origJSON = "{ \"uri\": \"/Accounts/AC142c48f2ee663e214c19ea459516068c/Calls/CA42ed11f93dc08b952027ffbc406d0868\", \"dateCreated\": \"Tue, 12 Aug 2014 08:02:17 GMT\", \"dateUpdated\": \"Tue, 12 Aug 2014 08:02:47 GMT\", \"revision\": 1, \"callId\": \"CA42ed11f93dc08b952027ffbc406d0868\", \"parentcallId\": null, \"accountId\": \"AC142c48f2ee663e214c19ea459516068c\", \"to\": \"+14153855708\", \"from\": \"+14158141819\", \"phoneNumberId\": null, \"status\": \"completed\", \"startTime\": \"Tue, 12 Aug 2014 08:02:31 GMT\", \"connectTime\": \"Tue, 12 Aug 2014 08:02:50 GMT\", \"endTime\": \"Tue, 12 Aug 2014 08:02:47 GMT\", \"duration\": 16, \"connectDuration\": 13, \"direction\": \"outboundAPI\", \"answeredBy\": null, \"callerName\": null, \"subresourceUris\": { \t\"notifications\": \"/Accounts/AC142c48f2ee663e214c19ea459516068c/Calls/CAe1644a7eed5088b159577c5802d8be38/Notifications\", \t\"recordings\": \"/Accounts/AC142c48f2ee663e214c19ea459516068c/Calls/CAe1644a7eed5088b159577c5802d8be38/Recordings\" } }";
	}

	@Then("^build a Call object from that JSON.$")
	public void buildCall() throws Throwable {
		this.theCall = Call.fromJson(origJSON);
	}

	@Then("^check the contents of that object.$")
	public void checkCallAgainstJson() {
		Type t = new TypeToken<HashMap<String, Object>>(){}.getType();
		HashMap<String, Object> jsonMap = gson.fromJson(this.origJSON, t);

		assertThat((String)jsonMap.get("callId"), is(this.theCall.getCallId()));
		assertThat((String)jsonMap.get("parentd"), is(this.theCall.getParentCallId()));
		assertThat((String)jsonMap.get("accountId"), is(this.theCall.getAccountId()));
		assertThat((String)jsonMap.get("to"), is(this.theCall.getTo()));
		assertThat((String)jsonMap.get("from"), is(this.theCall.getFrom()));
		assertThat((String)jsonMap.get("phoneNumberId"), is(this.theCall.getPhoneNumberId()));

		String completed = gson.toJson(CallStatus.COMPLETED);
		completed = completed.substring(1,completed.length()-1);
		assertThat((String)jsonMap.get("status"), is(completed));
		assertThat(this.theCall.getStatus(), is(CallStatus.COMPLETED));

		StringBuffer dateString = new StringBuffer();
		PersyDateFormat.format(this.theCall.getStartTime(), dateString, new FieldPosition(0));
		assertThat((String)jsonMap.get("startTime"), is(dateString.toString()));

		dateString = new StringBuffer();
		PersyDateFormat.format(this.theCall.getConnectTime(), dateString, new FieldPosition(0));
		assertThat((String)jsonMap.get("connectTime"), is(dateString.toString()));

		dateString = new StringBuffer();
		PersyDateFormat.format(this.theCall.getEndTime(), dateString, new FieldPosition(0));
		assertThat((String)jsonMap.get("endTime"), is(dateString.toString()));

		assertThat((Integer) ((Double) jsonMap.get("duration")).intValue(), is(this.theCall.getDuration()));
		assertThat((Integer) ((Double) jsonMap.get("connectDuration")).intValue(), is(this.theCall.getConnectDuration()));

		String outboundAPI = gson.toJson(Direction.OUTBOUND_API);
		outboundAPI = outboundAPI.substring(1,outboundAPI.length()-1);
		assertThat((String)jsonMap.get("direction"), is(outboundAPI));
		assertThat(this.theCall.getDirection(), is(Direction.OUTBOUND_API));

		assertThat((AnsweredBy)jsonMap.get("answeredBy"), is(this.theCall.getAnsweredBy()));
		assertThat((String)jsonMap.get("callerName"), is(this.theCall.getCallerName()));

		com.google.gson.internal.LinkedTreeMap mmm = ((com.google.gson.internal.LinkedTreeMap)jsonMap.get("subresourceUris"));
		assertThat((String)mmm.get("recordings"), is(this.theCall.getSubresourceUris().get("recordings")));
		assertThat((String)mmm.get("notifications"), is(this.theCall.getSubresourceUris().get("notifications")));
	}

	@Then("^check the call is( not)? equal.$")
	public void checkEqual(String not) throws Throwable {
		if (not == null) {
			assertTrue(this.theCall.equals(Call.fromJson(origJSON)));
		} else {
			assertFalse(this.theCall.equals(Call.fromJson(otherJSON)));
		}
	}
}
