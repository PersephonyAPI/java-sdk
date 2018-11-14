package com.vailsys.persephony.api.application;

import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyList;

/**
 * Represents a paginated list of Persephony Application instances. This object will be automatically created by a
 * {@link com.vailsys.persephony.api.application.ApplicationsRequester} inside a
 * {@link com.vailsys.persephony.api.PersyClient} instance and its creation
 * should not be a concern of the SDK user.
 */
public class ApplicationList extends PersyList<Application> {
    /**
     * Creates a new ApplicationList.
     *
     * @param accountId the accountId to use in requests for subsequent pages.
     * @param authToken the authToken to use in requests for subsequent pages.
     * @param rawPage the raw JSON string representing a page of an application list from the Persephony API
     * @throws PersyException when the JSON is invalid.
     */
    public ApplicationList(String accountId, String authToken, String rawPage) throws PersyException {
        super(accountId, authToken, rawPage, "applications", Application.class);
    }
}
