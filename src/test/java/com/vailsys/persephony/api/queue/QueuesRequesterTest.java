package com.vailsys.persephony.api.queue;

import com.vailsys.persephony.api.queue.member.MembersRequester;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import world.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertTrue;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class QueuesRequesterTest {
    private QueuesRequester requester;
    private static String aTestQueue = "{\"uri\":\"/Accounts/AC6ae9421d4d7ca60c825b5e8f32d9aa225f79990f/Queues/QUc82cf641d98e785b8e65a894e4563a899e52f000\",\"dateCreated\":\"Thu, 13 Oct 2016 18:28:01 GMT\",\"dateUpdated\":\"Thu, 13 Oct 2016 18:28:01 GMT\",\"revision\":1, \"accountId\":\"AC6ae9421d4d7ca60c825b5e8f32d9aa225f79990f\", \"queueId\":\"QUc82cf641d98e785b8e65a894e4563a899e52f000\", \"alias\":\"the number\", \"maxSize\":100, \"currentSize\":1, \"averageWaitTime\":0, \"subresourceUris\":{ \"members\":\"/Accounts/AC6ae9421d4d7ca60c825b5e8f32d9aa225f79990f/Queues/QUc82cf641d98e785b8e65a894e4563a899e52f000/Members\"}}";
    private static String anUpdatedTestQueue = "{\"uri\":\"/Accounts/AC6ae9421d4d7ca60c825b5e8f32d9aa225f79990f/Queues/QUc82cf641d98e785b8e65a894e4563a899e52f000\",\"dateCreated\":\"Thu, 13 Oct 2016 18:28:01 GMT\",\"dateUpdated\":\"Thu, 13 Oct 2016 18:28:01 GMT\",\"revision\":1, \"accountId\":\"AC6ae9421d4d7ca60c825b5e8f32d9aa225f79990f\", \"queueId\":\"QUc82cf641d98e785b8e65a894e4563a899e52f000\", \"alias\":\"test alias\", \"maxSize\":12, \"currentSize\":1, \"averageWaitTime\":0, \"subresourceUris\":{ \"members\":\"/Accounts/AC6ae9421d4d7ca60c825b5e8f32d9aa225f79990f/Queues/QUc82cf641d98e785b8e65a894e4563a899e52f000/Members\"}}";
    private static String aTestQueueList = "{\"total\": 1, \"start\": 0, \"end\": 0, \"page\": 0, \"numPages\": 1, \"pageSize\": 1, \"nextPageUri\": null, \"queues\": [" + QueuesRequesterTest.aTestQueue + "]}";

    @Given("^a QueuesRequester with the credentials (.*) and (.*) and using the accountId (.*)$")
    public void createQueuesRequester(String credId, String credAuth, String accountId) throws Throwable {
        this.requester = new QueuesRequester(credId, credAuth, accountId);
        this.requester.setPersyUrl("http://127.0.0.1:"+ Helper.getServerPort());
    }

    @Then("^check the QueuesRequester acting accountId is (.*)$")
    public void checkActingAccountId(String accountId){
        assertThat(requester.getActingAccountId(), is(accountId));
    }

    @Then("^check the QueuesRequester path is (.*)$")
    public void checkPath(String path){
        assertThat(this.requester.getPath(), is(path));
    }

    @Then("^get a list of queues$")
    public void getQueueList() throws Throwable {
        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.requester.getPath())
        ).respond(
                response().withStatusCode(200).withBody(QueuesRequesterTest.aTestQueueList)
        );

        QueueList ql = this.requester.get();
        QueueList orig = new QueueList("ACCOUNTID", "AUTHTOKEN", QueuesRequesterTest.aTestQueueList);
        assertThat(ql.getTotalSize(), is(orig.getTotalSize()));
        assertThat(ql.getLocalSize(), is(orig.getLocalSize()));
    }

    @Then("^get a list of queues with filters$")
    public void getQueueListWithFilters() throws Throwable {
        QueuesSearchFilters qsf = new QueuesSearchFilters();
        qsf.setAlias("the number");

        HashMap<String, List<String>> listQuery = new HashMap<>();
        listQuery.put("alias", new ArrayList<String>(Arrays.asList("the number")));

        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.requester.getPath()).withQueryStringParameters(listQuery)
        ).respond(
                response().withStatusCode(200).withBody(QueuesRequesterTest.aTestQueueList)
        );

        QueueList ql = this.requester.get(qsf);
        QueueList orig = new QueueList("ACCOUNTID", "AUTHTOKEN", QueuesRequesterTest.aTestQueueList);
        assertThat(ql.getTotalSize(), is(orig.getTotalSize()));
        assertThat(ql.getLocalSize(), is(orig.getLocalSize()));
    }

    @Then("^get a Queue by its queueId$")
    public void getQueueById() throws Throwable {
        String queueId = "QUc82cf641d98e785b8e65a894e4563a899e52f000";
        Helper.getMockServer().when(
                request().withMethod("GET").withPath(this.requester.getPath() + "/" + queueId)
        ).respond(
                response().withStatusCode(200).withBody(QueuesRequesterTest.aTestQueue)
        );

        Queue q = this.requester.get(queueId);
        Queue orig = Queue.fromJson(QueuesRequesterTest.aTestQueue);
        assertTrue(q.equals(orig));
    }

    @Then("^update a queue$")
    public void updateQueue() throws Throwable {
        String queueId = "QUc82cf641d98e785b8e65a894e4563a899e52f000";
        QueueUpdateOptions options = new QueueUpdateOptions();
        options.setAlias("test alias");
        options.setMaxSize(12);

        Helper.getMockServer().when(
                request().withMethod("POST").withPath(this.requester.getPath() + "/" + queueId)
        ).respond(
                response().withStatusCode(200).withBody(QueuesRequesterTest.anUpdatedTestQueue)
        );

        Queue q = this.requester.update(queueId, options);
        Queue orig = Queue.fromJson(QueuesRequesterTest.anUpdatedTestQueue);
        assertTrue(q.equals(orig));

    }

    @Then("^create a queue$")
    public void createQueue() throws Throwable {
        Helper.getMockServer().when(
                request().withMethod("POST").withPath(this.requester.getPath())
        ).respond(
                response().withStatusCode(200).withBody(QueuesRequesterTest.aTestQueue)
        );

        Queue q = this.requester.create();
        Queue orig = Queue.fromJson(QueuesRequesterTest.aTestQueue);
        assertTrue(q.equals(orig));
    }

    @Then("^create a queue with options$")
    public void createQueueWithOptions() throws Throwable {
        QueueCreateOptions options = new QueueCreateOptions();
        options.setAlias("test alias");
        options.setMaxSize(12);
        Helper.getMockServer().when(
                request().withMethod("POST").withPath(this.requester.getPath())
        ).respond(
                response().withStatusCode(200).withBody(QueuesRequesterTest.anUpdatedTestQueue)
        );

        Queue q = this.requester.create(options);
        Queue orig = Queue.fromJson(QueuesRequesterTest.anUpdatedTestQueue);
        assertTrue(q.equals(orig));
    }

    @Then("^create a MembersRequester$")
    public void createMembersRequester() throws Throwable {
        String queueId = "QUc82cf641d98e785b8e65a894e4563a899e52f000";
        MembersRequester mr = this.requester.getMembersRequester(queueId);
        assertThat(mr.getPath(), is(this.requester.getPath() + "/" + queueId + "/Members"));
    }
}
