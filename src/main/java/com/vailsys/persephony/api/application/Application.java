package com.vailsys.persephony.api.application;

import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyCommon;
import com.vailsys.persephony.api.PersyJSONException;

import static com.vailsys.persephony.json.PersyGson.gson;

/**
 * This class represents a Persephony Application instance. Applications objects are created by the SDK whenever an application instance would be returned by the API; these primarily come from a {@link com.vailsys.persephony.api.application.ApplicationsRequester} inside a {@link com.vailsys.persephony.api.PersyClient} instance. <br>
 * <br>
 * Applications are immutable and intended only to be used to read information returned from the API in a language accessible way.
 */
public class Application extends PersyCommon {
    /**
     * The applicationId for this application instance.
     */
    private String applicationId;
    /**
     * The accountId for the account that created this application.
     */
    private String accountId;
    /**
     * The alias for this application.
     */
    private String alias;
    /**
     * The url Persephony will request when a phone number assigned to this application receives a call. Used for inbound calls only.
     */
    private String voiceUrl;
    /**
     * The URL that Persephony will request if an error occurs retrieving or executing the PerCL requested by voiceUrl. Used for inbound calls only.
     */
    private String voiceFallbackUrl;
    /**
     * The url that Persephony will request informing the result of the outbound request.
     * The status property of the request message specifies if the call was connected or not.
     * This is only used if an applicationId is specified when making an outbound call.
     */
    private String callConnectUrl;
    /**
     * The url that Persephony will request when the call ends.
     */
    private String statusCallbackUrl;
    /**
     * The url Persephony will request when a phone number assigned to this application receives an incoming SMS message. Used for inbound SMS only.
     */
    private String smsUrl;
    /**
     * The URL that Persephony will request if an error occurs when making a request to the smsUrl. Used for inbound SMS only.
     */
    private String smsFallbackUrl;

    /**
     * Converts the provided JSON string into an Application object.
     *
     * @param json A JSON string representing a Persephony Application instance.
     * @return An Application object equivalent to the JSON string passed in.
     * @throws PersyJSONException when the JSON is invalid.
     */
    public static Application fromJson(String json) throws PersyJSONException {
        try {
            return gson.fromJson(json, Application.class);
        } catch (JsonSyntaxException jse) {
            throw new PersyJSONException(jse);
        }
    }

    /**
     * Retrieve the applicationId for this application from the object.
     *
     * @return The applicationId for this application.
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * Retrieve the accountId for this application from the object.
     *
     * @return The accountId for this application.
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Retrieve the alias for this application from the object.
     *
     * @return The alias for this application.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Retrieve the voiceUrl for this application from the object.
     *
     * @return The voiceUrl for this application.
     */
    public String getVoiceUrl() {
        return voiceUrl;
    }

    /**
     * Retrieve the voiceFallbackUrl for this application from the object.
     *
     * @return The voiceFallbackUrl for this application.
     */
    public String getVoiceFallbackUrl() {
        return voiceFallbackUrl;
    }

    /**
     * Retrieve the callConnectUrl for this application from the object.
     *
     * @return The callConnectUrl for this application.
     */
    public String getCallConnectUrl() {
        return callConnectUrl;
    }

    /**
     * Retrieve the statusCallbackUrl for this application from the object.
     *
     * @return The statusCallbackUrl for this application.
     */
    public String getStatusCallbackUrl() {
        return statusCallbackUrl;
    }

    /**
     * Retrieve the smsUrl for this application from the object.
     *
     * @return The smsUrl for this application.
     */
    public String getSmsUrl() {
        return smsUrl;
    }

    /**
     * Retrieve the smsFallbackUrl for this application from the object.
     *
     * @return The smsFallbackUrl for this application.
     */
    public String getSmsFallbackUrl() {
        return smsFallbackUrl;
    }

    /**
     * Check if this application equals another. This is done by comparing all the fields in the application for equality.
     *
     * @param that The Application object for comparison.
     * @return {@code true} if applications are equal, {@code false} otherwise.
     */
    public boolean equals(Application that) {
        boolean result = super.equals(that);

        if (this.applicationId != null) {
            result = result && that.applicationId.equals(this.applicationId);
        } else {
            result = result && that.applicationId == null;
        }

        if (this.accountId != null) {
            result = result && that.accountId.equals(this.accountId);
        } else {
            result = result && that.accountId == null;
        }

        if (this.alias != null) {
            result = result && that.alias.equals(this.alias);
        } else {
            result = result && that.alias == null;
        }

        if (this.voiceUrl != null) {
            result = result && that.voiceUrl.equals(this.voiceUrl);
        } else {
            result = result && that.voiceUrl == null;
        }

        if (this.voiceFallbackUrl != null) {
            result = result && that.voiceFallbackUrl.equals(this.voiceFallbackUrl);
        } else {
            result = result && that.voiceFallbackUrl == null;
        }

        if (this.callConnectUrl != null) {
            result = result && that.callConnectUrl.equals(this.callConnectUrl);
        } else {
            result = result && that.callConnectUrl == null;
        }

        if (this.statusCallbackUrl != null) {
            result = result && that.statusCallbackUrl.equals(this.statusCallbackUrl);
        } else {
            result = result && that.statusCallbackUrl == null;
        }

        if (this.smsUrl != null) {
            result = result && that.smsUrl.equals(this.smsUrl);
        } else {
            result = result && that.smsUrl == null;
        }

        if (this.smsFallbackUrl != null) {
            result = result && that.smsFallbackUrl.equals(this.smsFallbackUrl);
        } else {
            result = result && that.smsFallbackUrl == null;
        }

        return result;
    }
}
