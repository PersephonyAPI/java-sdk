package com.vailsys.persephony.percl;

public class Redirect extends PerCLCommand {
    private String actionUrl;

    public Redirect(String actionUrl){
        this.setActionUrl(actionUrl);
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }
}
