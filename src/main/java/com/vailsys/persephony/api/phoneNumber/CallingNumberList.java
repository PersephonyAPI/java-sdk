package com.vailsys.persephony.api.phoneNumber;

import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyList;

/**
 * Represents a paginated list of Persephony CallingNumber instances. This object will be automatically created by a {@link com.vailsys.persephony.api.phoneNumber.CallingNumberRequester} inside a {@link com.vailsys.persephony.api.PersyClient} instance and its creation should not be a concern of the SDK user.
 *
 * @see com.vailsys.persephony.api.PersyList
 */
public class CallingNumberList extends PersyList<CallingNumber> {

    /**
     * Creates a new CallingNumberList.
     *
     * @param accountId the accountId to use in requests for subsequent pages.
     * @param authToken the authToken to use in requests for subsequent pages.
     * @param rawPage the raw JSON string representing a page of a calling number list from the Persephony API.
     * @throws PersyException when the request fails or the JSON is invalid.
     */
    public CallingNumberList(String accountId, String authToken, String rawPage) throws PersyException {
        super(accountId, authToken, rawPage, "callingNumbers", CallingNumber.class);
    }
}
