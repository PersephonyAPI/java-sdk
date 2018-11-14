package com.vailsys.persephony.api.message;

import com.google.gson.annotations.SerializedName;

/**
 * This enum represents the possible predefined values of the {@code direction} field inside a Persephony Message instance. It indicates whether the message was an inbound or outbound message.
 */
public enum Direction {
    /**
     * This value represents an inbound message that was sent into your application.
     */
    @SerializedName("inbound")
    INBOUND,
    /**
     * This value represents an outbound message that was sent with your account through either an API request or the {@code Sms} command.
     */
    @SerializedName("outbound")
    OUTBOUND
}
