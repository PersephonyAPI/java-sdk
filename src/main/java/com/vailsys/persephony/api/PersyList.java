package com.vailsys.persephony.api;

import static com.vailsys.persephony.json.PersyGson.gson;

import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;
import java.io.StringReader;
import java.io.IOException;

import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.JsonParseException;

/**
 *	Base class for representing a list of resources returned by the Persephony
 *	API. Resources are kept in an ArrayList which the user is given limited
 *	access to. Subclasses for each type of resource that can be returned in
 *	Persephony API's paginated lists should be made to wrap around this.
 */
public abstract class PersyList<T> extends APIRequester {
	//These fields exist in list results but don't really provided anything to the user.
	private int page;
	private int numPages;
	private int pageSize;
	private int start;
	private int end;
	
	//Actually useful fields
	private int total;
	private String nextPageUri;

	private ArrayList<T> list;
	private String listField;
	private Class<T> theType;

	/**
	 *	Creates a PersyList based on the JSON list returned by the Persephony API (rawPage).
	 *
	 *	@param accountId The accountId to use for credentials with the Persephony API when pulling new pages of the list.
	 *	@param authToken The authToken to use for credentials with the Persephony API when pulling new pages of the list.
	 *	@param rawPage The JSON string representing the first page of the list.
	 *	@param listField The name of the array of resources within the raw JSON list. For example, for lists of Call resources the field is called "calls" and for Queues it's called "queues".
	 * @param theType The Type of the Persephony Resource this list will contain.
	 * @throws PersyException when the page is not valid JSON.
	 */
	protected PersyList(String accountId, String authToken, String rawPage, String listField, Class<T> theType ) throws PersyException {
		super(accountId, authToken);
		this.list = new ArrayList<T>();
		this.listField = listField;
		this.theType = theType;
		this.buildFromJson(rawPage);
	}

	/** @return the total size of the results list including what is still in non-downloaded pages.*/
	public int getTotalSize() {
		return this.total;
	}

	/** @return the size of the underlying ArrayList.*/
	public int getLocalSize() {
		return this.list.size();
	}

	/** 
	 * @return the size of a page in the list as defined by the response from
	 * Persephony.
	 */
	public int getPageSize() {
		return this.pageSize;
	}

	/**
	 * @param i The index of the element to retrieve.
	 * @return the ith item in the local list.
	 * */
	public T get(int i) {
		return this.list.get(i);
	}

	/** @return a copy of the underlying list.*/
	@SuppressWarnings("unchecked")
	public ArrayList<T> export() {
		return (ArrayList<T>)(this.list.clone());
	}

	/**
	 *  Loads the next page of the list into the local array
	 * @throws PersyException in the case that fetching the next page fails or the response is invalid JSON.
	 */
	public void loadNextPage() throws PersyException {
		String rawPage = this.fetchNextPage();
		this.buildFromJson(rawPage);
	}

	/**
	 *	Update the PersyList with the data from the provided next page.
	 *
	 *	@param rawPage The raw JSON string representing a page of a list.
	 * 	@throws PersyJSONException when the JSON is invalid.
	 */
	protected void buildFromJson(String rawPage) throws PersyJSONException {
		JsonParser jp = new JsonParser();
		JsonElement je;
		try {
			je = jp.parse(rawPage);
		}
		catch (JsonParseException e) {
			throw new PersyJSONException(e);
		}

		JsonObject jo;
		try {
			jo = je.getAsJsonObject();
		}
		catch (IllegalStateException ise) {
			throw new PersyJSONException(ise);
		}

		try {
			this.page = jo.get("page").getAsInt();
			this.numPages = jo.get("numPages").getAsInt();
			this.pageSize = jo.get("pageSize").getAsInt();
			this.start = jo.get("start").getAsInt();
			this.end = jo.get("end").getAsInt();
			this.total = jo.get("total").getAsInt();

			JsonElement nextPageUriElement = jo.get("nextPageUri");
			if(nextPageUriElement.isJsonNull()) {
				this.nextPageUri = null;
			} else {
				this.nextPageUri = nextPageUriElement.getAsString();
			}
		}
		catch (ClassCastException|IllegalStateException e) {
			throw new PersyJSONException(e);
		}

		JsonArray ja; 
		try {
			ja = jo.get(this.listField).getAsJsonArray();
		}
		catch (IllegalStateException ise) {
			throw new PersyJSONException(ise);
		}

		for(JsonElement element : ja) {
			this.list.add(gson.fromJson(element, theType));
		}
	}

	/**
	 *	Use the internal APIRequester to return the next page of the list.
	 *
	 *	@return the raw JSON string representing the next page of the list.
	 */
	private String fetchNextPage() throws PersyException {
		String result = null;
		if(this.nextPageUri != null) {
			result = super.GET(this.nextPageUri);
		}

		return result;
	}
}
