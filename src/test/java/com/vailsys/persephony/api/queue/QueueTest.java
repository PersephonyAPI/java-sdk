package com.vailsys.persephony.api.queue;

import com.google.common.reflect.TypeToken;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.lang.reflect.Type;
import java.util.HashMap;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static com.vailsys.persephony.json.PersyGson.gson;

public class QueueTest {
    private String origJSON;
    private String otherJSON = "{\"uri\":\"/Accounts/AC6ae9421d4d7ca60c825b5e8f32d9aa225f79990f/Queues/QUc82cf641d98e785b8e65a894e4563a899e52f000\",\"dateCreated\":\"Thu, 13 Oct 2016 18:28:01 GMT\",\"dateUpdated\":\"Thu, 13 Oct 2016 18:28:01 GMT\",\"revision\":1, \"accountId\":\"AC6ae9421d4d7ca60c825b5e8f32d9aa225f79990f\", \"queueId\":\"QUc82cf641d98e785b8e65a894e4563a899e52f000\", \"alias\":\"other queue\", \"maxSize\":10, \"currentSize\":1, \"averageWaitTime\":0, \"subresourceUris\":{ \"members\":\"/Accounts/AC6ae9421d4d7ca60c825b5e8f32d9aa225f79990f/Queues/QUc82cf641d98e785b8e65a894e4563a899e52f000/Members\"}}";
    private Queue theQueue;

    @Given("^Some JSON representing a queue$")
    public void storeJSON() {
        this.origJSON = "{\"uri\":\"/Accounts/AC6ae9421d4d7ca60c825b5e8f32d9aa225f79990f/Queues/QUc82cf641d98e785b8e65a894e4563a899e52f000\",\"dateCreated\":\"Thu, 13 Oct 2016 18:28:01 GMT\",\"dateUpdated\":\"Thu, 13 Oct 2016 18:28:01 GMT\",\"revision\":1, \"accountId\":\"AC6ae9421d4d7ca60c825b5e8f32d9aa225f79990f\", \"queueId\":\"QUc82cf641d98e785b8e65a894e4563a899e52f000\", \"alias\":\"the number\", \"maxSize\":100, \"currentSize\":1, \"averageWaitTime\":0, \"subresourceUris\":{ \"members\":\"/Accounts/AC6ae9421d4d7ca60c825b5e8f32d9aa225f79990f/Queues/QUc82cf641d98e785b8e65a894e4563a899e52f000/Members\"}}";
    }

    @Then("^build a Queue object from that JSON$")
    public void buildQueue() throws Throwable {
        this.theQueue = Queue.fromJson(origJSON);
    }

    @Then("^check the contents of the queue$")
    public void checkQueueAgainstJson() {
        Type t = new TypeToken<HashMap<String, Object>>() {
        }.getType();
        HashMap<String, Object> jsonMap = gson.fromJson(this.origJSON, t);

        assertThat(jsonMap.get("queueId").toString(), is(this.theQueue.getQueueId()));
        assertThat(jsonMap.get("alias").toString(), is(this.theQueue.getAlias()));
        assertThat((Integer) ((Double) jsonMap.get("currentSize")).intValue(), is(this.theQueue.getCurrentSize()));
        assertThat((Integer) ((Double) jsonMap.get("maxSize")).intValue(), is(this.theQueue.getMaxSize()));
        assertThat((Integer) ((Double) jsonMap.get("averageWaitTime")).intValue(), is(this.theQueue.getAverageWaitTime()));
        com.google.gson.internal.LinkedTreeMap mmm = (com.google.gson.internal.LinkedTreeMap) jsonMap.get("subresourceUris");
        assertThat(mmm.get("members").toString(), is(this.theQueue.getSubresourceUris().get("members")));
    }

    @Then("^check the queue is( not)? equal$")
    public void checkEqual(String not) throws Throwable {
        if (not == null) {
            assertTrue(this.theQueue.equals(Queue.fromJson(origJSON)));
        } else {
            assertFalse(this.theQueue.equals(Queue.fromJson(otherJSON)));
        }
    }

}
