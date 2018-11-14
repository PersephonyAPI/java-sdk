package com.vailsys.persephony.api.call;

import com.vailsys.persephony.api.PersyCommon;
import com.vailsys.persephony.api.PersyList;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyJSONException;

/**
 * Represents a paginated list of Persephony Call instances. This object will
 * be automatically created by a 
 * {@link com.vailsys.persephony.api.call.CallsRequester} inside a 
 * {@link com.vailsys.persephony.api.PersyClient} instance and its creation
 * should not be a concern of the SDK user.
 *
 * @see com.vailsys.persephony.api.PersyList
 */
public class CallList extends PersyList<Call> {

	/**
	 * Creates a new CallList.
	 * 
	 * @param accountId the accountId to use in requests for subsequent pages.
	 * @param authToken the authToken to use in requests for subsequent pages.
	 * @param rawPage the raw JSON string representing a page of a call list from the Persephony API.
	 * @throws PersyException when the JSON is invalid.
	 */
	public CallList(String accountId, String authToken, String rawPage) throws PersyException {
		super(accountId, authToken, rawPage, "calls", Call.class);
	}
}
