package com.vailsys.persephony.api.recording;

import java.util.HashMap;
import java.util.Date;
import java.lang.reflect.Type;
import java.text.ParsePosition;

import com.vailsys.persephony.api.APIRequester;
import com.vailsys.persephony.api.PersySDKException;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyDateException;
import static com.vailsys.persephony.json.PersyGson.gson;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.anything;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.gson.reflect.TypeToken;

public class RecordingsSearchFiltersTest {
		private RecordingsSearchFilters rsf;

		@Given("^an empty RecordingsSearchFilters object$")
		public void createRSF() {
			this.rsf = new RecordingsSearchFilters();
		}
		
		@Then("^check that all fields in RecordingsSearchFilters are null$")
		public void checkAllFieldsAreNull() throws Throwable {
			assertThat(this.rsf.getCallId(), nullValue());
			assertThat(this.rsf.getDateCreated(), nullValue());
			try {
				this.rsf.getDateCreatedAsDate();
			} catch(PersySDKException pse) {
				fail("getDateCreatedAsDate should have failed with a PersyException but failed with " + pse.getMessage());
				return;
			} catch(PersyDateException pde) {
				fail("getDateCreatedAsDate should have failed with a PersyException but failed with " + pde.getMessage());
				return;
			} catch(PersyException pe) {
				assertThat(pe, anything());
				return;
			}
			fail("getDateCreatedAsDate should have failed with a PersyException");
		}

		@Then("^set the RecordingsSearchFilters callId to (CA[0-9A-Fa-f]{40})$")
		public void setCallId(String callId) {
			this.rsf.setCallId(callId);
		}
		
		@Then("^check that the RecordingsSearchFilters callId field is (CA[0-9A-Fa-f]{40})$")
		public void checkGetCallId(String callId) {
			assertThat(this.rsf.getCallId(), is(callId));
		}

		@Then("^set the RecordingsSearchFilters dateCreated to ([0-9]{4}-[01][0-9]-[0-3][0-9]) as a String$")
		public void setDateCreatedAsString(String dateCreated) {
			this.rsf.setDateCreated(dateCreated);
		}

		@Then("^set the RecordingsSearchFilters dateCreated to ([0-9]{4}-[01][0-9]-[0-3][0-9]) as a Date$")
		public void setDateCreatedAsDate(String dateCreated) {
			ParsePosition pos = new ParsePosition(0);
			Date checkDate = RecordingsSearchFilters.dateCreatedFormat.parse(dateCreated, pos);
			assertTrue(pos.getErrorIndex() < 0);

			this.rsf.setDateCreated(checkDate);
		}
		
		@Then("^check that the RecordingsSearchFilters dateCreated field is ([0-9]{4}-[01][0-9]-[0-3][0-9])$")
		public void checkGetDateCreated(String dateCreated) throws PersyException {
			ParsePosition pos = new ParsePosition(0);
			Date checkDate = RecordingsSearchFilters.dateCreatedFormat.parse(dateCreated, pos);
			assertTrue(pos.getErrorIndex() < 0);

			assertThat(this.rsf.getDateCreated(), is(dateCreated));
			assertThat(this.rsf.getDateCreatedAsDate(), is(checkDate));
		}
	
		@Then("^check that the string representation of the RecordingsSearchFilters is correct$")
		public void checkToString() throws Throwable {
			HashMap<String,String> filtersMap = new HashMap<String,String>();
			
			String callId = this.rsf.getCallId();
			if(callId != null) {
				filtersMap.put("callId", callId);
			}
			
			String dateCreated = this.rsf.getDateCreated();
			if(dateCreated != null) {
				filtersMap.put("dateCreated", dateCreated);
			}

			assertThat(this.rsf.toString(), is(APIRequester.mapToQueryString(filtersMap)));
		}
}
