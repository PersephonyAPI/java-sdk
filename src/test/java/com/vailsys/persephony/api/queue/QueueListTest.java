package com.vailsys.persephony.api.queue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;

public class QueueListTest {
    private static String testQueue = "{\"uri\":\"/Accounts/AC6ae9421d4d7ca60c825b5e8f32d9aa225f79990f/Queues/QUc82cf641d98e785b8e65a894e4563a899e52f000\",\"dateCreated\":\"Thu, 13 Oct 2016 18:28:01 GMT\",\"dateUpdated\":\"Thu, 13 Oct 2016 18:28:01 GMT\",\"revision\":1, \"accountId\":\"AC6ae9421d4d7ca60c825b5e8f32d9aa225f79990f\", \"queueId\":\"QUc82cf641d98e785b8e65a894e4563a899e52f000\", \"alias\":\"other queue\", \"maxSize\":10, \"currentSize\":1, \"averageWaitTime\":0, \"subresourceUris\":{ \"members\":\"/Accounts/AC6ae9421d4d7ca60c825b5e8f32d9aa225f79990f/Queues/QUc82cf641d98e785b8e65a894e4563a899e52f000/Members\"}}";;
    private static String inputJson = "{\"total\": 1, \"start\": 0, \"end\": 0, \"page\": 0, \"numPages\": 1, \"pageSize\": 1, \"nextPageUri\": null, \"queues\": [" + QueueListTest.testQueue + "]}";

    private QueueList list;

    @Given("^a QueueList object$")
    public void makeListFromJson() throws Throwable {
        this.list = new QueueList("ACCOUNTID", "AUTHTOKEN", QueueListTest.inputJson);
    }

    @Then("^check that the QueueList was built correctly$")
    public void checkList(){
        assertThat(this.list.getLocalSize(), is(1));
    }
}
