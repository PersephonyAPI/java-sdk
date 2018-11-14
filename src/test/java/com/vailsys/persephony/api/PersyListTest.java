package com.vailsys.persephony.api;

import static com.vailsys.persephony.json.PersyGson.gson;

import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;
import java.io.IOException;
import java.io.StringReader;

import com.google.gson.JsonElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.instanceOf;

import static org.junit.Assert.assertThat;

public class PersyListTest {
	private static String inputJson = "{\"total\": 2, \"start\": 0, \"end\": 0, \"page\": 0, \"numPages\": 2, \"pageSize\": 1, \"nextPageUri\": \"/Accounts?newpage=veryyes\", \"tests\": [{\"uri\": \"/Accounts/ac3iu409/Recordings/RE382904702\", \"dateUpdated\": \"Fri, 10 Jun 2016 21:35:27 GMT\", \"dateCreated\": \"Fri, 10 Jun 2016 21:35:27 GMT\", \"revision\": 0, \"testValue\": \"VALUE!!!\"}]}";
	private TestsList list;

	@Given("^some JSON representing a test list$")
	public void makeListFromJson() throws Throwable {
		this.list = new TestsList("ACCOUNTID", "AUTHTOKEN", PersyListTest.inputJson);
	}

	@Then("^check the list operations$")
	public void checkPrimitives() {
		assertThat(this.list.getTotalSize(), is(2));
		assertThat(this.list.getLocalSize(), is(1));
		assertThat(this.list.get(0), notNullValue());
		assertThat(this.list.get(0).getTestValue(), is("VALUE!!!"));
		assertThat(this.list.export(), notNullValue());
		assertThat(this.list.export().size(), is(this.list.getLocalSize()));
	}

	private class TestsList extends PersyList<Test> {
	
		public TestsList(String accountId, String authToken, String rawPage) throws PersyException {
			super(accountId, authToken, rawPage, "tests", Test.class);
		}

		public Test get(int i) {
			return (Test)(super.get(i));
		}

		public void buildFromJson(String rawPage) throws PersyJSONException {
			super.buildFromJson(rawPage);
		}
	}
	protected class Test extends PersyCommon {
		private String testValue;

		public Test(String val) throws PersyException {
			//super("/Accounts/alkjdfls/Calls", "Fri, 10 Jun 2016 21:35:27 GMT", "Fri, 10 Jun 2016 21:35:27 GMT", 101);
			this.testValue = val;
		}

		public String getTestValue() {
			return this.testValue;
		}

		public String toString() {
			return "!!!atESToBJECT:::"+super.getUri()+"!!!"+this.testValue+"!!!";
		}
	}
}
