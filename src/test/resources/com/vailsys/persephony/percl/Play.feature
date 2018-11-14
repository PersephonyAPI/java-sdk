Feature: Play

	Scenario: Create a default Play
		Given a Play with file http://file.loc/aFile.wav
		Then check that file is http://file.loc/aFile.wav in the Play object
		Then check that the non-default fields are null in the Play object

	Scenario: Setting and checking Play fields
		Given a Play with file http://file.loc/aFile.wav
		Then set file to http://file.loc/aDifferentFile.wav in Play object
		Then check that file is http://file.loc/aDifferentFile.wav in the Play object
		Then set loop to 5 in Play object
		Then check that loop is 5 in the Play object
		Then set conferenceId to CF1234567890123456789012345678901234567890 in Play object
		Then check that conferenceId is CF1234567890123456789012345678901234567890 in the Play object
