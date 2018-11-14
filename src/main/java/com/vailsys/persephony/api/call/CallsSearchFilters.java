package com.vailsys.persephony.api.call;

import java.util.HashMap;
import java.util.Date;
import java.lang.reflect.Type;

import com.vailsys.persephony.api.APIRequester;
import com.vailsys.persephony.api.Filters;
import com.vailsys.persephony.api.PersyJSONException;
import static com.vailsys.persephony.json.PersyGson.gson;
import com.vailsys.persephony.api.call.CallStatus;

import com.google.gson.reflect.TypeToken;

/**
 * Represents the possible fields one can set as filters when searching for
 * calls.
 */
public class CallsSearchFilters extends Filters {
	/**
	 * The number that was dialed out to (DNIS).
	 */
	private String to;
	/**
	 * The number that the call was placed from (ANI).
	 */
	private String from;
	/**
	 *  The status of the call.
	 *
	 *  @see com.vailsys.persephony.api.call.CallStatus
	 */
	private CallStatus status;
	/**
	 *  The earliest time a call in the results could have started at.
	 */
	private Long startTime;
	/**
	 *  The latest time a call in the results could have ended at.
	 */
	private Long endTime;
	/**
	 * The callId of the call that spawned this one.
	 */
	private String parentCallId;

	/**
	 * Retrieve the value of the to (DNIS) filter. 
	 *
	 * @return The number that was dialed out to (DNIS).
	 */
	public String getTo() {
		return this.to;
	}
	
	/**
	 * Retrieve the value of the from (ANI) filter. 
	 *
	 * @return The number that the call was placed from (ANI).
	 */
	public String getFrom() {
		return this.from;
	}
	
	/**
	 * Retrieve the value of the status filter. 
	 *  
	 * @return The status of the call.
	 *
	 *  @see com.vailsys.persephony.api.call.CallStatus
	 */
	public CallStatus getStatus() {
		return this.status;
	}
	
	/**
	 * Retrieve the value of the startTime filter as a Java 
	 * {@link java.util.Date} object. 
	 *
	 * @return The earliest time a call in the results could have started at.
	 */
	public Date getStartTime() {
		if(this.startTime == null) {
			return null;
		}
		return new Date(this.startTime*1000);
	}
	
	/**
	 * Retrieve the value of the endTime filter as a Java 
	 * {@link java.util.Date} object. 
	 *
	 * @return The latest time a call in the results could have ended.
	 */
	public Date getEndTime() {
		if(this.endTime == null) {
			return null;
		}
		return new Date(this.endTime*1000);
	}
	
	/**
	 * Retrieve the value of the startTime filter as a Long integer Unix style
	 * timestamp in milliseconds. 
	 *
	 * @return The earliest time a call in the results could have started at.
	 */
	public Long getStartTimeLong() {
		return this.startTime;
	}
	
	/**
	 * Retrieve the value of the endTime filter as a Long integer Unix style
	 * timestamp in milliseconds. 
	 *
	 * @return The latest time a call in the results could have ended.
	 */
	public Long getEndTimeLong() {
		return this.endTime;
	}
	
	/**
	 * Retrieve the value of the endTime filter as a Long integer Unix style
	 * timestamp in milliseconds. 
	 *
	 * @return The callId of the call that spawned this one.
	 */
	public String getParentCallId() {
		return this.parentCallId;
	}
	
	/**
	 * Set this to filter for calls that are to the provided number (search by
	 * DNIS).
	 * @param to The To phone number to filter by.
	 */
	public void setTo(String to) {
		this.to = to;
	}
	
	/**
	 * Set the from filter for calls that are/were called from the provided
	 * number (search by ANI).
	 * @param from the from phone number to filter by.
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	
	/**
	 * Set the status filter for calls that are in the given state/have the
	 * given status.
	 * @see com.vailsys.persephony.api.call.CallStatus
	 * @param status The status to filter by.
	 */
	public void setStatus(CallStatus status) {
		this.status = status;
	}
	
	/**
	 * Set the startTime filter to find calls that started after the provided
	 * time.
	 * @param startTime the timestamp of the oldest call to filter by.
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime.getTime()/1000;
	}
	
	/**
	 * Set the endTime filter to find calls that ended before the provided
	 * time.
	 * @param endTime The timestamp of the latest call to filter by.
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime.getTime()/1000;
	}

	/**
	 * Set the startTime filter to find calls that started after the provided
	 * time.
	 * @param startTime The timestamp of the oldest call to filter by.
	 */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * Set the endTime filter to find calls that ended before the provided
	 * time.
	 * @param endTime the tiemstamp of the latest call to filter by.
	 */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * Set the parentCallId filter to find calls with the provided
	 * parentCallId.
	 * @param parentCallId The callId of the parent call.
	 */
	public void setParentCallId(String parentCallId) {
		this.parentCallId = parentCallId;
	}
}
