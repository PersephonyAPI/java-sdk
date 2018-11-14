package com.vailsys.persephony.api.message;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.nullValue;

public class MessagesSearchFiltersTest {
    private MessagesSearchFilters filters;

    @Given("^an empty MessagesSearchFilters object$")
    public void createFilters() {
        this.filters = new MessagesSearchFilters();
    }

    @Then("^check that all fields in MessagesSearchFilters are null$")
    public void checkAllFieldsAreNull() {
        assertThat(filters.getTo(), nullValue());
        assertThat(filters.getFrom(), nullValue());
        assertThat(filters.getBeginTime(), nullValue());
        assertThat(filters.getEndTime(), nullValue());
    }

    @Then("^set the MessagesSearchFilters to number to (.*)$")
    public void setTo(String to) {
        filters.setTo(to);
    }

    @Then("^check that the MessagesSearchFilters to number is (.*)$")
    public void checkTo(String value) {
        assertThat(this.filters.getTo(), is(value));
    }

    @Then("^set the MessagesSearchFilters from number to (.*)$")
    public void setFrom(String from) {
        filters.setFrom(from);
    }

    @Then("^check that the MessagesSearchFilters from number is (.*)$")
    public void checkFrom(String value) {
        assertThat(this.filters.getFrom(), is(value));
    }

    @Then("^set the MessagesSearchFilters beginTime to (.*)$")
    public void setBeginTime(String beginTime) {
        filters.setBeginTime(beginTime);
    }

    @Then("^check that the MessagesSearchFilters beginTime is (.*)$")
    public void checkBeginTime(String value) {
        assertThat(this.filters.getBeginTime(), is(value));
    }

    @Then("^set the MessagesSearchFilters endTime to (.*)$")
    public void setEndTime(String endTime) {
        filters.setEndTime(endTime);
    }

    @Then("^check that the MessagesSearchFilters endTime is (.*)$")
    public void checkEndTime(String value) {
        assertThat(this.filters.getEndTime(), is(value));
    }

    @Then("^set the MessagesSearchFilters direction to (.*)$")
    public void setDirection(String direction) {
        filters.setDirection(Direction.valueOf(direction.toUpperCase()));
    }

    @Then("^check that the MessagesSearchFilters direction is (.*)$")
    public void checkDirection(String value) {
        assertThat(this.filters.getDirection().toString(), is(value.toUpperCase()));
    }
}
