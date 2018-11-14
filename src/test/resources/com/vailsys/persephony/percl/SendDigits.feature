Feature: SendDigits

	Scenario: Create a SendDigits
		Given a SendDigits command with digits 3425345
		Then check that digits equals 3425345 in SendDigits object
		Then check all optional fields in SendDigits are null

	Scenario: Create an non-empty SendDigits
		Given a SendDigits command with digits 3425345
		Then set SendDigits digits to 57483929
		Then check that digits equals 57483929 in SendDigits object
		Then set SendDigits pauseMs to 100
		Then check that pauseMs equals 100 in SendDigits object
		Then set SendDigits pauseMs to 500
		Then check that pauseMs equals 500 in SendDigits object
		Then set SendDigits pauseMs to 1000
		Then check that pauseMs equals 1000 in SendDigits object
