package com.vailsys.persephony.api;

public class APIRequesterModder {
	public static void changePersyUrl(APIRequester req, String newUrl) throws ThisIsABadIdeaException {
		req.setPersyUrl(newUrl);
		throw new ThisIsABadIdeaException();
	}
}
