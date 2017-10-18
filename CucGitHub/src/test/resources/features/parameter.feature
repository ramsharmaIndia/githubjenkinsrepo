Feature: Facebook Automation

  Scenario: Correct Login Check
    Given open "https://www.facebook.com"
    And login to facebook with correct credentials
    Then check that you have successfully logged in
    And log out of facebook

  Scenario: Incorrect login check
    Given open "https://www.facebook.com"
    And login to facebook with incorrect credentials
    Then check that you were not able to log in

  Scenario: Post something on facebook
    Given open "https://www.facebook.com"
    And login to facebook with correct credentials
    When open profile
    Then profile should be opened
    And log out of facebook
