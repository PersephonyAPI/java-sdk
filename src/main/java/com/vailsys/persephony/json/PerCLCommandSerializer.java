package com.vailsys.persephony.json;

import java.lang.reflect.Type;

import com.vailsys.persephony.percl.PerCLCommand;
import static com.vailsys.persephony.json.PersyGson.gson;
 
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

public class PerCLCommandSerializer implements JsonSerializer<PerCLCommand> {

	public JsonElement serialize(PerCLCommand src, Type typeOfSrc, JsonSerializationContext context) {
		JsonElement srcJsonElem = gson.toJsonTree(src);

		JsonObject obj = new JsonObject();
		obj.add(src.getClass().getSimpleName(), srcJsonElem);

		return obj;
	}
}
