package com.vailsys.persephony.percl;

public class Pause extends PerCLCommand implements GetDigitsNestable, GetSpeechNestable {
	private Integer length;

	public Pause(Integer length) {
		this.setLength(length);
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getLength() {
		return this.length;
	}

}
