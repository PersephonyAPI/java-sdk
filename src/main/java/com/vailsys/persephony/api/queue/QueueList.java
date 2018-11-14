package com.vailsys.persephony.api.queue;

import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyList;

/**
 * Represents a paginated list of Persephony Queue instances. This object will be automatically created by a
 * {@link com.vailsys.persephony.api.queue.QueuesRequester} inside a
 * {@link com.vailsys.persephony.api.PersyClient} instance and its creation should not be a concern of the SDK user.
 */
public class QueueList extends PersyList<Queue> {
    /**
     * Creates a new QueuesList.
     *
     * @param accountId The accountId to use in requests for subsequent pages.
     * @param authToken The authToken to use in requests for subsequent pages.
     * @param rawPage The raw JSON string representing a page of a conferences list from the Persephony API.
     * @throws PersyException if the provided page is not valid JSON.
     */
    public QueueList(String accountId, String authToken, String rawPage) throws PersyException {
        super(accountId, authToken, rawPage, "queues", Queue.class);
    }
}
