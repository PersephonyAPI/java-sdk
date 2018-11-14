package com.vailsys.persephony.percl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.PendingException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;

public class OutDialTest {

	OutDial command;

	@Given("^an OutDial with destination (\\+1[0-9]{10}), callingNumber (\\+1[0-9]{10}), actionUrl (.*), and callConnectUrl (.*)$")
	public void createOutDial(String destination, String callingNumber, String actionUrl, String callConnectUrl) {
		this.command = new OutDial(destination, callingNumber, actionUrl, callConnectUrl);
	}

	@Then("^check that the non-default fields are null in the OutDial object$")
	public void checkareNull() {
		assertThat(this.command.getSendDigits(), nullValue());
		assertThat(this.command.getTimeout(), nullValue());
		assertThat(this.command.getIfMachine(), nullValue());
		assertThat(this.command.getIfMachineUrl(), nullValue());
		assertThat(this.command.getStatusCallbackUrl(), nullValue());
	}
	@Then("^check that destination is (\\+1[0-9]{10}) in the OutDial object$")
	public void checkDestination(String destination) {
		assertThat(this.command.getDestination(), is(destination));
	}
	@Then("^set destination to (\\+1[0-9]{10}) in OutDial object$")
	public void setDestination(String destination) {
		this.command.setDestination(destination);	
	}

	@Then("^check that callingNumber is (\\+1[0-9]{10}) in the OutDial object$")
	public void checkCallingNumber(String callingNumber) {
		assertThat(this.command.getCallingNumber(), is(callingNumber));
	}
	@Then("^set callingNumber to (\\+1[0-9]{10}) in OutDial object$")
	public void setCallingNumber(String callingNumber) {
		this.command.setCallingNumber(callingNumber);	
	}

	@Then("^check that actionUrl is (.*) in the OutDial object$")
	public void checkActionUrl(String actionUrl) {
		assertThat(this.command.getActionUrl(), is(actionUrl));
	}
	@Then("^set actionUrl to (.*) in OutDial object$")
	public void setActionUrl(String actionUrl) {
		this.command.setActionUrl(actionUrl);	
	}

	@Then("^check that callConnectUrl is (.*) in the OutDial object$")
	public void checkCallConnectUrl(String callConnectUrl) {
		assertThat(this.command.getCallConnectUrl(), is(callConnectUrl));
	}
	@Then("^set callConnectUrl to (.*) in OutDial object$")
	public void setCallConnectUrl(String callConnectUrl) {
		this.command.setCallConnectUrl(callConnectUrl);	
	}

	@Then("^check that sendDigits is ([0-9*#]*) in the OutDial object$")
	public void checkSendDigits(String sendDigits){
		assertThat(this.command.getSendDigits(), is(sendDigits));
	}
	@Then("^set sendDigits to ([0-9*#]*) in OutDial object$")
	public void setSendDigits(String sendDigits) {
		this.command.setSendDigits(sendDigits);
	}
	@Then("^check that timeout is (.*) in the OutDial object$")
	public void checkTimeout(Integer timeout){
		assertThat(this.command.getTimeout(), is(timeout));
	}
	@Then("^set timeout to (.*) in OutDial object$")
	public void setTimeout(Integer timeout) {
		this.command.setTimeout(timeout);
	}
	@Then("^check that ifMachine is (redirect|hangup) in the OutDial object$")
	public void checkIfMachine(String strIfMachine) throws Throwable {
		OutDialIfMachine ifMachine;
		if(strIfMachine == "redirect") {
			ifMachine = OutDialIfMachine.REDIRECT;
		} else {
			ifMachine = OutDialIfMachine.HANGUP;
		}
		assertThat(this.command.getIfMachine(), is(ifMachine));
	}
	@Then("^set ifMachine to (redirect|hangup) in OutDial object$")
	public void setIfMachine(String strIfMachine) throws Throwable {
		OutDialIfMachine ifMachine;
		if(strIfMachine == "redirect") {
			ifMachine = OutDialIfMachine.REDIRECT;
		} else {
			ifMachine = OutDialIfMachine.HANGUP;
		}
		this.command.setIfMachine(ifMachine);
	}
	@Then("^check that ifMachineUrl is (.*) in the OutDial object$")
	public void checkIfMachineUrl(String ifMachineUrl){
		assertThat(this.command.getIfMachineUrl(), is(ifMachineUrl));
	}
	@Then("^set ifMachineUrl to (.*) in OutDial object$")
	public void setIfMachineUrl(String ifMachineUrl) {
		this.command.setIfMachineUrl(ifMachineUrl);
	}
	@Then("^check that statusCallbackUrl is (.*) in the OutDial object$")
	public void checkStatusCallbackUrl(String statusCallbackUrl){
		assertThat(this.command.getStatusCallbackUrl(), is(statusCallbackUrl));
	}
	@Then("^set statusCallbackUrl to (.*) in OutDial object$")
	public void setStatusCallbackUrl(String statusCallbackUrl) {
		this.command.setStatusCallbackUrl(statusCallbackUrl);
	}
}
