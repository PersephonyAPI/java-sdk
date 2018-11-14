Feature: Pause

	Scenario: Create a default Pause
		Given a Pause with length 3300
		Then check that length is 3300 in the Pause object

	Scenario: Setting and checking Pause fields
		Given a Pause with length 3300
		Then set length to 4400 in Pause object
		Then check that length is 4400 in the Pause object