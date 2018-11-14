package com.vailsys.persephony.api.conference.participant;

import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyCommon;
import com.vailsys.persephony.api.PersyJSONException;

import static com.vailsys.persephony.json.PersyGson.gson;

/**
 * This class represents a Persephony Participant instance. Participant objects are created
 * by the SDK whenever a participant would be returned by the API; these
 * primarily come from a {@link com.vailsys.persephony.api.conference.participant.ParticipantsRequester}
 * inside a {@link com.vailsys.persephony.api.PersyClient} instance.<br>
 * <br>
 * Participants are immutable and intended only to be used to read information
 * returned from the API in a language accessible way.
 *
 * @see com.vailsys.persephony.api.conference.participant.ParticipantsRequester
 * @see com.vailsys.persephony.api.PersyClient
 */
public class Participant extends PersyCommon {
    /**
     * The callId for this participant instance.
     */
    private String callId;
    /**
     * The conferenceId of the conference this participant belongs to.
     */
    private String conferenceId;
    /**
     * The accountId for the account that created this participant.
     */
    private String accountId;
    /**
     * Whether this participant can speak in the conference.
     */
    private Boolean talk;
    /**
     * Whether this participant can listen in this conference.
     */
    private Boolean listen;
    /**
     * Whether the conference begins when this participant joins it.
     */
    private Boolean startConfOnEnter;

    /**
     * Converts the provided JSON string into a Participant object.
     *
     * @param json A JSON string representing a Persephony Participant instance.
     *
     * @return A Participant object equivalent to the JSON string passed in.
     * @throws PersyJSONException when the JSON is invalid.
     */
    public static Participant fromJson(String json) throws PersyJSONException {
        try {
            return gson.fromJson(json, Participant.class);
        } catch (JsonSyntaxException jse) {
            throw new PersyJSONException(jse);
        }
    }

    /**
     * Retrieve the callId for this participant from the object.
     *
     * @return The callId for this participant.
     */
    public String getCallId() {
        return callId;
    }

    /**
     * Retrieve the conferenceId for this participant from the object.
     *
     * @return The conferenceId for this participant.
     */
    public String getConferenceId() {
        return conferenceId;
    }

    /**
     * Retrieve the accountId for this participant from the object.
     *
     * @return The accountId for this participant.
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Retrieve the talk setting for this participant from the object.
     *
     * @return The talk setting for this participant.
     */
    public Boolean getTalk() {
        return talk;
    }

    /**
     * Retrieve the listen setting for this participant from the object.
     *
     * @return The listen setting for this participant.
     */
    public Boolean getListen() {
        return listen;
    }

    /**
     * Retrieve the startConfOnEnter setting for this participant from the object.
     *
     * @return The startConfOnEnter setting for this participant.
     */
    public Boolean getStartConfOnEnter() {
        return startConfOnEnter;
    }

    /**
     * Check if this participant equals another. This is done by comparing all fields in the participant for equality.
     *
     * @param that The Participant object for comparison
     *
     * @return {@code true} is participants are equal, {@code false} otherwise.
     */
    public boolean equals(Participant that){
        boolean result = super.equals(that);

        if(this.callId != null){
            result = result && this.callId.equals(that.callId);
        } else {
            result = result && that.callId == null;
        }

        if(this.conferenceId != null){
            result = result && this.conferenceId.equals(that.conferenceId);
        } else {
            result = result && that.conferenceId == null;
        }

        if(this.accountId != null){
            result = result && this.accountId.equals(that.accountId);
        } else {
            result = result && that.accountId == null;
        }

        if(this.talk != null){
            result = result && this.talk.equals(that.talk);
        } else {
            result = result && that.talk == null;
        }

        if(this.listen != null){
            result = result && this.listen.equals(that.listen);
        } else {
            result = result && that.listen == null;
        }

        if(this.startConfOnEnter != null){
            result = result && this.startConfOnEnter.equals(that.startConfOnEnter);
        } else {
            result = result && that.startConfOnEnter == null;
        }
        return result;
    }

}
