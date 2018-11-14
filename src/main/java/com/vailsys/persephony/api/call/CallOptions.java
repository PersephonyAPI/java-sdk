package com.vailsys.persephony.api.call;

import com.vailsys.persephony.api.CommonFields;

/**
 * The class represents the common optional fields which can be passed in when
 * creating a Call.
 *
 * @see com.vailsys.persephony.api.call.CallsRequester#create(String,String,String,CallOptions)
 * @see com.vailsys.persephony.api.call.CallsRequester#create(String,String,String,String,CallOptions)
 */
public class CallOptions extends CommonFields {
	/**
	 * A string of keys to dial after connecting to the number. Refer to
	 * SendDigits PerCL command for the format of the digits string. 
	 */
	private String sendDigits;
	/** 
	 * Indicates what to do if Persephony detects that the call is answered by
	 * an answering machine.
	 *
	 * @see com.vailsys.persephony.api.call.IfMachine 
	 */
	private IfMachine ifMachine;
	/** 
	 * Time, in seconds, to wait before assuming there is no answer and
	 * hanging up the call. 
	 */
	private Integer timeout;
	/**
	 * The callId of the call that created this call (if one exists).
	 */
	private String parentCallId;

	/**
	 * Create an empty {@code CallOptions} object. Set only values that are
	 * desired to be included in the request. Any unset fields will be ignored.
	 */
	public CallOptions() {
		sendDigits = null;
		ifMachine = null;
		timeout = null;
		parentCallId = null;
	}

	/**
	 * Sets the sendDigits field.
	 * 
	 * @param sendDigits Value to which to set sendDigits.
	 */
	public void setSendDigits(String sendDigits){
		this.sendDigits = sendDigits;
	}
	
	/**
	 * Sets the ifMachine field.
	 * 
	 * @param ifMachine Value to which to set ifMachine.
	 */
	public void setIfMachine(IfMachine ifMachine){
		this.ifMachine = ifMachine;
	}
	
	/**
	 * Sets the timeout field.
	 * 
	 * @param timeout Value to which to set timeout.
	 */
	public void setTimeout(Integer timeout){
		this.timeout = timeout;
	}

	/**
	 * Sets the parentCallId field.
	 *
	 * @param parentCallId Value to which to set parentCallId.
	 */
	public void setParentCallId(String parentCallId){
		this.parentCallId = parentCallId;
	}

	/**
	 * Retrieve the sendDigits value.
	 * 
	 * @return The sendDigits value of the object.
	 */
	public String getSendDigits() {
		return this.sendDigits;
	}
	
	/**
	 * Retrieve the ifMachine value.
	 * 
	 * @return The ifMachine value of the object.
	 *
	 * @see com.vailsys.persephony.api.call.IfMachine 
	 */
	public IfMachine getIfMachine() {
		return this.ifMachine;
	}
	
	/**
	 * Retrieve the timeout value.
	 * 
	 * @return The timeout value of the object.
	 */
	public Integer getTimeout() {
		return this.timeout;
	}

	/**
	 * Retrieve the parentCallId value.
	 *
	 * @return The parentCallId value of the object.
	 */
	public String getParentCallId() {
		return this.parentCallId;
	}
	
}
