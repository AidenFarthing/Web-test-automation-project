Feature: Checkout
  In order to be able to buy items
  As visitor of the automation exercise website
  I want to be able add and remove items from the cart

  @Happy
  Scenario: Checkout by buying an item
  Given I am on the home page
  And I am logged in
  And have added an item to the cart
  When I click proceed to checkout
  And I click place order
  And I enter the card details and click submit
  Then I should see confirmation of purchase