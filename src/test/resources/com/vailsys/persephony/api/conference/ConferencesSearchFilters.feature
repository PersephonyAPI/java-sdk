Feature: ConferencesSearchFilters

	Scenario: Create a ConferencesSearchFilters object
		Given an empty ConferencesSearchFilters object
		Then check that all fields in ConferencesSearchFilters are null

	Scenario: Set/Get the status field
		Given an empty ConferencesSearchFilters object
		Then set the ConferencesSearchFilters status field to terminated
		Then check that the ConferencesSearchFilters status field is terminated

	Scenario: Set/Get the alias field
		Given an empty ConferencesSearchFilters object
		Then set the ConferencesSearchFilters alias field to confAlias
		Then check that the ConferencesSearchFilters alias field is confAlias

	Scenario: Set/Get the dateCreated field
		Given an empty ConferencesSearchFilters object
		Then set the ConferencesSearchFilters dateCreated field to 2016-11-01
		Then check that the ConferencesSearchFilters dateCreated field is 2016-11-01
		Then set the ConferencesSearchFilters dateCreated field to 2017-12-02 as a date
		Then check that the ConferencesSearchFilters dateCreated field is 2017-12-02
		Then check that the ConferencesSearchFilters dateCreated field is 2017-12-02 as a date

	Scenario: Set/Get the dateUpdated field
		Given an empty ConferencesSearchFilters object
		Then set the ConferencesSearchFilters dateUpdated field to 2016-11-02
		Then check that the ConferencesSearchFilters dateUpdated field is 2016-11-02
		Then set the ConferencesSearchFilters dateUpdated field to 2017-12-03 as a date
		Then check that the ConferencesSearchFilters dateUpdated field is 2017-12-03
		Then check that the ConferencesSearchFilters dateUpdated field is 2017-12-03 as a date

