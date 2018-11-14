package com.vailsys.persephony.api.account;

import com.google.gson.annotations.SerializedName;

/**
 * This enum represents the predefined values for the {@code type} field inside a Persephony Account instance. It indicates whether an account is in a trial state or a full account.
 */
public enum Type {
    /**
     * This value represents the state of the account where it is in a trial mode.
     */
    @SerializedName("trial")
    TRIAL,
    /**
     * This value represents the state of the account where it is a full account.
     */
    @SerializedName("full")
    FULL
}
