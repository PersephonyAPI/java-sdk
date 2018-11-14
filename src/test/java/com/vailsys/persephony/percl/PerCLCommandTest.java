package com.vailsys.persephony.percl;
import static com.vailsys.persephony.json.PersyGson.gson;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class PerCLCommandTest {

	private PerCLCommand command;
	private static final String testFieldValue = "!!!!!!!!TestFIELD!!!!!!!";

	@Given("^a TestCommand which is a PerCLCommand$")
	public void makeTestCommand() {
		command = new TestCommand(testFieldValue);
	}

	@Then("^check that it can be converted to JSON$")
	public void canConvertCommandToJSON() {
		assertThat(command.toJson(), is("{\""+command.getClass().getSimpleName()+"\":{\"testField\":\""+testFieldValue+"\"}}"));
	}

	private class TestCommand extends PerCLCommand{
		private String testField;
		private String empty;
		private Integer emptyAlso;

		public TestCommand(String testField) {
			this.testField = testField;
		}
	}
}
