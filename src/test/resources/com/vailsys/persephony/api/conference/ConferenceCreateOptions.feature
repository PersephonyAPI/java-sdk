Feature: ConferenceCreateOptions

	Scenario: The ConferenceCreateOptions constructor should ensure all the fields are null.
	Given An empty ConferenceCreateOptions object.
	Then check that all ConferenceCreateOptions fields are null.

	Scenario: The ConferenceCreateOptions getters and setters should work.
	Given An empty ConferenceCreateOptions object.
	Then set alias to confAlias in ConferenceCreateOptions
	Then check that alias is confAlias in ConferenceCreateOptions
	Then set playBeep to exitOnly in ConferenceCreateOptions
	Then check that playBeep is exitOnly in ConferenceCreateOptions
	Then set record to true in ConferenceCreateOptions
	Then check that record is true in ConferenceCreateOptions
	Then set statusCallbackUrl to http://www.persephony.com/statusCallback in ConferenceCreateOptions
	Then check that statusCallbackUrl is http://www.persephony.com/statusCallback in ConferenceCreateOptions
	Then set waitUrl to http://www.persephony.com/wait in ConferenceCreateOptions
	Then check that waitUrl is http://www.persephony.com/wait in ConferenceCreateOptions
