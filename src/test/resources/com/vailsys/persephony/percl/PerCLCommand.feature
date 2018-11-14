Feature: PerCLCommand

	Scenario: Requires a JSON representation of the command
		Given a TestCommand which is a PerCLCommand
		Then check that it can be converted to JSON

