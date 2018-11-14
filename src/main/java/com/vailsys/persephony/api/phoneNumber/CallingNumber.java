package com.vailsys.persephony.api.phoneNumber;

import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyJSONException;

import static com.vailsys.persephony.json.PersyGson.gson;

/**
 * This class represents a Persephony CallingNumber instance. CallingNumber objects are created by the SDK whenever a CallingNumber instance would be returned by the API; these primarily come from a {@link com.vailsys.persephony.api.phoneNumber.CallingNumberRequester}
 * inside a {@link com.vailsys.persephony.api.PersyClient} instance.<br>
 * <br>
 * CallingNumbers are immutable and intended only to be used to read information returned from the API in a language accessible way.
 *
 * @see com.vailsys.persephony.api.phoneNumber.CallingNumberRequester
 * @see com.vailsys.persephony.api.PersyClient
 */
public class CallingNumber extends PhoneNumber {
    /**
     * The callingNumberId for this calling number instance.
     */
    private String callingNumberId;
    /**
     * The accountId of the account that created this calling number.
     */
    private String accountId;

    /**
     * Converts the provided JSON string into a CallingNumber object.
     *
     * @param json A JSON string representing a Persephony CallingNumber instance.
     * @return A CallingNumber object equivalent to the JSON string passed in.
     * @throws PersyException when the request fails or the JSON is invalid.
     */
    public static CallingNumber fromJson(String json) throws PersyException {
        try {
            return gson.fromJson(json, CallingNumber.class);
        } catch(JsonSyntaxException jse){
            throw new PersyJSONException(jse);
        }
    }

    /**
     * Retrieve the callingNumberId for this calling number from the object.
     *
     * @return The callingNumberId for this calling number.
     */
    public String getCallingNumberId() {
        return callingNumberId;
    }

    /**
     * Retrieve the accountId for this calling number from the object.
     *
     * @return The accountId for this calling number.
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Check if this calling number equals another. This is done by comparing all fields in the calling number for equality.
     *
     * @param that The calling number object for comparison.
     * @return {@code true} if calling numbers are equal, {@code false} otherwise.
     */
    public boolean equals(CallingNumber that){
        boolean result = super.equals(that);

        if(this.getCallingNumberId() != null){
            result = result && that.getCallingNumberId().equals(this.getCallingNumberId());
        } else {
            result = result && that.getCallingNumberId() == null;
        }

        if(this.getAccountId() != null){
            result = result && that.getAccountId().equals(this.getAccountId());
        } else {
            result = result && that.getAccountId() == null;
        }

        return result;
    }
}
