@Web @Contact
Feature: This feature file covers scenarios related to contact functionality of Jupiter Toys application

  @Testcase_1
  Scenario: [Testcase_1]: Validate error messages for Mandatory fields
    Given I am on the Jupiter Toys home page
    And I navigate to Contact page
    When I submit the form with the following values
      | field | value |

    Then I should get the following error messages
      | Forename | Forename is required |
      | Email    | Email is required    |
      | Message  | Message is required  |
    When I submit the form with the following values
      | field    | value                       |
      | Forename | Vipin                       |
      | Email    | vipinmisra23@gmail.com      |
      | Message  | This is a sample test form. |
    Then I should not get any error messages

  @Testcase_2
  Scenario Outline: [Testcase_2]: Validate successful submission messages on providing all mandatory field values
    Given I am on the Jupiter Toys home page
    And I navigate to Contact page
    When I submit the form with the following values
      | field    | value                       |
      | Forename | Vipin                       |
      | Email    | vipinmisra23@gmail.com      |
      | Message  | This is a sample test form. |
    Then I should see the successful submission message like Thanks <forename>, we appreciate your feedback.

    Examples:
      | runs |
      | 1    |
      | 2    |
      | 3    |
      | 4    |
      | 5    |