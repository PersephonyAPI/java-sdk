package com.vailsys.persephony.percl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class EnqueueTest {
    private Enqueue command;

    @Given("^an Enqueue object with queueId (.*) and actionUrl (.*)$")
    public void createEnqueue(String queueId, String actionUrl) {
        this.command = new Enqueue(queueId, actionUrl);
    }

    @Then("^check all optional fields in Enqueue are null$")
    public void checkNull(){
        assertThat(this.command.getNotificationUrl(), nullValue());
        assertThat(this.command.getWaitUrl(), nullValue());
    }

    @Then("^set the Enqueue (queueId|actionUrl|waitUrl|notificationUrl) to (.*)$")
    public void setValue(String type, String value){
        if(type.equals("queueId")){
            this.command.setQueueId(value);
        } else if(type.equals("actionUrl"))
        {
            this.command.setActionUrl(value);
        } else if(type.equals("waitUrl")) {
            this.command.setWaitUrl(value);
        } else if(type.equals("notificationUrl")) {
            this.command.setNotificationUrl(value);
        }

    }

    @Then("^check that the Enqueue (queueId|actionUrl|waitUrl|notificationUrl) is (.*)$")
    public void checkValue(String type, String value){
        if(type.equals("queueId")){
            assertThat(this.command.getQueueId(), is(value));
        } else if(type.equals("actionUrl")) {
            assertThat(this.command.getActionUrl(), is(value));
        } else if (type.equals("waitUrl")){
            assertThat(this.command.getWaitUrl(), is(value));
        } else if (type.equals("notificationUrl")) {
            assertThat(this.command.getNotificationUrl(), is(value));
        }
    }




}
