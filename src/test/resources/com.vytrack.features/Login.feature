@login
Feature: Login

  Scenario Outline: Positive login
    Given I am on a login page
    When I enter "<username>" and "<password>"
    Then I should be able to see the dashboard page

  Examples:
  | username        | password |
  | driver          | password |
  | sales manager   | password |
  | store manager   | password |

  Scenario Outline: Negative login
    Given I am on a login page
    When I enter "<username>" and "<password>"
    Then I shouldn't be able to see the dashboard page

    Examples:
      | username        | password |
      | driver          |          |
      |                 | password |
