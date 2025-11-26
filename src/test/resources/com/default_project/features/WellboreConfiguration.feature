
@feature_wellbore_configuration
Feature: WellboreConfiguration

  Background: 
    Given the user is on the Wellbore Configuration tab

  @max_valid_value_test
  Scenario Outline: Validate Maximum Valid Values in Top MD and Bottom MD Fields
    Given the user selects the Drilled Hole tab
    When the user enters "<top_md>" in the Top MD field
    And the user enters "<bottom_md>" in the Bottom MD field
    And the user observes the state of the other fields in the row
    And the user saves the configuration
    And the user refreshes the page
    Then the previously entered data is displayed correctly

    Examples:
      | top_md    | bottom_md |
      | a * 1000  | a * 1000  |

  @minimum_valid_values
  Scenario Outline: Validate Minimum Valid Values in Top MD and Bottom MD Fields
    When the user selects the Drilled Hole tab
    And the user enters "<top_MD>" in the Top MD field
    And the user enters "<bottom_MD>" in the Bottom MD field
    And the user observes the state of the other fields in the row
    And the user saves the configuration
    And the user refreshes the page
    Then the previously entered data should be displayed correctly

    Examples:
      | top_MD | bottom_MD |
      | 0      | 0         |

  @validate_large_datasets
  Scenario Outline: Validate Large Datasets in Casing Tab
    When the user selects the Casing tab
    And the user adds 20 rows with valid data
    And the user adds additional rows until the system reaches its limit
    And the user observes the performance of the application
    And the user saves the configuration
    And the user refreshes the page
    Then the previously entered data is displayed correctly

    Examples:
      |   |

  @unusual_valid_combination
  Scenario Outline: Validate that the system can handle unusual valid combinations of values in the Casing tab without errors
    Given the user selects the Casing tab
    When the user enters unusual valid combinations in the Top MD field as "<top_md>"
    And the user enters unusual valid combinations in the Bottom MD field as "<bottom_md>"
    And the user enters valid data in the Length field as "<length>"
    Then the other fields in the row should be enabled for data entry
    And the user saves the configuration
    And the user refreshes the page
    Then the previously entered data should be displayed correctly

    Examples:
      | top_md     | bottom_md   | length |
      | 12345.67   | 54321.89    | 100    |

  @max-character-limits
  Scenario Outline: Validate Maximum Character Limits in Text Fields
    When the user selects the Casing tab
    And the user enters the maximum character limit "<casing>" in the Casing field
    And the user enters the maximum character limit "<grade>" in the Grade field
    And the user observes the state of the other fields in the row
    And the user saves the configuration
    And the user refreshes the page
    Then the data should be retained correctly

    Examples:
      | casing        | grade        |
      | a * 1000     | a * 1000     |

  @special-characters-validation
  Scenario Outline: Validate Special Characters in Text Fields
    Given the user is on the Wellbore Configuration tab
    When the user selects the Casing tab
    And the user enters "<casing>" in the Casing field
    And the user enters "<grade>" in the Grade field
    And the user observes the state of the other fields in the row
    And the user saves the configuration
    And the user refreshes the page
    Then the previously entered data is displayed correctly

    Examples:
      | casing       | grade       |
      | !@#$%^&*    | !@#$%^&*    |
