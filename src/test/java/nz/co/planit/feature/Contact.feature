Feature: This feature file covers scenarios related to contact feature of Jupiter Toys application

  Scenario: Validate error messages for Mandatory fields
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