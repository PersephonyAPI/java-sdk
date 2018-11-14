package com.vailsys.persephony.json;

import com.vailsys.persephony.percl.GetDigitsNestable;
import com.vailsys.persephony.percl.GetSpeechNestable;
import com.vailsys.persephony.percl.PerCLCommand;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParsePosition;
import java.util.TimeZone;

public class PersyGson {
	/**
	 *	The date format used in resources returned from Persephony's API: {@code "EEE, dd MMM yyyy HH:mm:ss zzz"}
	 *	@see java.text.SimpleDateFormat
	 */
	public final static String rawDateFormat = "EEE, dd MMM yyyy HH:mm:ss zzz";
	public final static SimpleDateFormat PersyDateFormat = initDateFormat(); //Fri, 10 Jun 2016 21:35:27 GMT
	//Don't register more nestable adapters, just change the type to PerCLCommand in the percl classes and let the end user ensure the correct commands are being added
	public final static Gson gson = new GsonBuilder().setDateFormat(PersyGson.rawDateFormat).registerTypeAdapter(PerCLCommand.class, new PerCLCommandSerializer()).registerTypeAdapter(GetDigitsNestable.class, new PerCLCommandSerializer()).registerTypeAdapter(GetSpeechNestable.class, new PerCLCommandSerializer()).create();

	private static SimpleDateFormat initDateFormat() {
		SimpleDateFormat format = new SimpleDateFormat(PersyGson.rawDateFormat);
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		return format;
	}

}
