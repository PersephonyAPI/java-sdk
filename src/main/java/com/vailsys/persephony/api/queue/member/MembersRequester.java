package com.vailsys.persephony.api.queue.member;

import com.google.gson.JsonIOException;
import com.vailsys.persephony.api.APIAccountRequester;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyJSONException;

/**
 * This class represents the set of wrappers around the Persephony Members API.
 * It provides methods to handle all the operations supported by the Persephony Members API.
 */
public class MembersRequester extends APIAccountRequester {
    private static final String pathHead = "Members";
    /** The default path for the Members endpoint. */
    private final String path;
    /** The accountId for the acting account. */
    private final String actingAccountId;

    /**
     * Creates a MembersRequester. For most SDK users MembersRequesters will be created automatically by the {@link com.vailsys.persephony.api.PersyClient} but is available for more advanced users who only require the features in this specific requester and not the rest of the features of the {@link com.vailsys.persephony.api.PersyClient}.
     *
     * @param credAccountId The accountId to use as authentication credentials
     * in the HTTP Basic Auth header for requests made by this requester.
     * @param credAuthToken The authToken to use as authentication credentials
     * in the HTTP Basic Auth header for requests made by this requester.
     * @param actingAccountId The accountId to act as. This can be the same as
     * the {@code credAccountId} or the accountId of a subaccount of the {@code credAccountId}.
     * @param queuePath The path for the queue endpoint this MembersRequester is under.
     */
    public MembersRequester(String credAccountId, String credAuthToken, String actingAccountId, String queuePath){
        super(credAccountId, credAuthToken);
        this.actingAccountId = actingAccountId;
        this.path = APIAccountRequester.constructPath(queuePath, pathHead);
    }

    /**
     * Retrieve the {@code actingAccountId}.
     *
     * @return The {@code actingAccountId}
     */
    public String getActingAccountId() {
        return actingAccountId;
    }

    /**
     * Retrieve the {@code path} value generated by the MembersRequester. This is
     * the URL path used in requests to Persephony.
     *
     * @return The {@code path}
     */
    public String getPath() {
        return path;
    }

    private String getMemberPath(String callId){
        return APIAccountRequester.constructPath(this.getPath(), callId);
    }

    /**
     * Allows developers using the SDK to change which instance of the Persephony API that the MembersRequester points to.
     *
     * @param newUrl The new URL to use in place of the default APIAccountRequester.PERSY_URL
     */
    public void setPersyUrl(String newUrl) { super.setPersyUrl(newUrl);}

    /**
     * Retrieve a list of members associated with the queue.
     * This wraps an HTTP GET request to the Persephony API's
     * /Accounts/$accountId/Queues/$queueId/Members endpoint. This will retrieve all members for
     * the queue.
     *
     * @return An in-language representation of Persephony's paginated list
     * response. This will be a paginated list of member instances as returned by
     * the Persephony API.
     *
     * @see com.vailsys.persephony.api.queue.member.Member
     * @throws PersyException when the request fails or the response is not valid JSON.
     */
    public MemberList get() throws PersyException {
        return new MemberList(this.getCredentialAccountId(), this.getCredentialAuthToken(), this.GET(this.getPath()));
    }

    /**
     * Retrieve a single member from the queue.
     *
     * @param callId The {@code callId} of the desired member.
     *
     * @return The member matching the {@code callId} provided.
     * @throws PersyException when the request fails or the JSON is invalid.
     */
    public Member get(String callId) throws PersyException {
        return Member.fromJson(this.GET(this.getMemberPath(callId)));
    }

    /**
     * Retrieve a single member from the front of the queue.
     *
     * @return The member at the front of the queue.
     * @throws PersyException when the request fails or the JSON is invalid.
     */
    public Member getFront() throws PersyException {
        return Member.fromJson(this.GET(this.getMemberPath("Front")));
    }

    /**
     * Dequeue a single member from the queue.
     * This wraps an HTTP POST request to the Persephony API's
     * /Accounts/$accountId/Queues/$queueId/Members/$callId endpoint.
     *
     * @param callId The {@code callId} of the desired member.
     *
     * @return The member matching the {@code callId} provided.
     * @throws PersyException when the request fails or the JSON is invalid.
     */
    public Member dequeue(String callId) throws PersyException {
        return Member.fromJson(this.POST(this.getMemberPath(callId), null));
    }

    /**
     * Dequeue a single member from the queue.
     * This wraps an HTTP POST to the Persephony API's
     * /Accounts/$accountId/Queues/$queueId/Members/$callId endpoint.
     *
     * @param callId The {@code callId} of the desired member.
     * @param requestId The {@code requestId} of the request.
     *
     * @return The member matching the {@code callId} provided.
     * @throws PersyException when the request fails or the JSON is invalid.
     */
    public Member dequeue(String callId, String requestId) throws PersyException {
        try {
            return Member.fromJson(this.POST(this.getMemberPath(callId), new DequeueMemberRequest(requestId).toJson()));
        } catch (JsonIOException jioe){
            throw new PersyJSONException(jioe);
        }
    }

    /**
     * Dequeue a single member from the front of the queue.
     * This wraps an HTTP POST request to the Persephony API's
     * /Accounts/$accountId/Queues/$queueId/Members/Front endpoint.
     *
     * @return The member at the front of the queue.
     * @throws PersyException when the request fails or the response is not valid JSON.
     */
    public Member dequeueFront() throws PersyException {
        return Member.fromJson(this.POST(this.getMemberPath("Front"), null));
    }

    /**
     * Dequeue a single member from the front of the queue.
     * This wraps an HTTP POST request to the Persephony API's
     * /Accounts/$accountId/Queues/$queueId/Members/Front endpoint.
     *
     * @param requestId The {@code requestId} of the request.
     *
     * @return The member at the front of the queue.
     * @throws PersyException when the request fails or the response is not valid JSON.
     */
    public Member dequeueFront(String requestId) throws PersyException {
        try {
            return Member.fromJson(this.POST(this.getMemberPath("Front"), new DequeueMemberRequest(requestId).toJson()));
        } catch (JsonIOException jioe) {
            throw new PersyJSONException(jioe);
        }
    }
}
