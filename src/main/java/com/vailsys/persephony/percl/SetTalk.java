package com.vailsys.persephony.percl;

public class SetTalk extends PerCLCommand {
    private String callId;
    private Boolean talk;

    public SetTalk(String callId){
        this.setCallId(callId);
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public Boolean getTalk() {
        return talk;
    }

    public void setTalk(Boolean talk) {
        this.talk = talk;
    }
}
