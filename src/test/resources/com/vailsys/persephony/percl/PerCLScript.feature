Feature: PerCLScript

	Scenario: Requires that a command can be added to a script
		Given an empty PerCLScript
		Then check that a command can be added to the script

	Scenario: Requires that a script can be converted to JSON
		Given an empty PerCLScript
		Then add a command to the script
		Then add a command to the script
		Then add a command to the script
		Then add a command to the script
		Then check that the script can be converted to JSON

