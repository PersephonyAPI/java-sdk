package com.vailsys.persephony.webhooks.percl;

import com.google.gson.annotations.SerializedName;

public enum SpeechReason {

    @SerializedName("error")
    ERROR,
    @SerializedName("hangup")
    HANGUP,
    @SerializedName("digit")
    DIGIT,
    @SerializedName("noInput")
    NO_INPUT,
    @SerializedName("noMatch")
    NO_MATCH,
    @SerializedName("recognition")
    RECOGNITION
}
