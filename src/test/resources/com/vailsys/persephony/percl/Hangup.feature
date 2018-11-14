Feature: Hangup

	Scenario: Create a default Hangup
		Given a Hangup
		Then check that the non-default fields are null in the Hangup object

	Scenario: Setting and checking Hangup fields
		Given a Hangup
		Then set callId to CA12345678901234567890123456789012345678AF in Hangup object
		Then check that callId is CA12345678901234567890123456789012345678AF in the Hangup object
		Then set reason to "This is the reason" in Hangup object
		Then check that reason is "This is the reason" in the Hangup object
