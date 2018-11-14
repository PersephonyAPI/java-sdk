package com.vailsys.persephony.percl;

public class AddToConference extends PerCLCommand {
    private String conferenceId;
    private String callId;
    private Boolean startConfOnEnter;
    private Boolean talk;
    private Boolean listen;
    private String leaveConferenceUrl;
    private String notificationUrl;
    private Boolean allowCallControl;
    private String callControlSequence;
    private String callControlUrl;

    public AddToConference(String conferenceId, String callId){
        this.setConferenceId(conferenceId);
        this.setCallId(callId);
    }

    public String getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(String conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public Boolean getStartConfOnEnter() {
        return startConfOnEnter;
    }

    public void setStartConfOnEnter(Boolean startConfOnEnter) {
        this.startConfOnEnter = startConfOnEnter;
    }

    public Boolean getTalk() {
        return talk;
    }

    public void setTalk(Boolean talk) {
        this.talk = talk;
    }

    public Boolean getListen() {
        return listen;
    }

    public void setListen(Boolean listen) {
        this.listen = listen;
    }

    public String getLeaveConferenceUrl() {
        return leaveConferenceUrl;
    }

    public void setLeaveConferenceUrl(String leaveConferenceUrl) {
        this.leaveConferenceUrl = leaveConferenceUrl;
    }

    public String getNotificationUrl() {
        return notificationUrl;
    }

    public void setNotificationUrl(String notificationUrl) {
        this.notificationUrl = notificationUrl;
    }

    public Boolean getAllowCallControl() {
        return allowCallControl;
    }

    public void setAllowCallControl(Boolean allowCallControl) {
        this.allowCallControl = allowCallControl;
    }

    public String getCallControlSequence() {
        return callControlSequence;
    }

    public void setCallControlSequence(String callControlSequence) {
        this.callControlSequence = callControlSequence;
    }

    public String getCallControlUrl() {
        return callControlUrl;
    }

    public void setCallControlUrl(String callControlUrl) {
        this.callControlUrl = callControlUrl;
    }
}
