Feature: Filter
In order to be able to browse items
As a site vistor of the automation exercise website
I want to be able to see all of the products


  @Happy
  Scenario: Being able to filter the inventory on the product page
  Given I am on the inventory page
  When I can filter them by category (e.g.Women)
  Then  I can easily find the type of items I'm interested in.
