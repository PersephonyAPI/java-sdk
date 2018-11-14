package com.vailsys.persephony.api.account;

import com.google.gson.annotations.SerializedName;

/**
 * This enum represents the predefined values for the {@code status} field inside a Persephony Account instance. It indicates
 * whether the account is active.
 */
public enum Status {
    /**
     * This value represents the state of the account where it can be used normally.
     */
    @SerializedName("active")
    ACTIVE,
    /**
     * This value represents the state of the account where it can't be used but can still be recovered.
     */
    @SerializedName("suspended")
    SUSPENDED,
    /**
     * This value represents the state of the account where it can no longer be used and cannot be recovered.
     */
    @SerializedName("closed")
    CLOSED
}
