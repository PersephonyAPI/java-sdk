package com.vailsys.persephony.api.conference;

import static com.vailsys.persephony.json.PersyGson.gson;

import java.util.HashMap;

import com.vailsys.persephony.api.PersyCommon;
import com.vailsys.persephony.api.PersyJSONException;

import com.google.gson.JsonSyntaxException;

/**
 * This class represents a Persephony Conference instance. Conference objects are created
 * by the SDK whenever a conference instance would be returned by the API; these
 * primarily come from a {@link com.vailsys.persephony.api.conference.ConferencesRequester}
 * inside a {@link com.vailsys.persephony.api.PersyClient} instance.<br>
 * <br>
 * Conferences are immutable and intended only to be used to read information
 * returned from the API in a language accessible way.
 *
 * @see com.vailsys.persephony.api.conference.ConferencesRequester
 * @see com.vailsys.persephony.api.PersyClient
 */
public class Conference extends PersyCommon {
	/**
	 * The conferenceId for this conference instance.
	 */
	private String conferenceId;
	/**
	 * The accountId of the account that created this conference.
	 */
	private String accountId;
	/**
	 * The alias for this conference.
	 */
	private String alias;
	/**
	 * This represents the current playBeep of this conference.
	 * @see com.vailsys.persephony.api.conference.PlayBeep
	 */
	private PlayBeep playBeep;
	/**
	 * Whether this conference is being recorded.
	 */
	private Boolean record;
	/**
	 * This represents the current status or state of this conference.
	 * @see com.vailsys.persephony.api.conference.ConferenceStatus
	 */
	private ConferenceStatus status;
	/**
	 * The url Persephony checks for actions to perform to calls in this conference while waiting for it to start.
	 */
	private String waitUrl;
	/**
	 * The url Persephony sends updates to when the conference changes states.
	 */
	private String statusCallBackUrl;
	/**
	 * The list of subresources for this conference. Includes participants
	 * and/or recordings associated with this conference.
	 */
	private HashMap<String, String> subresourceUris;

	/**
	 *	Converts the provided JSON string into a Conference object.
	 *
	 *	@param json A JSON string representing a Persephony Conference instance.
	 *
	 *	@return A Conference object equivalent to the JSON string passed in.
	 * @throws PersyJSONException when the JSON is invalid.
	 */
	public static Conference fromJson (String json) throws PersyJSONException {
		try {
			return gson.fromJson(json, Conference.class);
		}
		catch(JsonSyntaxException jse) {
			throw new PersyJSONException(jse);
		}
	}

	/**
	 * Retrieve the conferenceId for this conference from the object.
	 *
	 * @return The conferenceId for this conference.
	 */
	public String getConferenceId() {
		return this.conferenceId;
	}

	/**
	 * Retrieve the accountId for this conference from the object.
	 *
	 * @return The accountId for this conference.
	 */
	public String getAccountId() {
		return this.accountId;
	}

	/**
	 * Retrieve the alias for this conference from the object.
	 *
	 * @return The alias for this conference.
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * Retrieve the playBeep for this conference from the object.
	 *
	 * @return The playBeep for this conference.
	 */
	public PlayBeep getPlayBeep() {
		return this.playBeep;
	}

	/**
	 * Retrieve the record for this conference from the object.
	 *
	 * @return The record for this conference.
	 */
	public Boolean getRecord() {
		return this.record;
	}

	/**
	 * Retrieve the status for this conference from the object.
	 *
	 * @return The status for this conference.
	 */
	public ConferenceStatus getStatus() {
		return this.status;
	}

	/**
	 * Retrieve the wait url for this conference from the object.
	 *
	 * @return The wait url for this conference.
	 */
	public String getWaitUrl() {
		return this.waitUrl;
	}

	/**
	 * Retrieve the status callback url for this conference from the object.
	 *
	 * @return The status callback url for this conference.
	 */
	public String getStatusCallBackUrl() {
		return this.statusCallBackUrl;
	}

	/**
	 * Retrieve the subresourceUris for this conference from the object.
	 *
	 * @return The subresourceUris for this conference.
	 */
	public HashMap<String, String> getSubresourceUris() {
		return this.subresourceUris;
	}

	/**
	 * Check if this conference equals another. This is done by comparing all fields in the conference for equality.
	 *
	 * @param that The Conference object for comparison.
	 * @return {@code true} if conferences are equal, {@code false} otherwise.
	 */
	public boolean equals(Conference that){
		boolean result = super.equals(that);

		if(this.conferenceId != null){
			result = result && that.conferenceId.equals(this.conferenceId);
		} else {
			result = result && that.conferenceId == null;
		}

		if(this.accountId != null){
			result = result && that.accountId.equals(this.accountId);
		} else {
			result = result && that.accountId == null;
		}

		if(this.alias != null){
			result = result && that.alias.equals(this.alias);
		} else {
			result = result && that.alias== null;
		}

		if(this.playBeep != null){
			result = result && that.playBeep.equals(this.playBeep);
		} else {
			result = result && that.playBeep == null;
		}

		if(this.record != null){
			result = result && that.record.equals(this.record);
		} else {
			result = result && that.record == null;
		}

		if(this.status != null){
			result = result && that.status.equals(this.status);
		} else {
			result = result && that.status == null;
		}

		if(this.waitUrl != null){
			result = result && that.waitUrl.equals(this.waitUrl);
		} else {
			result = result && that.waitUrl == null;
		}

		if(this.statusCallBackUrl != null){
			result = result && that.statusCallBackUrl.equals(this.statusCallBackUrl);
		} else {
			result = result && that.statusCallBackUrl == null;
		}

		if(this.subresourceUris != null){
			result = result && that.subresourceUris.equals(this.subresourceUris);
		} else {
			result = result && that.subresourceUris == null;
		}
		return result;
	}
	
}
