package com.vailsys.persephony.api.application;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.lexer.Fi;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class ApplicationsUpdateOptionsTest {
    private ApplicationUpdateOptions options;

    @Given("^an empty ApplicationUpdateOptions object$")
    public void createApplicationUpdateOptions() { this.options = new ApplicationUpdateOptions();}

    @Then("^check that all ApplicationUpdateOptions fields are null$")
    public void checkNull(){
        assertThat(this.options.getAlias(), nullValue());
        assertThat(this.options.getVoiceUrl(), nullValue());
        assertThat(this.options.getVoiceFallbackUrl(), nullValue());
        assertThat(this.options.getCallConnectUrl(), nullValue());
        assertThat(this.options.getStatusCallbackUrl(), nullValue());
        assertThat(this.options.getSmsUrl(), nullValue());
        assertThat(this.options.getSmsFallbackUrl(), nullValue());
    }

    @Then("^set (alias|voiceUrl|voiceFallbackUrl|callConnectUrl|statusCallbackUrl|smsUrl|smsFallbackUrl) to (.*) in ApplicationUpdateOptions$")
    public void setField(String field, String value){
        if(field.equals("alias")){
            this.options.setAlias(value);
        }
        if(field.equals("voiceUrl")){
            this.options.setVoiceUrl(value);
        }
        if(field.equals("voiceFallbackUrl")){
            this.options.setVoiceFallbackUrl(value);
        }
        if(field.equals("callConnectUrl")){
            this.options.setCallConnectUrl(value);
        }
        if(field.equals("statusCallbackUrl")){
            this.options.setStatusCallbackUrl(value);
        }
        if(field.equals("smsUrl")){
            this.options.setSmsUrl(value);
        }
        if(field.equals("smsFallbackUrl")){
            this.options.setSmsFallbackUrl(value);
        }
    }

    @Then("^check that (alias|voiceUrl|voiceFallbackUrl|callConnectUrl|statusCallbackUrl|smsUrl|smsFallbackUrl) is (.*) in ApplicationUpdateOptions$")
    public void checkField(String field, String value){
        if(field.equals("alias")){
            assertThat(this.options.getAlias(), is(value));
        }
        if(field.equals("voiceUrl")){
            assertThat(this.options.getVoiceUrl(), is(value));
        }
        if(field.equals("voiceFallbackUrl")){
            assertThat(this.options.getVoiceFallbackUrl(), is(value));
        }
        if(field.equals("callConnectUrl")){
            assertThat(this.options.getCallConnectUrl(), is(value));
        }
        if(field.equals("statusCallbackUrl")){
            assertThat(this.options.getStatusCallbackUrl(), is(value));
        }
        if(field.equals("smsUrl")){
            assertThat(this.options.getSmsUrl(), is(value));
        }
        if(field.equals("smsFallbackUrl")){
            assertThat(this.options.getSmsFallbackUrl(), is(value));
        }
    }

}
