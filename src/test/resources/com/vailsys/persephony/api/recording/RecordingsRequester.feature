@Mockserver
Feature: RecordingsRequester

	Scenario: Can create a RecordingsRequester
		Given a RecordingsRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
		Then check the acting accountId in the RecordingsRequester is AC1234567890123456789012345678901234567890
		Then check the path in the RecordingsRequester is /Accounts/AC1234567890123456789012345678901234567890/Recordings
		
	Scenario: Delete a recording
		Given a RecordingsRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
		Then delete a recording with id RE1234567890123456789012345678901234567890

	Scenario: Get recording meta information
		Given a RecordingsRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
		Then get a recording with id RE1234567890123456789012345678901234567890
		Then get a list of all recordings
		Then get a list of recordings based on filters

	Scenario: Download a recording
		Given a RecordingsRequester with the credentials AC1234567890123456789012345678901234567890 and 1234567890123456789012345678901234567890 and using the accountId AC1234567890123456789012345678901234567890
		Then download a recording with id RE1234567890123456789012345678901234567890 using a Path
		Then download a recording with id RE1234567890123456789012345678901234567890 using a File 
		Then download a recording with id RE1234567890123456789012345678901234567890 using a String
		Then download a recording with id RE1234567890123456789012345678901234567890 into a byte array
