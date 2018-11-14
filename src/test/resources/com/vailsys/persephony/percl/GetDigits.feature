Feature: GetDigits

	Scenario: Create a GetDigits
		Given a GetDigits command with actionUrl http://action.url/end/point
		Then check that actionUrl equals http://action.url/end/point in GetDigits object
		Then check all optional fields in GetDigits are null

	Scenario: Create an non-empty GetDigits
		Given a GetDigits command with actionUrl http://action.url/end/point
		Then set GetDigits actionUrl to http://take.some.action.com/end/point
		Then check that actionUrl equals http://take.some.action.com/end/point in GetDigits object
		Then set GetDigits initialTimeoutMs to 4500
		Then check that initialTimeoutMs equals 4500 in GetDigits object
		Then set GetDigits digitTimeoutMs to 3000
		Then check that digitTimeoutMs equals 3000 in GetDigits object
		Then set GetDigits finishOnKey to #
		Then check that finishOnKey equals # in GetDigits object
		Then set GetDigits minDigits to 10
		Then check that minDigits equals 10 in GetDigits object
		Then set GetDigits maxDigits to 300
		Then check that maxDigits equals 300 in GetDigits object
		Then set GetDigits flushBuffer to true
		Then check that flushBuffer equals true in GetDigits object
		Then set GetDigits prompts to empty list
		Then check that prompts equals empty list in GetDigits object

	Scenario: Check that GetDigits serializes properly
		Given a GetDigits command with actionUrl http://action.url/end/point
		Then set GetDigits prompts to a Say and Pause list
		Then check that the GetDigits command serializes properly

