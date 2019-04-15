package com.vailsys.persephony.api.call;

import static com.vailsys.persephony.json.PersyGson.gson;

import java.util.Date;
import java.util.HashMap;

import com.vailsys.persephony.api.PersyCommon;
import com.vailsys.persephony.api.PersyJSONException;
import com.vailsys.persephony.api.call.AnsweredBy;
import com.vailsys.persephony.api.call.Direction;
import com.vailsys.persephony.api.call.CallStatus;

import com.google.gson.JsonSyntaxException;

/**
 * This class represents a Persephony Call instance. Call objects are created
 * by the SDK whenever a call instance would be returned by the API; these
 * primarily come from a {@link com.vailsys.persephony.api.call.CallsRequester}
 * inside a {@link com.vailsys.persephony.api.PersyClient} instance.<br>
 * <br>
 * Calls are immutable and intended only to be used to read information
 * returned from the API in a language accessible way.
 *
 * @see com.vailsys.persephony.api.call.CallsRequester
 * @see com.vailsys.persephony.api.PersyClient
 */
public class Call extends PersyCommon {
	/** 
	 * The callId for this call instance. 
	 */
	private String callId;
	/** 
	 * The callId of the call that created this call (if one exists). 
	 */
	private String parentCallId;
	/** 
	 * The accountId for the account that created this call. 
	 */
	private String accountId;
	/** 
	 * The number or SIP URI that recieved this call. 
	 */
	private String to;
	/** 
	 * The number or SIP URI that initiated this call. 
	 */
	private String from;
	/** If the call was inbound, this is the ID of the IncomingPhoneNumber that
	 * received the call. If the call was outbound, it is the ID of the
	 * CallingNumber from which the call was placed. */
	private String phoneNumberId;
	/** 
	 * This represents the current status or state of this call. 
	 * @see com.vailsys.persephony.api.call.CallStatus
	 */
	private CallStatus status;
	/** 
	 * The time this call was started. 
	 */
	private Date startTime;
	/**
	 * The time this call was answered.
	 */
	private Date connectTime;
	/** 
	 * The time this call ended. 
	 */
	private Date endTime;
	/** The duration of this call in seconds. */
	private Integer duration;
	/** The duration that this call was connected in seconds. */
	private Integer connectDuration;
	/** 
	 * The direction (inbound, outbound, etc.) of this call.
	 * @see com.vailsys.persephony.api.call.Direction
	 */
	private Direction direction;
	/**
	 * Who/What answered this call, if it was answered at all.
	 * @see com.vailsys.persephony.api.call.AnsweredBy
	 */
	private AnsweredBy answeredBy;
	/**
	 * If this call was an incoming call to a phone number with
	 * Caller ID Lookup enabled, the caller's name, empty
	 * otherwise.
	 */
	private String callerName;
	/**
	 * The list of subresources for this call. Includes notifications and/or
	 * recordings associated with the call.
	 */
	private HashMap<String, String> subresourceUris;

	/**
	 *	Converts the provided JSON string into a Call object.
	 *
	 *	@param json A JSON string representing a Persephony Call instance.
	 *
	 *	@return A Call object equivalent to the JSON string passed in.
	 * 	@throws PersyJSONException when the JSON is invalid.
	 */
	public static Call fromJson (String json) throws PersyJSONException {
		try {
			return gson.fromJson(json, Call.class);
		}
		catch(JsonSyntaxException jse) {
			throw new PersyJSONException(jse);
		}
	}

