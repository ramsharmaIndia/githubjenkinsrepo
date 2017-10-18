Feature: To show demo feature with Scenario outline

  Scenario Outline: Title of your scenario outline
    Given I want to write a step with "<name>"
    When I check for the <value> in step
    Then I verify the "<status>" in step

    Examples: 
      | name  | value | status  |
      | Ram   |     5 | Success |
      | Shyam |     7 | Fail    |
