package com.vailsys.persephony.percl;

public class RecordUtterance extends PerCLCommand {
	private String actionUrl;
	private Integer silenceTimeoutMs;
	private FinishOnKey finishOnKey;
	private Integer maxLengthSec;
	private Boolean playBeep;
	private Boolean autoStart;

	public RecordUtterance(String actionUrl) {
		this.setActionUrl(actionUrl);
	}

	public String getActionUrl() {
		return this.actionUrl;
	}

	public Integer getSilenceTimeoutMs() {
		return this.silenceTimeoutMs;
	}

	/**
	 * @see com.vailsys.persephony.percl.FinishOnKey
	 * @return The key when pressed that will end the recording of the utterance.
	 */
	public FinishOnKey getFinishOnKey() {
		return this.finishOnKey;
	}
	public Integer getMaxLengthSec() {
		return this.maxLengthSec;
	}
	public Boolean getPlayBeep() {
		return this.playBeep;
	}
	public Boolean getAutoStart() {
		return this.autoStart;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	public void setSilenceTimeoutMs(Integer silenceTimeoutMs) {
		this.silenceTimeoutMs = silenceTimeoutMs;
	}
	/**
	 * @param finishOnKey The key to press to signal that recording should stop.
	 * @see com.vailsys.persephony.percl.FinishOnKey
	 */
	public void setFinishOnKey(FinishOnKey finishOnKey) {
		this.finishOnKey = finishOnKey;
	}
	public void setMaxLengthSec(Integer maxLengthSec) {
		this.maxLengthSec = maxLengthSec;
	}
	public void setPlayBeep(Boolean playBeep) {
		this.playBeep = playBeep;
	}
	public void setAutoStart(Boolean autoStart) {
		this.autoStart = autoStart;
	}
}
