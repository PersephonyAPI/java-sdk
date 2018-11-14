package com.vailsys.persephony.api.message;

import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyList;

/**
 * Represents a paginated list of Persephony Message instances. This object will be automatically created by a {@link com.vailsys.persephony.api.message.MessagesRequester} inside a {@link com.vailsys.persephony.api.PersyClient} instance and its creation should not be a concern of the SDK user.
 */
public class MessageList extends PersyList<Message> {
    /**
     * Creates a new MessageList.
     *
     * @param accountId the accountId to use in requests for subsequent pages.
     * @param authToken the authToken to use in requests to subsequent pages.
     * @param rawPage   the raw JSON string representing a page of a message list from the Persephony API
     * @throws PersyException When the page is invalid JSON.
     */
    public MessageList(String accountId, String authToken, String rawPage) throws PersyException {
        super(accountId, authToken, rawPage, "messages", Message.class);
    }
}
