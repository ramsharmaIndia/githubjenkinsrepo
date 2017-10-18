Feature: Facebook Automation

  Scenario: Post something on facebook
    Given open "https://www.facebook.com"
    And login to facebook with correct credentials
    Then get some value from dataTable
      | key     | value |
      | name    | Ram   |
      | age     |    60 |
      | company | Abc   |
    And log out of facebook
