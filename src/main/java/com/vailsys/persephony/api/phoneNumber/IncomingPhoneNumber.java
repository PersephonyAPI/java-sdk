package com.vailsys.persephony.api.phoneNumber;

import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyJSONException;

import static com.vailsys.persephony.json.PersyGson.gson;

/**
 * This class represents a Persephony IncomingPhoneNumber instance. IncomingPhoneNumber objects are created by the SDK whenever an incoming phone number instance would be returned by the API; these primarily come from a {@link com.vailsys.persephony.api.phoneNumber.IncomingPhoneNumberRequester} inside a {@link com.vailsys.persephony.api.PersyClient} instance.<br>
 * <br>
 * IncomingPhoneNumbers are immutable
 */
public class IncomingPhoneNumber extends PhoneNumber {
    /**
     * The phoneNumberId for this incoming phone number instance.
     */
    private String phoneNumberId;
    /**
     * The accountId of the account that owns this incoming phone number.
     */
    private String accountId;
    /**
     * The applicationId this incoming phone number is assigned to, if any.
     */
    private String applicationId;
    /**
     * The region of this incoming phone number.
     */
    private String region;
    /**
     * The country of this incoming phone number.
     */
    private String country;
    /**
     * Whether or not voice is enabled for this incoming phone number.
     */
    private boolean voiceEnabled;
    /**
     * Whether or not sms is enabled for this incoming phone number.
     */
    private boolean smsEnabled;

    /**
     * Converts the provided JSON string into an Incoming Phone Number object.
     *
     * @param json A JSON string representing a Persephony IncomingPhoneNumber instance.
     * @return An IncomingPhoneNumber object equivalent to the JSON string passed in.
     * @throws PersyJSONException when the JSON is invalid.
     */
    public static IncomingPhoneNumber fromJson(String json) throws PersyJSONException{
        try {
            return gson.fromJson(json, IncomingPhoneNumber.class);
        } catch(JsonSyntaxException jse){
            throw new PersyJSONException(jse);
        }
    }

    /**
     * Retrieve the phoneNumberId for this incoming phone number from the object.
     *
     * @return The phoneNumberId for this incoming phone number
     */
    public String getPhoneNumberId() {
        return phoneNumberId;
    }

    /**
     * Retrieve the accountId for this incoming phone number from the object.
     *
     * @return The accountId for this incoming phone number.
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Retrieve the applicationId for this incoming phone number from the object.
     *
     * @return The applicationId for this incoming phone number.
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * Retrieve the region for this incoming phone number from the object.
     *
     * @return The region for this incoming phone number.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Retrieve the country for this incoming phone number from the object.
     *
     * @return The country for this incoming phone number.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Retrieve the voiceEnabled setting for this incoming phone number from the object.
     *
     * @return Whether or not voice is enabled for this incoming phone number.
     */
    public boolean isVoiceEnabled() {
        return voiceEnabled;
    }

     /**
     * Retrieve the smsEnabled setting for this incoming phone number from the object.
     *
     * @return Whether or not sms is enabled for this incoming phone number.
     */
    public boolean isSmsEnabled() {
        return smsEnabled;
    }

    /**
     * Check if this incoming phone number equals another. This is done by comparing all fields in the incoming phone numbers for equality.
     *
     * @param that The IncomingPhoneNumber object for comparison.
     * @return {@code true} if incoming phone numbers are equal, {@code false} otherwise.
     */
    public boolean equals(IncomingPhoneNumber that){
        boolean result = super.equals(that);

        if(this.getPhoneNumberId() != null){
            result = result && that.getPhoneNumberId().equals(this.getPhoneNumberId());
        } else {
            result = result && that.getPhoneNumberId() == null;
        }

        if(this.getAccountId() != null){
            result = result && that.getAccountId().equals(this.getAccountId());
        } else {
            result = result && that.getAccountId() == null;
        }

        if(this.getApplicationId() != null){
            result = result && that.getApplicationId().equals(this.getApplicationId());
        } else {
            result = result&& that.getApplicationId() == null;
        }

        if(this.getRegion() != null){
            result = result && that.getRegion().equals(this.getRegion());
        } else {
            result = result && that.getRegion() == null;
        }

        if(this.getCountry() != null){
            result = result && that.getCountry().equals(this.getCountry());
        } else {
            result = result && that.getCountry() == null;
        }

        result = result && (that.isVoiceEnabled() == this.isVoiceEnabled());
        result = result && (that.isSmsEnabled() == this.isSmsEnabled());

        return result;
    }
}
