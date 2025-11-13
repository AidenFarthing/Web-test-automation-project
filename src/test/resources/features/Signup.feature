Feature: Signup

As a new user,
I want to enter my personal and address information after starting the signup process,
so that I can successfully create my account and access member features.

  @Happy
  Scenario: Create account
  Given I am on the signup page
  And I enter the name and email
  When I click signup
  And I input each field with the input
    | field          | input          |
    | Title          | Mrs.           |
    | Email          | 12345          |
    | Password       | 01/01/2000     |
    | DOB            | Jane           |
    | First name     | Doe            |
    | Address        | 1 Street       |
    | Country        | Canada         |
    | State          | State          |
    | City           | City           |
    | Zip code       | AB1 2CD        |
    | Mobile number  | 01234 567891   |
  And I click create account
  Then I should be taken to the home page