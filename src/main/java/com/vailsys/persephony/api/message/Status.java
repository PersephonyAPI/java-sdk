package com.vailsys.persephony.api.message;

import com.google.gson.annotations.SerializedName;

/**
 * This enum represents the different possible predefined values of the {@code status} field inside a Persephony MessageDelivery callback. It indicates the status of the message.
 */
public enum Status {
    @SerializedName("sent")
    SENT,
    @SerializedName("failed")
    FAILED,
    @SerializedName("queued")
    QUEUED,
    @SerializedName("rejected")
    REJECTED,
    @SerializedName("received")
    RECEIVED,
    @SerializedName("sending")
    SENDING
}
