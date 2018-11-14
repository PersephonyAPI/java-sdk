package com.vailsys.persephony.webhooks;

import com.google.gson.annotations.SerializedName;

/**
 * This enum represents the different possible predefined values of the {@code requestType} field inside a Persephony callback. It identifies the format of each callback uniquely.
 */
public enum RequestType {
    @SerializedName("inboundCall")
    INBOUNDCALL,
    @SerializedName("record")
    RECORD,
    @SerializedName("getDigits")
    GET_DIGITS,
    @SerializedName("getSpeech")
    GET_SPEECH,
    @SerializedName("redirect")
    REDIRECT,
    @SerializedName("outDialStart")
    OUT_DIAL_START,
    @SerializedName("outDialConnect")
    OUT_DIAL_CONNECT,
    @SerializedName("outDialApiConnect")
    OUT_DIAL_API_CONNECT,
    @SerializedName("machineDetected")
    MACHINE_DETECTED,
    @SerializedName("dequeue")
    DEQUEUE,
    @SerializedName("queueWait")
    QUEUE_WAIT,
    @SerializedName("addToQueueNotification")
    ADD_TO_QUEUE_NOTIFICATION,
    @SerializedName("removeFromQueueNotification")
    REMOVE_FROM_QUEUE_NOTIFICATION,
    @SerializedName("callStatus")
    CALL_STATUS,
    @SerializedName("createConference")
    CREATE_CONFERENCE,
    @SerializedName("conferenceStatus")
    CONFERENCE_STATUS,
    @SerializedName("leaveConference")
    LEAVE_CONFERENCE,
    @SerializedName("addToConferenceNotification")
    ADD_TO_CONFERENCE_NOTIFICATION,
    @SerializedName("conferenceRecordingStatus")
    CONFERENCE_RECORDING_STATUS,
    @SerializedName("conferenceCallControl")
    CONFERENCE_CALL_CONTROL,
    @SerializedName("messageDelivery")
    MESSAGE_DELIVERY,
    @SerializedName("messageStatus")
    MESSAGE_STATUS

}
