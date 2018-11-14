package com.vailsys.persephony.api.phoneNumber;

import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyList;

/**
 * Represents a paginated list of Persephony Available Phone Number instances. This object will
 * be automatically created by a
 * {@link AvailablePhoneNumberRequester} inside a
 * {@link com.vailsys.persephony.api.PersyClient} instance and its creation
 * should not be a concern of the SDK user.
 *
 * @see com.vailsys.persephony.api.PersyList
 */
public class AvailablePhoneNumberList extends PersyList<AvailablePhoneNumber> {

    /**
     * Creates a new AvailablePhoneNumberList.
     *
     * @param accountId the accountId to use in requests for subsequent pages.
     * @param authToken the authToken to use in requests for subsequent pages.
     * @param rawPage the raw JSON string representing a page of an available phone number list from the Persephony API.
     * @throws PersyException when the JSON is invalid.
     *
     */
    public AvailablePhoneNumberList(String accountId, String authToken, String rawPage) throws PersyException {
        super(accountId, authToken, rawPage, "availablePhoneNumbers", AvailablePhoneNumber.class);
    }

}
