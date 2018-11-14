package com.vailsys.persephony.percl;

public class Play extends PerCLCommand implements GetDigitsNestable, GetSpeechNestable {
	private String file;
	private Integer loop;
	private String conferenceId;

	public Play(String file) {
		this.setFile(file);
	}

	public String getFile() {
		return this.file;
	}
	public Integer getLoop() {
		return this.loop;
	}
	public String getConferenceId() {
		return this.conferenceId;
	}

	public void setFile(String file) {
		this.file = file;
	}
	public void setLoop(Integer loop) {
		this.loop = loop;
	}
	public void setConferenceId(String conferenceId) {
		this.conferenceId = conferenceId;
	}
}
