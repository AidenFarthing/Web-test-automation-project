Feature: Cart

  In order to be able to buy items
  As visitor of the automation exercise website
  I want to be able add and remove items from the cart

  @Happy
  Scenario: Add item to cart and check cart value
    Given I am on the home page
    When I add an item to cart
    Then there should an item in my cart

  @Happy
  Scenario: Remove item from cart and check cart value
    Given I am on the home page
    And I have only one item in the cart
    When I remove the item from cart
    Then there should be no items in my cart

  @Happy
  Scenario: Add multiple of the same item to cart and check cart value
    Given I am on the home page
    When I add two of an item to cart
    Then there should 2 of that item in my cart

  @Happy
  Scenario: Remove multiple items from cart and check cart value
    Given I am on the home page
    And I have only two items in the cart
    When I remove the items from cart
    Then there should be no items in my cart


