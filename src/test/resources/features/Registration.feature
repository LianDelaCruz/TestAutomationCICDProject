Feature: User Registration
  As a new supporter
  I want to register on the Basketball England site
  So that I can access member-only content

  Background:
    Given I am on the registration page

  Scenario: Create user – everything goes as expected and an account is created
    When I fill in First Name with "Lian"
    And I fill in Last Name with "DC"
    And I fill in Email with "lian@example.com"
    And I fill in Confirm Email with "lian@example.com"
    And I fill in Password with "Password1234!"
    And I fill in Confirm Password with "Password1234!"
    And I accept the Terms and Conditions
    And I accept the Age Confirmation
    And I accept Communications Preferences
    And I accept the Code of Ethics
    And I submit the form
    Then I should see confirmation of successful registration