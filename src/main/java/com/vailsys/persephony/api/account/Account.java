package com.vailsys.persephony.api.account;

import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyCommon;
import com.vailsys.persephony.api.PersyJSONException;

import java.util.HashMap;

import static com.vailsys.persephony.json.PersyGson.gson;

/**
 * This class represents a Persephony Account instance. Account instances are created by the SDK whenever an account would be returned by the API; these primarily from from a {@link com.vailsys.persephony.api.account.AccountRequester} inside a {@link com.vailsys.persephony.api.PersyClient} instance.<br>
 * <br>
 * Accounts are immutable and intended only to be used to read information returned from the API in a language accessible way.
 *
 * @see com.vailsys.persephony.api.account.AccountRequester
 * @see com.vailsys.persephony.api.PersyClient
 */
public class Account extends PersyCommon {
    /**
     * The accountId for this account instance.
     */
    private String accountId;
    /**
     * The authToken for this account instance.
     */
    private String authToken;
    /**
     * The alias for this account.
     */
    private String alias;
    /**
     * The label for this account.
     */
    private String label;
    /**
     * This represents the type of this account.
     * @see com.vailsys.persephony.api.account.Type
     */
    private Type type;
    /**
     * This represents the status of this account.
     * @see com.vailsys.persephony.api.account.Status
     */
    private Status status;
    /**
     * The list of subresources for this account.
     */
    private HashMap<String, String> subresourceUris;

    /**
     * Converts the provided JSON string into an Account object.
     *
     * @param json A JSON string representing a Persephony Account instance.
     *
     * @return An Account object equivalent to the JSON string passed in.
     * @throws PersyJSONException when the JSON is invalid.
     */
    public static Account fromJson(String json) throws PersyJSONException {
        try {
            return gson.fromJson(json, Account.class);
        } catch (JsonSyntaxException jse){
            throw new PersyJSONException(jse);
        }
    }

    /**
     * Retrieve the accountId for this account from the object.
     *
     * @return The accountId for this account.
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Retrieve the authToken for this account from the object.
     *
     * @return The authToken for this account.
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     * Retrieve the alias for this account from the object.
     *
     * @return The alias for this account.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Retrieve the label for this account from the object.
     *
     * @return The label for this account.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Retrieve the type for this account from the object.
     *
     * @return The type for this account.
     */
    public Type getType() {
        return type;
    }

    /**
     * Retrieve the status for this account from the object.
     *
     * @return The status for this account.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Retrieve the subresourceUris for this account from the object.
     *
     * @return The subresourceUris for this account.
     */
    public HashMap<String, String> getSubresourceUris() {
        return subresourceUris;
    }

    /**
     * Check if this account equals another. This is done by comparing all fields in the account for equality.
     *
     * @param that The Account object for comparison.
     * @return {@code true} if accounts are equal, {@code false} otherwise.
     */
    public boolean equals(Account that){
        boolean result = super.equals(that);

        if(this.getAccountId() != null){
            result = result && that.getAccountId().equals(this.getAccountId());
        } else {
            result = result && that.getAccountId() == null;
        }

        if(this.getAuthToken() != null){
            result = result && that.getAuthToken().equals(this.getAuthToken());
        } else {
            result = result && that.getAuthToken() == null;
        }

        if(this.getAlias() != null){
            result = result && that.getAlias().equals(this.getAlias());
        } else {
            result = result && that.getAlias() == null;
        }

        if(this.getLabel() != null){
            result = result && that.getLabel().equals(this.getLabel());
        } else {
            result = result && that.getLabel() == null;
        }

        if(this.getType() != null){
            result = result && that.getType().equals(this.getType());
        } else {
            result = result && that.getType() == null;
        }

        if(this.getStatus() != null){
            result = result && that.getStatus().equals(this.getStatus());
        } else {
            result = result && that.getStatus() == null;
        }

        if(this.getSubresourceUris() != null){
            result = result && that.getSubresourceUris().equals(this.getSubresourceUris());
        } else {
            result = result && that.getSubresourceUris() == null;
        }

        return  result;
    }
}
