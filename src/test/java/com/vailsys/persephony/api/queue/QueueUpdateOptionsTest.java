package com.vailsys.persephony.api.queue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;

public class QueueUpdateOptionsTest {

    QueueUpdateOptions options;

    @Given("^An empty QueueUpdateOptions object.$")
    public void createQueueUpdateOptions() { this.options = new QueueUpdateOptions();}

    @Then("^check that all QueueUpdateOptions fields are null.$")
    public void checkNull(){
        assertThat(this.options.getAlias(), nullValue());
        assertThat(this.options.getMaxSize(), nullValue());
    }

    @Then("^set alias to (.*) in QueueUpdateOptions$")
    public void setAlias(String alias){
        this.options.setAlias(alias);
    }

    @Then("^check that alias is (.*) in QueueUpdateOptions$")
    public void getAlias(String alias) {
        assertThat(this.options.getAlias(), is(alias));
    }

    @Then("^set maxSize to (.*) in QueueUpdateOptions$")
    public void setMaxSize(String size){
        this.options.setMaxSize(Integer.parseInt(size));
    }

    @Then("^check that maxSize is (.*) in QueueUpdateOptions$")
    public void getMaxSize(String size){
        assertThat(this.options.getMaxSize(), is(Integer.parseInt(size)));
    }
}
