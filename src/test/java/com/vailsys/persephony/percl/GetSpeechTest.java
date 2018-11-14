package com.vailsys.persephony.percl;

import java.util.LinkedList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;

public class GetSpeechTest {

	private GetSpeech command;

	@Given("^a GetSpeech command with actionUrl (.*), grammarFile (.*)$")
	public void makeTestCommand(String actionUrl, String grammarFile) {
		command = new GetSpeech(actionUrl, grammarFile);
	}

	@Then("^check all optional fields in GetSpeech are null$")
	public void checkAllAreNull() {
		assertThat(this.command.getGrammarRule(), nullValue());
		assertThat(this.command.getGrammarType(), nullValue());
		assertThat(this.command.getPlayBeep(), nullValue());
		assertThat(this.command.getNoInputTimeoutMs(), nullValue());
		assertThat(this.command.getRecognitionTimeoutMs(), nullValue());
		assertThat(this.command.getConfidenceThreshold(), nullValue());
		assertThat(this.command.getNBestListLength(), nullValue());
		assertThat(this.command.getSensitivityLevel(), nullValue());
		assertThat(this.command.getSpeechCompleteTimeoutMs(), nullValue());
		assertThat(this.command.getSpeechIncompleteTimeoutMs(), nullValue());
		assertThat(this.command.getPrompts(), nullValue());
	}

	@Then("^set GetSpeech actionUrl to (.*)$")
	public void setActionUrl(String actionUrl) {
		this.command.setActionUrl(actionUrl);
	}
	@Then("^set GetSpeech grammarType to (URL|BUILTIN)$")
	public void setGrammarType(String grammarType) {
		GrammarType gt;

		if(grammarType == "URL"){
			gt = GrammarType.URL;
		} else {
			gt = GrammarType.BUILTIN;
		}

		this.command.setGrammarType(gt);
	}
	@Then("^set GetSpeech grammarFile to (.*)$")
	public void setGrammarFile(String grammarFile) {
		this.command.setGrammarFile(grammarFile);
	}
	@Then("^set GetSpeech grammarRule to (.*)$")
	public void setGrammarRule(String grammarRule) {
		this.command.setGrammarRule(grammarRule);
	}
	@Then("^set GetSpeech playBeep to (true|false)$")
	public void setPlayBeep(Boolean playBeep) {
		this.command.setPlayBeep(playBeep);
	}
	@Then("^set GetSpeech noInputTimeoutMs to (\\d+)$")
	public void setNoInputTimeoutMs(Integer noInputTimeoutMs) {
		this.command.setNoInputTimeoutMs(noInputTimeoutMs);
	}
	@Then("^set GetSpeech recognitionTimeoutMs to (\\d+)$")
	public void setRecognitionTimeoutMs(Integer recognitionTimeoutMs) {
		this.command.setRecognitionTimeoutMs(recognitionTimeoutMs);
	}
	@Then("^set GetSpeech confidenceThreshold to (\\d+\\.\\d+)$")
	public void setConfidenceThreshold(Float confidenceThreshold) {
		this.command.setConfidenceThreshold(confidenceThreshold);
	}
	@Then("^set GetSpeech nBestListLength to (\\d+)$")
	public void setNBestListLength(Integer nBestListLength) {
		this.command.setNBestListLength(nBestListLength);
	}
	@Then("^set GetSpeech sensitivityLevel to (\\d+\\.\\d+)$")
	public void setSensitivityLevel(Float sensitivityLevel) {
		this.command.setSensitivityLevel(sensitivityLevel);
	}
	@Then("^set GetSpeech speechCompleteTimeoutMs to (\\d+)$")
	public void setSpeechCompleteTimeoutMs(Integer speechCompleteTimeoutMs) {
		this.command.setSpeechCompleteTimeoutMs(speechCompleteTimeoutMs);
	}
	@Then("^set GetSpeech speechIncompleteTimeoutMs to (\\d+)$")
	public void setSpeechIncompleteTimeoutMs(Integer speechIncompleteTimeoutMs) {
		this.command.setSpeechIncompleteTimeoutMs(speechIncompleteTimeoutMs);
	}
	@Then("^set GetSpeech prompts to an empty list$")
	public void setPrompts() {
		this.command.setPrompts(new LinkedList<GetSpeechNestable>());
	}

