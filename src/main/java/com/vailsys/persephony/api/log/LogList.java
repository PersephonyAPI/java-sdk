package com.vailsys.persephony.api.log;

import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyList;

/**
 * Represents a paginated list of Persephony Log instances. This object will be automatically created by a {@link com.vailsys.persephony.api.log.LogRequester} inside a {@link com.vailsys.persephony.api.PersyClient} instance and its creation should not be a concern of the SDK user.
 *
 * @see com.vailsys.persephony.api.PersyList
 */
public class LogList extends PersyList<Log> {

    /**
     * Creates a new LogList.
     *
     * @param credAccountId the accountId to use in requests for subsequent pages.
     * @param credAuthToken the authToken to use in requests for subsequent pages.
     * @param rawPage the raw JSON string representing a page of a log list from the Persephony API.
     * @throws PersyException when the JSON is invalid.
     */
    public LogList(String credAccountId, String credAuthToken, String rawPage) throws PersyException {
        super(credAccountId, credAuthToken, rawPage, "logs", Log.class);
    }
}
