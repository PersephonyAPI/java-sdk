package com.vailsys.persephony.percl;

import com.vailsys.persephony.api.conference.PlayBeep;

public class CreateConference extends PerCLCommand {
    private String alias;
    private PlayBeep playBeep;
    private Boolean record;
    private String waitUrl;
    private String statusCallbackUrl;
    private String actionUrl;

    public CreateConference(String actionUrl){
        this.setActionUrl(actionUrl);
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public PlayBeep getPlayBeep() {
        return playBeep;
    }

    public void setPlayBeep(PlayBeep playBeep) {
        this.playBeep = playBeep;
    }

    public Boolean getRecord() {
        return record;
    }

    public void setRecord(Boolean record) {
        this.record = record;
    }

    public String getWaitUrl() {
        return waitUrl;
    }

    public void setWaitUrl(String waitUrl) {
        this.waitUrl = waitUrl;
    }

    public String getStatusCallbackUrl() {
        return statusCallbackUrl;
    }

    public void setStatusCallbackUrl(String statusCallbackUrl) {
        this.statusCallbackUrl = statusCallbackUrl;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }
}
