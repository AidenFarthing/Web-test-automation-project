Feature: Inventory
In order to be able to browse items
As a site vistor of the automation exercise website
I want to be able to see all of the products


  @Happy
  Scenario: Being able to filter the inventory on the product page
  Given I am on the inventory page
  When I can filter them by category (e.g.Women)
  Then  I can easily find the type of items I'm interested in.



  @Happy
  Scenario: Being able to search the inventory on the product page
  Given  I am on the inventory page
  When  I want to search for specific products using a search bar
  Then I can quickly find a particular item without manual browsing.
