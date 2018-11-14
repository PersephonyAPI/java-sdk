package com.vailsys.persephony.percl;

public class Say extends PerCLCommand implements GetDigitsNestable, GetSpeechNestable {
	private String text;
	private String language;
	private Integer loop;
	private String conferenceId;

	public Say(String text) {
		this.setText(text);
	}

	public String getText() {
		return this.text;
	}
	public String getLanguage() {
		return this.language;
	}
	public Integer getLoop() {
		return this.loop;
	}
	public String getConferenceId() {
		return this.conferenceId;
	}

	public void setText(String text) {
		this.text = text;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setLoop(Integer loop) {
		this.loop = loop;
	}
	public void setConferenceId(String conferenceId) {
		this.conferenceId = conferenceId;
	}
}
