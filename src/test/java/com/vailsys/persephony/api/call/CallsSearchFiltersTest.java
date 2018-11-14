package com.vailsys.persephony.api.call;

import java.util.HashMap;
import java.util.Date;
import java.lang.reflect.Type;

import com.vailsys.persephony.api.APIRequester;
import static com.vailsys.persephony.json.PersyGson.gson;
import com.vailsys.persephony.api.call.CallStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import com.google.gson.reflect.TypeToken;

public class CallsSearchFiltersTest {
		private static Type t = new TypeToken<CallStatus>(){}.getType();

		private CallsSearchFilters csf;
		private Date now;

		@Given("^an empty CallsSearchFilters object$")
		public void createEmpty() {
			this.csf = new CallsSearchFilters();
		}

		@Then("^check that all fields are null$")
		public void checkAllAreNull() {
			assertThat(this.csf.getTo(), nullValue());
			assertThat(this.csf.getFrom(), nullValue());
			assertThat(this.csf.getStatus(), nullValue());
			assertThat(this.csf.getStartTime(), nullValue());
			assertThat(this.csf.getEndTime(), nullValue());
			assertThat(this.csf.getStartTimeLong(), nullValue());
			assertThat(this.csf.getEndTimeLong(), nullValue());
			assertThat(this.csf.getParentCallId(), nullValue());
		}

		@Then("^store the current time in a Date object$")
		public void saveDate() {
			this.now = new Date();
		}

		@Then("^insert the saved Date into the startTime and endTime fucntions as a Date$")
		public void insertDateAsDate() {
			this.csf.setStartTime(this.now);	
			this.csf.setEndTime(this.now);	
		}

		@Then("^insert the saved Date into the startTime and endTime fucntions as a Long representing the the unix timestamp in seconds$")
		public void insertDateAsLong() {
			this.csf.setStartTime(this.now.getTime()/1000);	
			this.csf.setEndTime(this.now.getTime()/1000);	
		}
		
		@Then("^check that the saved startTime and endTime are the saved Date truncated to seconds$")
		public void checkTimesMatchSavedDate() {
			Long longObject = this.now.getTime()/1000;
			Date dateObject = new Date(longObject*1000);

			assertThat(this.csf.getStartTime(), is(dateObject));
			assertThat(this.csf.getStartTimeLong(), is(longObject));

			assertThat(this.csf.getEndTime(), is(dateObject));
			assertThat(this.csf.getEndTimeLong(), is(longObject));
		}
		
		@Then("^set the to number to (\\+?[1-9]\\d{1,14})$")
		public void setToNumber(String to) {
			this.csf.setTo(to);
		}
		@Then("^check that the to number is (\\+?[1-9]\\d{1,14})$")
		public void checkToNumber(String to) {
			assertThat(this.csf.getTo(), is(to));
		}
		
		@Then("^set the from number to (\\+?[1-9]\\d{1,14})$")
		public void setFromNumber(String from) {
			this.csf.setFrom(from);
		}
		@Then("^check that the from number is (\\+?[1-9]\\d{1,14})$")
		public void checkFromNumber(String from) {
			assertThat(this.csf.getFrom(), is(from));
		}

		@Then("^set the status to (\\w+)$")
		public void setStatus(String status) {
			CallStatus stat = gson.fromJson(status, this.t);
			this.csf.setStatus(stat);
		}
		@Then("^check that the status is (\\w+)$")
		public void checkStatus(String status) {
			CallStatus stat = gson.fromJson(status, this.t);
			assertThat(this.csf.getStatus(), is(stat));
		}

		@Then("^set the parentCallId to (CA[0-9A-Fa-f]{40})$")
		public void setParentCallId(String parentCallId) {
			this.csf.setParentCallId(parentCallId);
		}
		@Then("^check that the parentCallId is (CA[0-9A-Fa-f]{40})$")
		public void checkParentCallId(String parentCallId) {
			assertThat(this.csf.getParentCallId(), is(parentCallId));
		}

		@Then("^check that the string representation is correct$")
		public void checkToString() throws Throwable {
			HashMap<String,String> filtersMap = new HashMap<String,String>();
			
			String to = this.csf.getTo();
			if(to != null) {
				filtersMap.put("to", to);
			}
			
			String from = this.csf.getFrom();
			if(from != null) {
				filtersMap.put("from", from);
			}

			CallStatus status = this.csf.getStatus();
			if(status != null) {
				String statusString = gson.toJson(status);
				filtersMap.put("status", statusString.substring(1,statusString.length()-1));
			}

			Long startTime = this.csf.getStartTimeLong();
			if(startTime != null) {
				filtersMap.put("startTime", startTime.toString());
			}

			Long endTime = this.csf.getEndTimeLong();
			if(endTime != null) {
				filtersMap.put("endTime", endTime.toString());
			}

			String parentCallId = this.csf.getParentCallId();
			if(parentCallId != null) {
				filtersMap.put("parentCallId", parentCallId);
			}

			assertThat(this.csf.toString(), is(APIRequester.mapToQueryString(filtersMap)));
		}
}
