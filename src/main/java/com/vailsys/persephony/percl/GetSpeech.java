package com.vailsys.persephony.percl;

import java.util.LinkedList;


public class GetSpeech extends PerCLCommand {
	private String actionUrl;
	private GrammarType grammarType;
	private String grammarFile;
	private String grammarRule;
	private Boolean playBeep;
	private Integer noInputTimeoutMs;
	private Integer recognitionTimeoutMs;
	private Float confidenceThreshold;
	private Integer nBestListLength;
	private Float sensitivityLevel;
	private Integer speechCompleteTimeoutMs;
	private Integer speechIncompleteTimeoutMs;
	private LinkedList<GetSpeechNestable> prompts;

	public GetSpeech(String actionUrl, String grammarFile) {
		this.setActionUrl(actionUrl);
		this.setGrammarFile(grammarFile);
	}

	public String getActionUrl() {
		return this.actionUrl;
	}
	public GrammarType getGrammarType() {
		return this.grammarType;
	}
	public String getGrammarFile() {
		return this.grammarFile;
	}
	public String getGrammarRule() {
		return this.grammarRule;
	}
	public Boolean getPlayBeep() {
		return this.playBeep;
	}
	public Integer getNoInputTimeoutMs() {
		return this.noInputTimeoutMs;
	}
	public Integer getRecognitionTimeoutMs() {
		return this.recognitionTimeoutMs;
	}
	public Float getConfidenceThreshold() {
		return this.confidenceThreshold;
	}
	public Integer getNBestListLength() {
		return this.nBestListLength;
	}
	public Float getSensitivityLevel() {
		return this.sensitivityLevel;
	}
	public Integer getSpeechCompleteTimeoutMs() {
		return this.speechCompleteTimeoutMs;
	}
	public Integer getSpeechIncompleteTimeoutMs() {
		return this.speechIncompleteTimeoutMs;
	}
	public LinkedList<GetSpeechNestable> getPrompts() {
		return this.prompts;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}
	public void setGrammarType(GrammarType grammarType) {
		this.grammarType = grammarType;
	}
	public void setGrammarFile(String grammarFile) {
		this.grammarFile = grammarFile;
	}
	public void setGrammarRule(String grammarRule) {
		this.grammarRule = grammarRule;
	}
	public void setPlayBeep(Boolean playBeep) {
		this.playBeep = playBeep;
	}
	public void setNoInputTimeoutMs(Integer noInputTimeoutMs) {
		this.noInputTimeoutMs = noInputTimeoutMs;
	}
	public void setRecognitionTimeoutMs(Integer recognitionTimeoutMs) {
		this.recognitionTimeoutMs = recognitionTimeoutMs;
	}
	public void setConfidenceThreshold(Float confidenceThreshold) {
		this.confidenceThreshold = confidenceThreshold;
	}
	public void setNBestListLength(Integer nBestListLength) {
		this.nBestListLength = nBestListLength;
	}
	public void setSensitivityLevel(Float sensitivityLevel) {
		this.sensitivityLevel = sensitivityLevel;
	}
	public void setSpeechCompleteTimeoutMs(Integer speechCompleteTimeoutMs) {
		this.speechCompleteTimeoutMs = speechCompleteTimeoutMs;
	}
	public void setSpeechIncompleteTimeoutMs(Integer speechIncompleteTimeoutMs) {
		this.speechIncompleteTimeoutMs = speechIncompleteTimeoutMs;
	}
	public void setPrompts(LinkedList<GetSpeechNestable> prompts) {
		this.prompts = prompts;
	}
}
