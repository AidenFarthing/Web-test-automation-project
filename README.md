# AutomationTest.com Web Testing

## Goal of the Project
Automate web testing for a demo e-commerce site (AutomationTest.com) to validate key functional aspects:
- Homepage visibility and navigation
- Product discovery and cart management
- Checkout flow and payment mechanics
- Login and signup behaviors

The suite uses BDD-style scenarios in the gherkin format to create readable, useful tests. Prior to automation, exploratory testing was conducted to identify high-risk areas, uncover edge cases, and prioritize test coverage; more details on this can be found in the exploratory testing charters.

## How to Set Up The Test Framework
- Prerequisites:
  - Java 21
  - Maven 3.8+
  - Chrome browser installed
- Setup:
  - Clone the repository and open it in your IDE.
  - Ensure WebDriver binaries are auto-managed.
  - Optionally adjust serenity.properties for local/CI needs (e.g., headless).
- Run tests:
  - IDE: run the Serenity Cucumber test runner.
  - CLI: mvn clean verify

## What Was Tested
- Homepage
  - Visibility of main UI elements (slider, navigation, featured items)
  - Navigation to Products, Cart, Login, Contact Us
- Cart
  - Add a single item and verify quantity
  - Remove items and verify empty-cart message
  - Add multiple quantities of the same item
- Checkout
  - Purchase flow while already logged in
  - Login during checkout and complete purchase
  - Prevent submission without required payment details (blank fields)
- Login
  - Successful login with valid usernmae/password
  - Error messages for invalid credentials
  - Required field validation for blanks
  - Case sensitivity scenarios (defect tracking where applicable)
- Signup
  - Start signup flow and populate fields (happy path)

## Test Metrics
- Coverage
  - Journeys: Home, Cart, Checkout, Login, Signup
  - Page Objects: Home, Inventory, Product, Cart, Checkout, Payment, Login, Signup
- Scenario Tags
  - @Happy: Positive-path validations
  - @Sad: Negative-path validations
- Execution Artifacts
  - Serenity HTML report with step screenshots, timings, and traceability
  - Cucumber JSON/XML/HTML for CI dashboards
- Stability Aids
  - Popup/ad dismissal to reduce flakiness
  - Targeted waits and script-assisted interactions where necessary
- CI Readiness
  - Headless execution configurable via serenity.properties
  - Maven-friendly lifecycle for pipelines (clean verify)

Conclusion:
Numerous defects were identified throughout the test object, including impossible dates being allowed, numeric-only fields allowing alphanumeric inputs, options missing from dropdowns, and an inability to subtract from the quantity of an item in the cart without removing the item outright. Additionally, some issues were identified in terms of usability; the site often displays elements poorly, and some pop ups would be difficult to dismiss for those using screen readers. Further details can be found in the defect reports.