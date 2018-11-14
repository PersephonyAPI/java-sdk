package com.vailsys.persephony.api.conference.participant;

import com.vailsys.persephony.api.CommonFields;

/**
 * The class representing the optional fields which can be passed in when updating a Participant.
 */
public class ParticipantUpdateOptions extends CommonFields {
    /**
     * The talk setting of the participant.
     */
    private Boolean talk;
    /**
     * The listen setting of the participant.
     */
    private Boolean listen;

    /**
     * Retrieve the talk value.
     *
     * @return The talk value of the object.
     */
    public Boolean getTalk() {
        return talk;
    }

    /**
     * Sets the talk field.
     * @param talk Whether or not the participant should be muted.
     */
    public void setTalk(Boolean talk) {
        this.talk = talk;
    }

    /**
     * Retrieve the listen value.
     *
     * @return The listen value of the object.
     */
    public Boolean getListen() {
        return listen;
    }

    /**
     * Sets the listen field.
     * @param listen Whether or not the participant should be deafened.
     */
    public void setListen(Boolean listen) {
        this.listen = listen;
    }
}
