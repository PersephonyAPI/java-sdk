Feature: KnownSizeInputStream

	Scenario: Creating a KnownSizeInputStream
		Given an InputStream with 10 bytes of data
		Then create a KnownSizeInputStream with the InputStream
		Then check that the KnownSizeInputStream's size is 10
		Then check that the underlying InputStream is the right stream
