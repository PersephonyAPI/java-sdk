package com.vailsys.persephony.api.conference;

import java.util.HashMap;
import java.util.Date;
import java.lang.reflect.Type;
import java.text.ParsePosition;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;

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

public class ConferencesSearchFiltersTest {
		private ConferencesSearchFilters rsf;

		@Given("^an empty ConferencesSearchFilters object$")
		public void createRSF() {
			this.rsf = new ConferencesSearchFilters();
		}
		
		@Then("^check that all fields in ConferencesSearchFilters are null$")
		public void checkAllFieldsAreNull() throws Throwable {
			assertThat(this.rsf.getStatus(), nullValue());
			assertThat(this.rsf.getAlias(), nullValue());
			assertThat(this.rsf.getDateCreatedAsString(), nullValue());
			assertThat(this.rsf.getDateUpdatedAsString(), nullValue());
		}

		@Then("^check that the ConferencesSearchFilters status field is (terminated|populated|inProgress)$")
		public void getStatus(String status) 
		{
			ConferenceStatus actualStatus;
			if(status == "terminated") {
				actualStatus = ConferenceStatus.TERMINATED;
			} else if(status == "populated") {
				actualStatus = ConferenceStatus.POPULATED;
			} else {
				actualStatus = ConferenceStatus.IN_PROGRESS;
			}

			assertThat(this.rsf.getStatus(), is(actualStatus));
		}
		@Then("^check that the ConferencesSearchFilters alias field is (.*)$")
		public void getAlias(String alias) 
		{
			assertThat(this.rsf.getAlias(), is(alias));
		}
		@Then("^check that the ConferencesSearchFilters dateCreated field is (\\d{4}-\\d{2}-\\d{2})$")
		public void getDateCreatedAsString(String dateCreated) 
		{
			assertThat(this.rsf.getDateCreatedAsString(), is(dateCreated));
		}
		@Then("^check that the ConferencesSearchFilters dateUpdated field is (\\d{4}-\\d{2}-\\d{2})$")
		public void getDateUpdatedAsString(String dateUpdated) 
		{
			assertThat(this.rsf.getDateUpdatedAsString(), is(dateUpdated));
		}

		@Then("^check that the ConferencesSearchFilters dateCreated field is (\\d{4}-\\d{2}-\\d{2}) as a date$")
		public void getDateCreatedAsDate(String dateCreated)  throws Throwable
		{
			ParsePosition pos = new ParsePosition(0);
			Date dc;
			try {
				dc = this.rsf.dateCreatedFormat.parse(dateCreated, pos);
				if(pos.getErrorIndex() >= 0) {
					fail("Bad date inputted: " + pos.getErrorIndex());
				}
				if(dc == null) {
					fail("null Date");
				}
				assertThat(this.rsf.getDateCreatedAsDate(), is(dc));
			} catch(NullPointerException npe) {
				fail(npe.getMessage());
			}
		}
		@Then("^check that the ConferencesSearchFilters dateUpdated field is (\\d{4}-\\d{2}-\\d{2}) as a date$")
		public void getDateUpdatedAsDate(String dateUpdated) throws Throwable
		{
			ParsePosition pos = new ParsePosition(0);
			Date du;
			try {
				du = this.rsf.dateCreatedFormat.parse(dateUpdated, pos);
				if(pos.getErrorIndex() >= 0) {
					fail("Bad date inputted: " + pos.getErrorIndex());
				}
				if(du == null) {
					fail("null Date");
				}
				assertThat(this.rsf.getDateUpdatedAsDate(), is(du));
			} catch(NullPointerException npe) {
				fail(npe.getMessage());
			}
		}

		@Then("^set the ConferencesSearchFilters status field to (terminated|populated|inProgress)$")
		public void setStatus(String status) 
		{
			ConferenceStatus actualStatus;
			if(status == "terminated") {
				actualStatus = ConferenceStatus.TERMINATED;
			} else if(status == "populated") {
				actualStatus = ConferenceStatus.POPULATED;
			} else {
				actualStatus = ConferenceStatus.IN_PROGRESS;
			}

			this.rsf.setStatus(actualStatus);
		}
		@Then("^set the ConferencesSearchFilters alias field to (.*)$")
		public void setAlias(String alias) 
		{
			this.rsf.setAlias(alias);
		}
		@Then("^set the ConferencesSearchFilters dateCreated field to (\\d{4}-\\d{2}-\\d{2})$")
		public void setDateCreated(String dateCreated) 
		{
			this.rsf.setDateCreated(dateCreated);
		}
		@Then("^set the ConferencesSearchFilters dateUpdated field to (\\d{4}-\\d{2}-\\d{2})$")
		public void setDateUpdated(String dateUpdated) 
		{
			this.rsf.setDateUpdated(dateUpdated);
		}
		@Then("^set the ConferencesSearchFilters dateCreated field to (\\d{4}-\\d{2}-\\d{2}) as a date$")
		public void setDateCreatedDate(String dateCreated) throws Throwable
		{
			ParsePosition pos = new ParsePosition(0);
	
			Date dc;
			try {
				dc = this.rsf.dateCreatedFormat.parse(dateCreated, pos);
				if(pos.getErrorIndex() >= 0) {
					fail("Bad date inputted: " + pos.getErrorIndex());
				}
				if(dc == null) {
					fail("null Date");
				}
				this.rsf.setDateCreated(dc);
			} catch(NullPointerException npe) {
				fail(npe.getMessage());
			}
		}
		@Then("^set the ConferencesSearchFilters dateUpdated field to (\\d{4}-\\d{2}-\\d{2}) as a date$")
		public void setDateUpdatedDate(String dateUpdated) throws Throwable
		{
			ParsePosition pos = new ParsePosition(0);
	
			Date du;
			try {
				du = this.rsf.dateCreatedFormat.parse(dateUpdated, pos);
				if(pos.getErrorIndex() >= 0) {
					fail("Bad date inputted: " + pos.getErrorIndex());
				}
				if(du == null) {
					fail("null Date");
				}
				this.rsf.setDateUpdated(du);
			} catch(NullPointerException npe) {
				fail(npe.getMessage());
			}
		}
}
