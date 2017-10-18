@basic
Feature: Facebook Automation

	@basic @basiccorrectlogin
  Scenario: Correct Login Check
    Given open facebook
    And login to facebook with correct credentials
    Then check that you have successfully logged in
    And log out of facebook

	@basic @basicincorrectlogin
  Scenario: Incorrect login check
    Given open facebook
    And login to facebook with incorrect credentials
    Then check that you were not able to log in
    
	@basic @basicpost
  Scenario: Post something on facebook
    Given open facebook
    And login to facebook with correct credentials
    When open profile
    Then profile should be opened
    And log out of facebook