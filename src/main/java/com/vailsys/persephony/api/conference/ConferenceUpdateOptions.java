package com.vailsys.persephony.api.conference;

import com.vailsys.persephony.api.CommonFields;

/**
 * The class represents the optional fields which can be passed in when
 * updating a Conference.
 *
 * @see com.vailsys.persephony.api.conference.ConferencesRequester#update(String,ConferenceUpdateOptions)
 */
public class ConferenceUpdateOptions extends CommonFields {
	/**
	 * The alias of the conference.
	 */
	private String alias;
	/**
	 * The setting controlling how the conference plays tones when participants join or leave the conference.
	 *
	 * @see com.vailsys.persephony.api.conference.PlayBeep
	 */
	private PlayBeep playBeep;
	/**
	 * The status of the conference.
	 *
	 * @see com.vailsys.persephony.api.conference.ConferenceStatus
	 */
	private ConferenceStatus status;

	/**
	 * Retrieve the alias value.
	 *
	 * @return The alias value of the object.
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * Retrieve the playBeep value.
	 *
	 * @return The playBeep value of the object.
	 *
	 * @see com.vailsys.persephony.api.conference.PlayBeep
	 */
	public PlayBeep getPlayBeep() {
		return this.playBeep;
	}

	/**
	 * Retrieve the status value.
	 *
	 * @return The status value of the object.
	 *
	 * @see com.vailsys.persephony.api.conference.ConferenceStatus
	 */
	public ConferenceStatus getStatus() {
		return this.status;
	}

	/**
	 * Sets the alias field.
	 *
	 * @param alias The value to which set alias.
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * Sets the playBeep field.
	 *
	 * @param playBeep The value to which to set playBeep.
	 *
	 * @see com.vailsys.persephony.api.conference.PlayBeep
	 */
	public void setPlayBeep(PlayBeep playBeep) {
		this.playBeep = playBeep;
	}

	/**
	 * Sets the status field.
	 *
	 * @param status The value to which to set status.
	 *
	 * @see com.vailsys.persephony.api.conference.ConferenceStatus
	 */
	public void setStatus(ConferenceStatus status) {
		this.status = status;
	}
}
