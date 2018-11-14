package com.vailsys.persephony.api.conference;

import java.text.ParsePosition;
import java.text.FieldPosition;
import java.util.Date;

import com.vailsys.persephony.api.Filters;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersySDKException;
import com.vailsys.persephony.api.PersyDateException;

/**
 * Represents the possible fields one can set as filters when searching for conferences.
 */
public class ConferencesSearchFilters extends Filters {
	/**
	 * The status of the conference.
	 * @see com.vailsys.persephony.api.conference.ConferenceStatus
	 */
	private ConferenceStatus status;
	/**
	 * The alias of the conference.
	 */
	private String alias;
	/**
	 * The date a conference in the results must have been created.
	 */
	private String dateCreated;
	/**
	 * The date a conference in the results must have been updated.
	 */
	private String dateUpdated;

	/**
	 * Retrieve the value of the status filter.
	 *
	 * @return The status of the conference.
	 */
	public ConferenceStatus getStatus() {
		return this.status;
	}

	/**
	 * Retrieve the value of the alias filter.
	 *
	 * @return The alias of the conference.
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * Retrieve the value of the dateCreated filter as a string.
	 *
	 * @return The date a conference in the results must have been created.
	 */
	public String getDateCreatedAsString() {
		return this.dateCreated;
	}

	/**
	 * Retrieve the value of the dateUpdated filter as a string.
	 *
	 * @return The date a conference in the results must have been updated.
	 */
	public String getDateUpdatedAsString() {
		return this.dateUpdated;
	}

	/**
	 * Retrieve the value of the dateCreated filter as a Java {@link java.util.Date} object.
	 *
	 * @return The date a conference in the results must have been created.
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
				throw new PersyException("dateCreated field in ConferencesRequestFilters was null", npe);
			}
		}
		return dc;
	}

	/**
	 * Retrieve the value of the dateUpdated filter as a Java {@link java.util.Date} object.
	 *
	 * @return The date a conference in the results must have been updated.
	 * @throws PersyException when the date is null or can't be parsed.
	 */
	public Date getDateUpdatedAsDate() throws PersyException {
		ParsePosition pos = new ParsePosition(0);

		Date dc;
		try {
			dc = dateCreatedFormat.parse(this.dateUpdated, pos);
			if(pos.getErrorIndex() >= 0) {
				throw new PersyDateException(this.dateUpdated, pos.getErrorIndex());
			}
		} catch(NullPointerException npe) {
			if(pos == null) {
				throw new PersySDKException(npe);
			} else {
				throw new PersyException("dateUpdated field in ConferencesRequestFilters was null", npe);
			}
		}
		return dc;
	}

	/**
	 * Set the status filter for conferences that are in the given state / have the given status.
	 * @param status The status to filter by.
	 * @see com.vailsys.persephony.api.conference.ConferenceStatus
	 */
	public void setStatus(ConferenceStatus status) {
		this.status = status;
	}

	/**
	 * Set the alias filter for conferences that match the alias.
	 * @param alias The alias to filter by.
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * Set the dateCreated filter to find conferences that were created on that date.
	 * @param dateCreated The date to filter by.
	 */
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * Set the dateUpdated filter to find conferences that were updated on that date.
	 * @param dateUpdated The date to filter by.
	 */
	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	/**
	 * Set the dateCreated filter to find conferences that were created on that date.
	 * @param dateCreated The date to filter by.
	 */
	public void setDateCreated(Date dateCreated) {
		StringBuffer sb = new StringBuffer(dateCreatedFormatString.length());
		FieldPosition fp = new FieldPosition(0);

		StringBuffer dateCreatedBuffer = dateCreatedFormat.format(dateCreated, sb, fp);
		
		this.dateCreated = dateCreatedBuffer.toString();
	}

	/**
	 * Set the dateUpdated filter to find conferences that were updated on that date.
	 * @param dateUpdated The date to filter by.
	 */
	public void setDateUpdated(Date dateUpdated) {
		StringBuffer sb = new StringBuffer(dateCreatedFormatString.length());
		FieldPosition fp = new FieldPosition(0);

		StringBuffer dateUpdatedBuffer = dateCreatedFormat.format(dateUpdated, sb, fp);
		
		this.dateUpdated = dateUpdatedBuffer.toString();
	}
}
