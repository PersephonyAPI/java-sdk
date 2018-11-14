Feature: PlayEarlyMedia

	Scenario: Create a default PlayEarlyMedia
		Given a PlayEarlyMedia with file http://file.loc/aFile.wav
		Then check that file is http://file.loc/aFile.wav in the PlayEarlyMedia object

	Scenario: Setting and checking PlayEarlyMedia fields
		Given a PlayEarlyMedia with file http://file.loc/aFile.wav
		Then set file to http://file.loc/aDifferentFile.wav in PlayEarlyMedia object
		Then check that file is http://file.loc/aDifferentFile.wav in the PlayEarlyMedia object
