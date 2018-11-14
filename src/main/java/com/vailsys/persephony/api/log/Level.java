package com.vailsys.persephony.api.log;

import com.google.gson.annotations.SerializedName;

/**
 * This enum represents the predefined values for the {@code level} field inside a Persephony Log instance. It indicates the severity or importance of the log.
 */
public enum Level {
    /**
     * This value represents a log that is informative in nature and doesn't indicate a problem.
     */
    @SerializedName("info")
    INFO,
    /**
     * This value represents a log that is a warning that may require attention but isn't necessarily a problem.
     */
    @SerializedName("warning")
    WARNING,
    /**
     * This value represents a log that is an error indicating something has gone wrong.
     */
    @SerializedName("error")
    ERROR
}
