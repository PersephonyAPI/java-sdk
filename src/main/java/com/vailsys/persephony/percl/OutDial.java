package com.vailsys.persephony.percl;

public class OutDial extends PerCLCommand {
	private String destination;
	private String callingNumber;
	private String actionUrl;
	private String callConnectUrl;

	private String sendDigits;
	private Integer timeout;
	private OutDialIfMachine ifMachine;
	private String ifMachineUrl;
	private String statusCallbackUrl;

	public OutDial(String destination, String callingNumber, String actionUrl, String callConnectUrl){
		this.setDestination(destination);
		this.setCallingNumber(callingNumber);
		this.setActionUrl(actionUrl);
		this.setCallConnectUrl(callConnectUrl);
	}

	public String getDestination() {
		return this.destination;
	}
	
	public String getCallingNumber() {
		return this.callingNumber;
	}
	
	public String getActionUrl() {
		return this.actionUrl;
	}
	
	public String getCallConnectUrl() {
		return this.callConnectUrl;
	}
	
	public String getSendDigits() {
		return this.sendDigits;
	}
	
	public Integer getTimeout() {
		return this.timeout;
	}
	
	public OutDialIfMachine getIfMachine() {
		return this.ifMachine;
	}
	
	public String getIfMachineUrl() {
		return this.ifMachineUrl;
	}
	
	public String getStatusCallbackUrl() {
		return this.statusCallbackUrl;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public void setCallingNumber(String callingNumber) {
		this.callingNumber = callingNumber;
	}
	
	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}
	
	public void setCallConnectUrl(String callConnectUrl) {
		this.callConnectUrl = callConnectUrl;
	}
	
	public void setSendDigits(String sendDigits) {
		this.sendDigits = sendDigits;
	}
	
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}
	
	public void setIfMachine(OutDialIfMachine ifMachine) {
		this.ifMachine = ifMachine;
	}
	
	public void setIfMachineUrl(String ifMachineUrl) {
		this.ifMachineUrl = ifMachineUrl;
	}
	
	public void setStatusCallbackUrl(String statusCallbackUrl) {
		this.statusCallbackUrl = statusCallbackUrl;
	}
	
}
