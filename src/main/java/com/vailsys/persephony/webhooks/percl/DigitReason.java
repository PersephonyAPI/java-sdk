package com.vailsys.persephony.webhooks.percl;

import com.google.gson.annotations.SerializedName;

public enum DigitReason {

    @SerializedName("finishKey")
    FINISH_KEY,
    @SerializedName("timeout")
    TIMEOUT,
    @SerializedName("hangup")
    HANGUP,
    @SerializedName("minDigits")
    MIN_DIGITS,
    @SerializedName("maxDigits")
    MAX_DIGITS
}
