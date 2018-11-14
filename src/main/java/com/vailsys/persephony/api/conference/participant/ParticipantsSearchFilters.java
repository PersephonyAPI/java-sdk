package com.vailsys.persephony.api.conference.participant;

import com.vailsys.persephony.api.Filters;

/**
 * Represents the possible fields one can set as filters when searching for
 * participants.
 */
public class ParticipantsSearchFilters extends Filters {
    /**
     * Whether the participant has permissions to speak.
     */
    private Boolean talk;
    /**
     * Whether the participant has permissions to listen.
     */
    private Boolean listen;

    /**
     * Retrieve the value of the talk filter.
     *
     * @return The talk value of the participant.
     */
    public Boolean getTalk() {
        return talk;
    }

    /**
     * Set the talk filter to find participants that are able/unable to talk.
     * @param talk Filter by muted / unmuted participants.
     */
    public void setTalk(Boolean talk) {
        this.talk = talk;
    }

    /**
     * Retrieve the value of the listen filter.
     *
     * @return The listen value of the participant.
     */
    public Boolean getListen() {
        return listen;
    }

    /**
     * Set the listen filter to find participants that are able/unable to listen.
     * @param listen Filter by deafened / non-deafened participants.
     */
    public void setListen(Boolean listen) {
        this.listen = listen;
    }
}
