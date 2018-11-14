Feature: ConferenceUpdateOptions

	Scenario: The ConferenceUpdateOptions constructor should ensure all the fields are null.
	Given An empty ConferenceUpdateOptions object.
	Then check that all ConferenceUpdateOptions fields are null.

	Scenario: The ConferenceUpdateOptions getters and setters should work.
	Given An empty ConferenceUpdateOptions object.
	Then set alias to confAlias in ConferenceUpdateOptions
	Then check that alias is confAlias in ConferenceUpdateOptions
	Then set playBeep to entryOnly in ConferenceUpdateOptions
	Then check that playBeep is entryOnly in ConferenceUpdateOptions
	Then set status to terminated in ConferenceUpdateOptions
	Then check that status is terminated in ConferenceUpdateOptions
