package com.vailsys.persephony.percl;

import java.util.LinkedList;

/**
 * GetDigits represents the {@code GetDigits} PerCL command. See the GetDigits
 * PerCL documentation for details.
 */
public class GetDigits extends PerCLCommand {

	private String actionUrl;
	private Integer initialTimeoutMs;
	private Integer digitTimeoutMs;
	private FinishOnKey finishOnKey;
	private Integer minDigits;
	private Integer maxDigits;
	private Boolean flushBuffer;
	private LinkedList<GetDigitsNestable> prompts;

	public GetDigits(String actionUrl) {
		this.setActionUrl(actionUrl);
	}

	public String getActionUrl() {
		return this.actionUrl;
	}
	
	public Integer getInitialTimeoutMs() {
		return this.initialTimeoutMs;
	}
	
	public Integer getDigitTimeoutMs() {
		return this.digitTimeoutMs;
	}
	
	/**
	 * @see com.vailsys.persephony.percl.FinishOnKey
	 * @return The key to press to signal the end of digit collection.
	 */
	public FinishOnKey getFinishOnKey() {
		return this.finishOnKey;
	}
	
	public Integer getMinDigits() {
		return this.minDigits;
	}
	
	public Integer getMaxDigits() {
		return this.maxDigits;
	}
	
	public Boolean getFlushBuffer() {
		return this.flushBuffer;
	}
	
	public LinkedList<GetDigitsNestable> getPrompts() {
		return this.prompts;
	}
	
	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}
	
	public void setInitialTimeoutMs(Integer initialTimeoutMs) {
		this.initialTimeoutMs = initialTimeoutMs;
	}
	
	public void setDigitTimeoutMs(Integer digitTimeoutMs) {
		this.digitTimeoutMs = digitTimeoutMs;
	}
	
	/**
	 * @see com.vailsys.persephony.percl.FinishOnKey
	 * @param finishOnKey The key to press to signal the end of digit collection.
	 */
	public void setFinishOnKey(FinishOnKey finishOnKey) {
		this.finishOnKey = finishOnKey;
	}
	
	public void setMinDigits(Integer minDigits) {
		this.minDigits = minDigits;
	}
	
	public void setMaxDigits(Integer maxDigits) {
		this.maxDigits = maxDigits;
	}
	
	public void setFlushBuffer(Boolean flushBuffer) {
		this.flushBuffer = flushBuffer;
	}
	
	public void setPrompts(LinkedList<GetDigitsNestable> prompts) {
		this.prompts = prompts;
	}
}
