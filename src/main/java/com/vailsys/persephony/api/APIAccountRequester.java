package com.vailsys.persephony.api;

/**
 *	The APIAccountRequester is the base class for various *Requester classes which
 *	each wrap a portion of the Persephony API. This class abstracts away the
 *	messiness that can be directly interacting with the API over HTTP to reduce
 *	code duplication in these child Requesters and ease their development. Specifically this class is used by *Requester classes that have an endpoint under the Persephony API /Accounts path but aren't related to the Accounts resource.
 */
public class APIAccountRequester extends APIRequester {
    private static final String accountPathHead = "Accounts";
    /** The rootPath is used by subclasses to build the path to their endpoints. */
    protected static final String rootPath = constructAbsolutePath(accountPathHead);

    protected APIAccountRequester(String credAccountId, String credAuthToken){
        super(credAccountId, credAuthToken);
    }
}
