package com.vailsys.persephony.api.queue.member;

import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyCommon;
import com.vailsys.persephony.api.PersyJSONException;

import java.util.Date;

import static com.vailsys.persephony.json.PersyGson.gson;

/**
 * This class represents a Persephony Member instance. Member objects are created
 * by the SDK whenever a member instance would be returned by the API; these
 * primarily come from {@link com.vailsys.persephony.api.queue.member.MembersRequester}
 * inside a {@link com.vailsys.persephony.api.PersyClient} instance.<br>
 * <br>
 * Members are immutable and intended only to be used to read information
 * returned from the API in a language accessible way.
 *
 * @see com.vailsys.persephony.api.queue.member.MembersRequester
 * @see com.vailsys.persephony.api.PersyClient
 */
public class Member {
    /**
     * The uri for this member instance.
     */
    private String uri;
    /**
     * The callId of this member instance.
     */
    private String callId;
    /**
     * The number of seconds the member has been in the queue.
     */
    private Integer waitTime;
    /**
     * The member's current position in the queue.
     */
    private Integer position;
    /**
     * The date that the member was enqueued.
     */
    private Date dateEnqueued;

    /**
     * Converts the provided JSON string into a Member object.
     *
     * @param json A JSON string representing a Persephony Member instance.
     *
     * @return A Member object equivalent to the JSON string passed in.
     * @throws PersyJSONException when the JSON is not valid.
     */
    public static Member fromJson(String json) throws PersyJSONException {
        try{
            return gson.fromJson(json, Member.class);
        } catch (JsonSyntaxException jse){
            throw new PersyJSONException(jse);
        }
    }

    /**
     * Retrieve the uri for this member from the object.
     *
     * @return The uri for this member.
     */
    public String getUri() {
        return uri;
    }

    /**
     * Retrieve the callId for this member from the object.
     *
     * @return The callId for this member.
     */
    public String getCallId() {
        return callId;
    }

    /**
     * Retrieve the waitTime for this member from the object.
     *
     * @return The waitTime for this member.
     */
    public Integer getWaitTime() {
        return waitTime;
    }

    /**
     * Retrieve the position for this member from the object.
     *
     * @return The position for this member.
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * Retrieve the dateEnqueue for this member from the object.
     *
     * @return The dateEnqueued for this member.
     */
    public Date getDateEnqueued() {
        return dateEnqueued;
    }

    /**
     * Check if this member equals another. This is done by comparing all fields in the member for equality.
     *
     * @param that The Member object for comparison.
     *
     * @return {@code true} if members are equal, {@code false} otherwise.
     */
    public boolean equals(Member that){
        boolean result = true;

        if(this.uri != null ){
            result = result && that.uri.equals(this.uri);
        } else {
            result = result && that.uri == null;
        }

        if(this.callId != null ){
            result = result && that.callId.equals(this.callId);
        } else {
            result = result && that.callId == null;
        }

        if(this.waitTime != null ){
            result = result && that.waitTime.equals(this.waitTime);
        } else {
            result = result && that.waitTime == null;
        }

        if(this.position != null ){
            result = result && that.position.equals(this.position);
        } else {
            result = result && that.position == null;
        }

        if(this.dateEnqueued != null ){
            result = result && that.dateEnqueued.equals(this.dateEnqueued);
        } else {
            result = result && that.dateEnqueued == null;
        }

        return result;
    }
}
