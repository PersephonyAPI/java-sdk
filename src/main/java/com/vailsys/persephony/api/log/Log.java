package com.vailsys.persephony.api.log;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyCommon;
import com.vailsys.persephony.api.PersyJSONException;

import static com.vailsys.persephony.json.PersyGson.gson;

/**
 * This class represents a Persephony Log instance. Log objects are created by the SDK whenever a log instance would be returned by the API; these primarily come from a {@link com.vailsys.persephony.api.log.LogRequester} inside a {@link com.vailsys.persephony.api.PersyClient} instance.<br>
 * <br>
 * Logs are immutable and intended only to be used to read information returned from the API in a language accessible way.
 *
 * @see com.vailsys.persephony.api.log.LogRequester
 * @see com.vailsys.persephony.api.PersyClient
 */
public class Log extends PersyCommon {
    /**
     * The timestamp of this log.
     */
    private Long timestamp;
    /**
     * The level of this log.
     * @see com.vailsys.persephony.api.log.Level
     */
    private Level level;
    /**
     * The requestId of this log.
     */
    private String requestId;
    /**
     * The accountId of this log.
     */
    private String accountId;
    /**
     * The accountId of this log.
     */
    private String callId;
    /**
     * The message of this log.
     */
    private String message;
    /**
     * The metadata of this log.
     */
    private JsonObject metadata;

    /**
     * Converts the provided JSON string into a Log object.
     *
     * @param json A JSON string representing a Persephony Log instance.
     *
     * @return A Log object equivalent to the JSON string passed in.
     * @throws PersyJSONException on a syntax error.
     */
    public static Log fromJson(String json) throws PersyJSONException {
        try {
            return gson.fromJson(json, Log.class);
        } catch (JsonSyntaxException jse){
            throw new PersyJSONException(jse);
        }
    }

    /**
     * Retrieve the timestamp for this log from the object.
     *
     * @return The timestamp for this log.
     */
    public Long getTimestamp() {
        return timestamp;
    }

    /**
     * Retrieve the level for this log from the object.
     *
     * @return The level for this log.
     * @see com.vailsys.persephony.api.log.Level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Retrieve the requestId for this log from the object.
     *
     * @return The requestId for this log.
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Retrieve the accountId for this log from the object.
     *
     * @return The accountId for this log.
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Retrieve the callId for this log from the object.
     *
     * @return The callId for this log.
     */
    public String getCallId() {
        return callId;
    }

    /**
     * Retrieve the message for this log from the object.
     *
     * @return The mssage for this log.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Retrieve the metadata for this log from the object.
     *
     * @return The metadata for this log.
     */
    public JsonObject getMetadata() {
        return metadata;
    }

    /**
     * Check if this log equals another. This is done by comparing all fields in the log for equality.
     *
     * @param that The Log object for comparison.
     * @return {@code true} if logs are equal, {@code false} otherwise.
     */
    public boolean equals(Log that){
        boolean result = super.equals(that);

        if(this.getTimestamp() != null){
            result = result && that.getTimestamp().equals(this.getTimestamp());
        } else {
            result = result && that.getTimestamp() == null;
        }

        if(this.getLevel() != null){
            result = result && that.getLevel().equals(this.getLevel());
        } else {
            result = result && that.getLevel() == null;
        }

        if(this.getRequestId() != null){
            result = result && that.getRequestId().equals(this.getRequestId());
        } else {
            result = result && that.getRequestId() == null;
        }

        if(this.getAccountId() != null){
            result = result && that.getAccountId().equals(this.getAccountId());
        } else {
            result = result && that.getAccountId() == null;
        }

        if(this.getCallId() != null){
            result = result && that.getCallId().equals(this.getCallId());
        } else {
            result = result && that.getCallId() == null;
        }

        if(this.getMessage() != null){
            result = result && that.getMessage().equals(this.getMessage());
        } else {
            result = result && that.getMessage() == null;
        }

        if(this.getMetadata() != null){
            result = result && that.getMetadata().equals(this.getMetadata());
        } else {
            result = result && that.getMetadata() == null;
        }

        return result;

    }
}
