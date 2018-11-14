package com.vailsys.persephony.api.recording;

import java.util.Date;
import java.text.ParsePosition;
import java.text.FieldPosition;

import com.vailsys.persephony.api.Filters;
import com.vailsys.persephony.api.PersySDKException;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyDateException;

/**
 * Represents the possible fields one can set as filters when searching for Recordings.
 */
public class RecordingsSearchFilters extends Filters {
	/**
	 * The callId of a recording
	 */
	private String callId;
	/**
	 * The date the recording was created
	 */
	private String dateCreated;

	/**
	 * The conferenceId of a recording.
	 */
	private String conferenceId;

	/**
	 * Retrieve the value of the callId filter.
	 *
	 * @return The callId to filter on.
	 */
	public String getCallId() {
		return this.callId;	
	}

	/**
	 * Retrieve the value of the conferenceId filter.
	 *
	 * @return The conferenceId to filter on.
	 */
	public String getConferenceId() {
		return conferenceId;
	}

	/**
	 * Retrieve the value of the date created filter.
	 *
	 * @return The creation date to filter on.
	 */
	public String getDateCreated() {
		return this.dateCreated;	
	}

	/**
	 * Retrieve the value of the date created filter as a {@link java.util.Date}.
	 * @return The creation date to filter on.
	 * @throws PersyException when the date is null or can't be parsed.
	 */
	public Date getDateCreatedAsDate() throws PersyException {
		ParsePosition pos = new ParsePosition(0);

		Date dc;
		try {
			dc = dateCreatedFormat.parse(this.dateCreated, pos);
			if(pos.getErrorIndex() >= 0) {
				throw new PersyDateException(this.dateCreated, pos.getErrorIndex());
			}
		} catch(NullPointerException npe) {
			if(pos == null) {
				throw new PersySDKException(npe);
			} else {
				throw new PersyException("dateCreated field in RecordingsRequestFilters was null", npe);
			}
		}
		return dc;
	}

	/**
	 * Set the callId to filter on
	 * @param callId The callId to filter for when retrieving a list of Recordings.
	 */
	public void setCallId(String callId) {
		this.callId = callId;
	}

	/**
	 * Set the conferenceId to filter on.
	 *
	 * @param conferenceId The conferenceId to filter for when retrieving a list of Recordings.
	 */
	public void setConferenceId(String conferenceId) {
		this.conferenceId = conferenceId;
	}

	/**
	 * Set the dateCreated filter.
	 *
	 * @param dateCreated The date created value to filter for when retrieving a list of Recordings. The filtered list will only show Tecordings created on this date, formatted as YYYY-MM-DD.
	 */
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * Set the dateCreated filter.
	 *
	 * @param dateCreated The date created value to filter for when retrieving a list of Recordings.
	 */
	public void setDateCreated(Date dateCreated) {
		StringBuffer sb = new StringBuffer(dateCreatedFormatString.length());
		FieldPosition fp = new FieldPosition(0);

		StringBuffer dateCreatedBuffer = dateCreatedFormat.format(dateCreated, sb, fp);
		
		this.dateCreated = dateCreatedBuffer.toString();
	}
}
