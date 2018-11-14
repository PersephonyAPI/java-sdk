package com.vailsys.persephony.percl;

import com.google.gson.annotations.SerializedName;

/**
 *	This enum holds several values representing the keys on a standard phone
 *	number pad. This is meant to be used as the value for the 
 *	{@code finishOnKey} field with a {@code GetDigits} command.
 */
public enum FinishOnKey {
	@SerializedName("1")
	ONE,
	@SerializedName("2")
	TWO,
	@SerializedName("3")
	THREE,
	@SerializedName("4")
	FOUR,
	@SerializedName("5")
	FIVE,
	@SerializedName("6")
	SIX,
	@SerializedName("7")
	SEVEN,
	@SerializedName("8")
	EIGHT,
	@SerializedName("9")
	NINE,
	@SerializedName("0")
	ZERO,
	@SerializedName("#")
	POUND,
	@SerializedName("*")
	STAR
}
