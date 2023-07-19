@Cart
Feature: This feature file covers scenarios related to cart functionality of Jupiter Toys application

  @Testcase_3
  Scenario: [Testcase_3]: Verify subtotal, price and total value of products added to cart
    Given I am on the Jupiter Toys home page
    And I navigate to Shop page
    When I choose to buy the following products
      | Stuffed Frog   | 2        |
      | Fluffy Bunny   | 5        |
      | Valentine Bear | 3        |
    And I navigate to Cart page
    Then I validate the price displayed per product
    And I validate the subtotal per product
    And I validate the total amount ot be paid

