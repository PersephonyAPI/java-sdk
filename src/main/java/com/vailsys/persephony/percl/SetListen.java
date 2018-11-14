package com.vailsys.persephony.percl;

public class SetListen extends PerCLCommand {
    private String callId;
    private Boolean listen;

    public SetListen(String callId){
        this.setCallId(callId);
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public Boolean getListen() {
        return listen;
    }

    public void setListen(Boolean listen) {
        this.listen = listen;
    }
}