	@Then("^set GetSpeech prompts to a Say and Pause list$")
	public void setPromptsFull(){
		LinkedList<GetSpeechNestable> prompts = new LinkedList<>();
		Say say = new Say("test");
		Pause pause = new Pause(100);
		prompts.add(say);
		prompts.add(pause);
		this.command.setPrompts(prompts);
	}

	@Then("^check that actionUrl equals (.*) in GetSpeech object$")
	public void getActionUrl(String actionUrl) {
		assertThat(this.command.getActionUrl(), is(actionUrl));
	}
	@Then("^check that grammarType equals (URL|BUILTIN) in GetSpeech object$")
	public void getGrammarType(String grammarType) {
		GrammarType gt;

		if(grammarType == "URL"){
			gt = GrammarType.URL;
		} else {
			gt = GrammarType.BUILTIN;
		}

		assertThat(this.command.getGrammarType(), is(gt));
	}
	@Then("^check that grammarFile equals (.*) in GetSpeech object$")
	public void getGrammarFile(String grammarFile) {
		assertThat(this.command.getGrammarFile(), is(grammarFile));
	}
	@Then("^check that grammarRule equals (.*) in GetSpeech object$")
	public void getGrammarRule(String grammarRule) {
		assertThat(this.command.getGrammarRule(), is(grammarRule));
	}
	@Then("^check that playBeep equals (true|false) in GetSpeech object$")
	public void getPlayBeep(Boolean playBeep) {
		assertThat(this.command.getPlayBeep(), is(playBeep));
	}
	@Then("^check that noInputTimeoutMs equals (\\d+) in GetSpeech object$")
	public void getNoInputTimeoutMs(Integer noInputTimeoutMs) {
		assertThat(this.command.getNoInputTimeoutMs(), is(noInputTimeoutMs));
	}
	@Then("^check that recognitionTimeoutMs equals (\\d+) in GetSpeech object$")
	public void getRecognitionTimeoutMs(Integer recognitionTimeoutMs) {
		assertThat(this.command.getRecognitionTimeoutMs(), is(recognitionTimeoutMs));
	}
	@Then("^check that confidenceThreshold equals (\\d+\\.\\d+) in GetSpeech object$")
	public void getConfidenceThreshold(Float confidenceThreshold) {
		assertThat(this.command.getConfidenceThreshold(), is(confidenceThreshold));
	}
	@Then("^check that nBestListLength equals (\\d+) in GetSpeech object$")
	public void getNBestListLength(Integer nBestListLength) {
		assertThat(this.command.getNBestListLength(), is(nBestListLength));
	}
	@Then("^check that sensitivityLevel equals (\\d+\\.\\d+) in GetSpeech object$")
	public void getSensitivityLevel(Float sensitivityLevel) {
		assertThat(this.command.getSensitivityLevel(), is(sensitivityLevel));
	}
	@Then("^check that speechCompleteTimeoutMs equals (\\d+) in GetSpeech object$")
	public void getSpeechCompleteTimeoutMs(Integer speechCompleteTimeoutMs) {
		assertThat(this.command.getSpeechCompleteTimeoutMs(), is(speechCompleteTimeoutMs));
	}
	@Then("^check that speechIncompleteTimeoutMs equals (\\d+) in GetSpeech object$")
	public void getSpeechIncompleteTimeoutMs(Integer speechIncompleteTimeoutMs) {
		assertThat(this.command.getSpeechIncompleteTimeoutMs(), is(speechIncompleteTimeoutMs));
	}
	@Then("^check that prompts equals an empty list in GetSpeech object$")
	public void getPrompts() {
		assertThat(this.command.getPrompts(), is(new LinkedList<GetSpeechNestable>()));
	}

	@Then("^check that the GetSpeech command serializes properly$")
	public void checkSerial(){
		String serialized = this.command.toJson();
		assertThat(serialized, is("{\"GetSpeech\":{\"actionUrl\":\"http://action.url/end/point\",\"grammarFile\":\"/path/to/grammar/File\",\"prompts\":[{\"Say\":{\"text\":\"test\"}},{\"Pause\":{\"length\":100}}]}}"));
	}
}
