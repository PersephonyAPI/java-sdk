package com.vailsys.persephony.percl;

public class TerminateConference extends PerCLCommand {
    private String conferenceId;

    public TerminateConference(String conferenceId){
        this.setConferenceId(conferenceId);
    }

    public String getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(String conferenceId) {
        this.conferenceId = conferenceId;
    }
}
