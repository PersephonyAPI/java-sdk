package com.vailsys.persephony.api;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.google.gson.reflect.TypeToken;

import com.vailsys.persephony.api.APIRequester;
import static com.vailsys.persephony.json.PersyGson.gson;


public class Filters {
	public static final String dateCreatedFormatString = "yyyy-MM-dd";
	public static final SimpleDateFormat dateCreatedFormat = new SimpleDateFormat(dateCreatedFormatString);

	public String toString() {
		String result;
		Type t = new TypeToken<HashMap<String, String>>(){}.getType();
		try {
			HashMap<String,String> filtersMap = gson.fromJson(gson.toJson(this), t);
			result = APIRequester.mapToQueryString(filtersMap);
		} catch(Exception e) {
			result = null;
		}
		return result;
	}
}
