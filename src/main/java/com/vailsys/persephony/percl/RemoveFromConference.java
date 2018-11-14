package com.vailsys.persephony.percl;

public class RemoveFromConference extends PerCLCommand {
    private String callId;

    public RemoveFromConference(String callId) {
        this.setCallId(callId);
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }
}
