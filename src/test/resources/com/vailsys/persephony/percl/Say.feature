Feature: Say

	Scenario: Create a default Say
		Given a Say with text http://text.loc/aText.wav
		Then check that text is http://text.loc/aText.wav in the Say object
		Then check that the non-default fields are null in the Say object

	Scenario: Setting and checking Say fields
		Given a Say with text http://text.loc/aText.wav
		Then set text to http://text.loc/aDifferentText.wav in Say object
		Then check that text is http://text.loc/aDifferentText.wav in the Say object
		Then set language to en-US in Say object
		Then check that language is en-US in the Say object
		Then set loop to 5 in Say object
		Then check that loop is 5 in the Say object
		Then set conferenceId to CF1234567890123456789012345678901234567890 in Say object
		Then check that conferenceId is CF1234567890123456789012345678901234567890 in the Say object
