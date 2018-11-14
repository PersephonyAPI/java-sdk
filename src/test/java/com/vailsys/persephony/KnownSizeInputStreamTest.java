package com.vailsys.persephony;

import java.io.InputStream;
import java.io.ByteArrayInputStream;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class KnownSizeInputStreamTest {

	private byte[] byts;
	private InputStream in;
	private KnownSizeInputStream ksis;

	@Given("^an InputStream with ([0-9]+) bytes of data$")
	public void makeInputStream(int size) {
		this.byts = new byte[size];
		for(int i = 0; i < size; i++) {
			byts[i] = (byte)i;
		}
		this.in = new ByteArrayInputStream(this.byts);
	}
	
	@Then("^create a KnownSizeInputStream with the InputStream$")
	public void makeKnownSizeInputStream() {
		this.ksis = new KnownSizeInputStream(this.in, this.byts.length);
	}
	
	@Then("^check that the KnownSizeInputStream's size is ([0-9]+)$")
	public void checkLength(int size) {
		assertThat(this.ksis.size(), is(size));
	}
	
	@Then("^check that the underlying InputStream is the right stream$")
	public void checkUnderlyingStream() throws Throwable {
		int size = this.ksis.size();

		byte[] bytsA = new byte[size];

		this.ksis.read(bytsA,0,size);

		assertThat(bytsA, is(byts));
	}
	
}
