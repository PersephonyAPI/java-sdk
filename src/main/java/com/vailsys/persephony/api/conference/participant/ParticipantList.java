package com.vailsys.persephony.api.conference.participant;

import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyList;

/**
 * Represents a paginated list of Persephony Participant instances. This object will
 * be automatically created by a
 * {@link com.vailsys.persephony.api.conference.participant.ParticipantsRequester} inside a
 * {@link com.vailsys.persephony.api.PersyClient} instance and its creation
 * should not be a concern of the SDK user.
 *
 * @see com.vailsys.persephony.api.PersyList
 */
public class ParticipantList extends PersyList<Participant> {

    /**
     * Creates a new ParticipantList.
     *
     * @param accountId the accountId to use in requests for subsequent pages.
     * @param authToken the authToken to use in requests for subsequent pages.
     * @param rawPage the raw JSON string representing a page of a participant list from the Persephony API.
     * @throws PersyException when the JSON is invalid.
     */
    public ParticipantList(String accountId, String authToken, String rawPage) throws PersyException {
        super(accountId, authToken, rawPage, "participants", Participant.class);
    }
}
