package com.vailsys.persephony.api.recording;

import com.vailsys.persephony.api.PersyCommon;
import com.vailsys.persephony.api.PersyList;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyJSONException;

/**
 * Represents a paginated list of Persephony Recording instances. This object will
 * be automatically created by a 
 * {@link com.vailsys.persephony.api.recording.RecordingsRequester} inside a 
 * {@link com.vailsys.persephony.api.PersyClient} instance and it's creation
 * should not be a concern of the SDK user.
 *
 * @see com.vailsys.persephony.api.PersyList
 */
public class RecordingList extends PersyList<Recording> {

	/**
	 * Creates a new RecordingList.
	 * 
	 * @param accountId the accountId to use in requests for subsequent pages.
	 * @param authToken the authToken to use in requests for subsequent pages.
	 * @param rawPage the raw JSON string representing a page of a recordings list from the Persephony API.
	 * @throws PersyException when the page is not valid JSON.
	 */
	public RecordingList(String accountId, String authToken, String rawPage) throws PersyException {
		super(accountId, authToken, rawPage, "recordings", Recording.class);
	}
}
