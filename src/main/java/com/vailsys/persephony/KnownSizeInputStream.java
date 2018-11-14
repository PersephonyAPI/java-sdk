package com.vailsys.persephony;

import java.io.InputStream;
import java.io.FilterInputStream;

/**
 * This class represents an otherwise normal {@link java.io.InputStream} but
 * the total size of the underlying data that is to be streamed is known. This
 * is used primarily by the Persephony SDK to stream the results of Persephony
 * API requests where the length of the data in the body of the response is
 * known. This allows for some nice shortcuts when reading all the returned
 * data is desirable.
 */
public class KnownSizeInputStream extends FilterInputStream {
	/** The size of the data which can be read from this stream */
	private Integer size;

	/**
	 * Pass in the existing {@link java.io.InputStream} and the size of the
	 * data which can be read from the stream.
	 *
	 * @param in The existing {@link java.io.InputStream}
	 * @param size the size of the underlying data, in bytes, at the source of the stream.
	 */
	public KnownSizeInputStream(InputStream in, int size) {
		super(in);
		this.size = size;
	}

	/**
	 * Retrieve the size of the data at the source of the stream.
	 *
	 * @return The size of the underlying data in bytes.
	 */
	public Integer size() {
		return size;
	}
}
