package com.vailsys.persephony.percl;

public class Hangup extends PerCLCommand {
	private String callId;
	private String reason;

	public Hangup(){}

	public String getCallId() {
		return this.callId;	
	}

	public String getReason() {
		return this.reason;	
	}

	public void setCallId(String callId) {
		this.callId = callId;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
