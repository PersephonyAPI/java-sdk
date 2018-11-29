package com.vailsys.persephony.api.call;

import static com.vailsys.persephony.json.PersyGson.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import java.util.Map;

/**
 * Represents the fields needed to create a new call on Persephony.
 *
 * @see com.vailsys.persephony.api.call.CallsRequester
 */
class CreateCallRequest {
	public String to;
	public String from;

	public String applicationId;

	public CallOptions options;

	/**
	 * Setup a new call creation payload using an applicationId.
	 *
	 * @param to The number to call out to (DNIS). This can be any valid phone
	 * number formatted in E.164 format.
	 * @param from The number to call from (ANI). This must be a number
	 * purchase from Persephony or a verified phone number owned by the user.
	 * @param applicationId The {@code applicationId} for the registered
	 * Persephony application which should handle this call.
	 * @param options Optional arguments that can be provided when creating
	 * a call. See Persephony documentation for details.
	 */
	public CreateCallRequest(String to, String from, String applicationId, CallOptions options) {
		this.to = to;
		this.from = from;
		this.applicationId = applicationId;
		this.options = options;
	}

	/**
	 * Convert this object into a JSON payload to use in Persephony call creation requests.
	 *
	 * @return JSON representation of this object.
	 */
	public String toJson() throws JsonIOException {
		JsonElement el = gson.toJsonTree(this);
		JsonObject obj = el.getAsJsonObject();
		if(obj.has("options")){
			JsonObject options = obj.getAsJsonObject("options");
			obj.remove("options");
			for( Map.Entry<String, JsonElement> entry: options.entrySet()) {
				obj.add(entry.getKey(), entry.getValue());
			}
		}
		return obj.toString();
	}
}