	/**
	 * Retrieve the callId for this call from the object.
	 *
	 * @return The callId for this call.
	 */
	public String getCallId() {
		return this.callId;
	}
	/**
	 * Retrieve the parentCallId for this call from the object.
	 *
	 * @return The parentCallId for this call.
	 */
	public String getParentCallId() {
		return this.parentCallId;
	}
	/**
	 * Retrieve the accountId for this call from the object.
	 *
	 * @return The accountId for this call.
	 */
	public String getAccountId() {
		return this.accountId;
	}
	/**
	 * Retrieve the to number (DNIS) for this call from the object.
	 *
	 * @return The to number (DNIS) for this call.
	 */
	public String getTo() {
		return this.to;
	}
	/**
	 * Retrieve the from number (ANI) for this call from the object.
	 *
	 * @return The from number (ANI) for this call.
	 */
	public String getFrom() {
		return this.from;
	}
	/**
	 * Retrieve the phoneNumberId for this call the object.
	 *
	 * @return The phoneNumberId for this call.
	 */
	public String getPhoneNumberId() {
		return this.phoneNumberId;
	}
	/**
	 * Retrieve the status for this call from the object.
	 *
	 * @return The status for this call.
	 *
	 * @see com.vailsys.persephony.api.call.CallStatus
	 */
	public CallStatus getStatus() {
		return this.status;
	}
	/**
	 * Retrieve the start time for this call from the object.
	 *
	 * @return The start time for this call.
	 */
	public Date getStartTime() {
		return this.startTime;
	}
	/**
	 * Retrieve the time this call was answered from the object.
	 *
	 * @return The time this call was answered.
	 */
	public Date getConnectTime() {
		return this.connectTime;
	}
	/**
	 * Retrieve the end time for this call from the object.
	 *
	 * @return The end time for this call.
	 */
	public Date getEndTime() {
		return this.endTime;
	}
	/**
	 * Retrieve the duration, in seconds, for this call from the object.
	 *
	 * @return The duration for this call in seconds.
	 */
	public Integer getDuration() {
		return this.duration;
	}
	/**
	 * Retrieve the connection duration, in seconds, for this call from the object.
	 *
	 * @return The connection duration for this call in seconds.
	 */
	public Integer getConnectDuration() {
		return this.connectDuration;
	}
	/**
	 * Retrieve the direction of this call from the object.
	 *
	 * @return The direction of this call.
	 *
	 * @see com.vailsys.persephony.api.call.Direction
	 */
	public Direction getDirection() {
		return this.direction;
	}
	/**
	 * Retrieve the answeredBy value for this call from the object.
	 *
	 * @return The answeredBy value for this call.
	 *
	 * @see com.vailsys.persephony.api.call.CallStatus
	 */
	public AnsweredBy getAnsweredBy() {
		return this.answeredBy;
	}
	/**
	 * Retrieve the name of the caller for this call from the object.
	 *
	 * @return The name of the caller for this call.
	 */
	public String getCallerName() {
		return this.callerName;
	}
	/**
	 * Retrieve the subresourceUris for this call from the object.
	 *
	 * @return The subresourceUris for this call.
	 */
	public HashMap<String, String> getSubresourceUris() {
		return this.subresourceUris;
	}

	/**
	 * Convert this call into a JSON string representing the object.
	 *
	 * @return JSON string representing this call.
	 */
	public String toString() {
		return gson.toJson(this);
	}

	/**
	 * Check if this call equals another. This is done by comparing all fields in the call for equality.
	 *
	 * @param that The Call object for comparison.
	 *
	 * @return {@code true} if calls are equal, {@code false} otherwise.
	 */
	public boolean equals(Call that) {
		boolean result = true;

		result = result && super.equals(that);

		if(this.callId != null) {
			result = result && this.callId.equals(that.callId);
		} else {
			result = result && that.callId == null;
		}

		if(this.parentCallId != null) {
			result = result && this.parentCallId.equals(that.parentCallId);
		} else {
			result = result && that.parentCallId == null;
		}

		if(this.accountId != null) {
			result = result && this.accountId.equals(that.accountId);
		} else {
			result = result && that.accountId == null;
		}

		if(this.to != null) {
			result = result && this.to.equals(that.to);
		} else {
			result = result && that.to == null;
		}

		if(this.from != null) {
			result = result && this.from.equals(that.from);
		} else {
			result = result && that.from == null;
		}
		
		if(this.phoneNumberId != null) {
			result = result && this.phoneNumberId.equals(that.phoneNumberId);
		} else {
			result = result && that.phoneNumberId == null;
		}
		
		if(this.status != null) {
			result = result && this.status.equals(that.status);
		} else {
			result = result && that.status == null;
		}

		if(this.startTime != null) {
			result = result && this.startTime.equals(that.startTime);
		} else {
			result = result && that.startTime == null;
		}

		if(this.connectTime != null) {
			result = result && this.connectTime.equals(that.connectTime);
		} else {
			result = result && that.connectTime == null;
		}
		
		if(this.endTime != null) {
			result = result && this.endTime.equals(that.endTime);
		} else {
			result = result && that.endTime == null;
		}
		
		if(this.duration != null) {
			result = result && this.duration.equals(that.duration);
		} else {
			result = result && that.duration == null;
		}

		if(this.connectDuration != null) {
			result = result && this.connectDuration.equals(that.connectDuration);
		} else {
			result = result && that.connectDuration == null;
		}
		
		if(this.answeredBy != null) {
			result = result && this.answeredBy.equals(that.answeredBy);
		} else {
			result = result && that.answeredBy == null;
		}
		
		if(this.callerName != null) {
			result = result && this.callerName.equals(that.callerName);
		} else {
			result = result && that.callerName == null;
		}
		
		if(this.subresourceUris != null) {
			result = result && this.subresourceUris.equals(that.subresourceUris);
		} else {
			result = result && that.subresourceUris == null;
		}

		return result;
	}
}
