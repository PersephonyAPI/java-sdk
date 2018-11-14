package com.vailsys.persephony.api;

public class ThisIsABadIdeaException extends PersyException {
	public ThisIsABadIdeaException() {
		super("I recoginise that I shouldn't be using the thing that threw this exception, but I did it anyway.");
	}
}
