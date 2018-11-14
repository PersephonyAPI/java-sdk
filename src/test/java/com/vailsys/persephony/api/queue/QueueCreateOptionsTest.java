package com.vailsys.persephony.api.queue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class QueueCreateOptionsTest {
    QueueCreateOptions options;

    @Given("^An empty QueueCreateOptions object.$")
    public void createQueueCreateOptions() { this.options = new QueueCreateOptions();}

    @Then("^check that all QueueCreateOptions fields are null.$")
    public void checkFieldsAreNull(){
        assertThat(options.getAlias(), nullValue());
        assertThat(options.getMaxSize(), nullValue());
    }

    @Then("^set alias to (.*) in QueueCreateOptions$")
    public void setAlias(String alias) {
        options.setAlias(alias);
    }

    @Then("^check that alias is (.*) in QueueCreateOptions$")
    public void getAlias(String alias){
        assertThat(options.getAlias(), is(alias));
    }

    @Then("^set maxSize to (.*) in QueueCreateOptions$")
    public void setMaxSize(String size){
        options.setMaxSize(Integer.parseInt(size));
    }

    @Then("^check that maxSize is (.*) in QueueCreateOptions$")
    public void getMaxSize(String size){
        assertThat(options.getMaxSize(), is(Integer.parseInt(size)));
    }
}
