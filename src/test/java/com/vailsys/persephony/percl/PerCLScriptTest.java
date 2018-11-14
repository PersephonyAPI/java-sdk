package com.vailsys.persephony.percl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class PerCLScriptTest {

	private PerCLScript script;

	@Given("^an empty PerCLScript$")
	public void makeTestScript() {
		script = new PerCLScript();
	}

	@Then("^check that a command can be added to the script$")
	public void canAddACommandToTheScript() {
		int len = script.size();
		TestCommand command = new TestCommand("COMMAND::"+System.nanoTime()+"::COMMAND");

		script.add(command);

		assertThat(script.size(), is(len+1));
		assertThat((TestCommand)(script.get(len)), is(command));
	}

	@Then("^add a command to the script$")
	public void addACommandToTheScript() {
		script.add(new TestCommand("COMMAND::SIMPLE::COMMAND"));
	}

	@Then("^check that the script can be converted to JSON$")
	public void canConvertScriptToJSON() {
		assertThat(script.toJson(), is("[{\"TestCommand\":{\"testField\":\"COMMAND::SIMPLE::COMMAND\"}},{\"TestCommand\":{\"testField\":\"COMMAND::SIMPLE::COMMAND\"}},{\"TestCommand\":{\"testField\":\"COMMAND::SIMPLE::COMMAND\"}},{\"TestCommand\":{\"testField\":\"COMMAND::SIMPLE::COMMAND\"}}]"));
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
