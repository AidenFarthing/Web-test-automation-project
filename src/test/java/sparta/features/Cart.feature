Feature: Cart


  In order to be able to buy items
  As visitor of the automation exercise website
  I want to be able add and remove items from the cart

  @Happy
  Scenario: Add item to cart and check cart value
    Given I am on the products page
    When I add an item to cart
    Then there should an item in my cart

  @Happy
  Scenario: Remove item from cart and check cart value
    Given I am on the products page
    And I have only one item in the cart
    When remove the item from cart
    Then there should no items in my cart
