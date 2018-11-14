package com.vailsys.persephony.api.message;

import com.vailsys.persephony.api.CommonFields;

/**
 * The class represents the common optional fields which can be passed in when
 * creating a Message.
 *
 * @see com.vailsys.persephony.api.message.MessagesRequester#create(String,String,String,MessageOptions)
 */
public class MessageOptions extends CommonFields {
	/**
	 * The url that will be requested when the status of an outbound message changes.
	 */
	private String notificationUrl;

	/**
	 * Create an empty {@code MessageOptions} object. Set only values that are
	 * desired to be included in the request. Any unset fields will be ignored.
	 */
	public MessageOptions() {
		notificationUrl = null;
	}

	/**
	 * Sets the notificationUrl field.
	 *
	 * @param notificationUrl Value to which to set notificationUrl.
	 */
	public void setNotificationUrl(String notificationUrl){
		this.notificationUrl = notificationUrl;
	}

	/**
	 * Retrieve the notificationUrl value.
	 *
	 * @return The notificationUrl value of the object.
	 */
	public String getNotificationUrl() {
		return this.notificationUrl;
	}

}

