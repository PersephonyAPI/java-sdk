package com.vailsys.persephony.webhooks.application;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyJSONException;
import com.vailsys.persephony.api.message.Direction;
import com.vailsys.persephony.webhooks.PersyRequest;
import com.vailsys.persephony.api.message.Status;

import static com.vailsys.persephony.json.PersyGson.gson;

/**
 * A MessageDelivery represents the JSON object that is sent to the smsUrl / smsFallbackUrl of Persephony Applications when an SMS message is sent to the platform.
 */
public class MessageDelivery extends PersyRequest {
    private String messageId;
    private String text;
    private Direction direction;
    private String applicationId;
    private Status status;
    private String phoneNumberId;

    public static MessageDelivery createFromJson(String jsonString) throws PersyJSONException {
        try {
            return gson.fromJson(jsonString, MessageDelivery.class);
        }
        catch (JsonIOException | JsonSyntaxException je) {
            throw new PersyJSONException(je);
        }
    }


    public String getMessageId() {
        return messageId;
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
