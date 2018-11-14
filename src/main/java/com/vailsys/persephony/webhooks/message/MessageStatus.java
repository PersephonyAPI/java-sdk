package com.vailsys.persephony.webhooks.message;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyJSONException;
import com.vailsys.persephony.api.message.Direction;
import com.vailsys.persephony.api.message.Status;
import com.vailsys.persephony.webhooks.PersyRequest;

import static com.vailsys.persephony.json.PersyGson.gson;

public class MessageStatus extends PersyRequest {
    private String messageId;
    private String callId;
    private String text;
    private Direction direction;
    private String applicationId;
    private Status status;
    private String phoneNumberId;

    public static MessageStatus createFromJson(String jsonString) throws PersyJSONException {
        try {
            return gson.fromJson(jsonString, MessageStatus.class);
        }
        catch (JsonIOException | JsonSyntaxException je) {
            throw new PersyJSONException(je);
        }
    }

    public String getMessageId() {
        return messageId;
    }

    public String getCallId() {
        return callId;
    }

    public String getText() {
        return text;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public Status getStatus() {
        return status;
    }

    public String getPhoneNumberId() {
        return phoneNumberId;
    }
}
