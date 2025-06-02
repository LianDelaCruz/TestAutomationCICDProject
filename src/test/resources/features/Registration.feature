Feature: User Registration
  As a new supporter
  I want to register on the Basketball England site
  So that I can access member-only content

  Background:
    Given I am on the registration page

  Scenario: Create user – everything goes as expected and an account is created
    When I fill in First Name with "Lian"
    And I fill in Last Name with "DC"
    And I fill in Date of Birth with "01/01/1990"
    And I fill in a unique Email address
    And I fill in Confirm Email as the same unique address
    And I fill in Password with "Password1234!"
    And I fill in Confirm Password with "Password1234!"
    And I accept the Terms and Conditions
    And I accept the Age Confirmation
    And I accept Communications Preferences
    And I accept the Code of Ethics
    And I submit the form
    Then I should see confirmation of successful registration

  Scenario: Create user – last name is missing
    When I fill in First Name with "Lian"
    And I leave Last Name blank
    And I fill in Date of Birth with "01/01/1990"
    And I fill in a unique Email address
    And I fill in Confirm Email as the same unique address
    And I fill in Password with "Password1234!"
    And I fill in Confirm Password with "Password1234!"
    And I accept the Terms and Conditions
    And I accept the Age Confirmation
    And I accept Communications Preferences
    And I accept the Code of Ethics
    And I submit the form
    Then I should see "Last Name is required" error for field "Surname"

  Scenario: Create user – password does not match
    When I fill in First Name with "Bob"
    And I fill in Last Name with "Smith"
    And I fill in Date of Birth with "01/01/1990"
    And I fill in a unique Email address
    And I fill in Confirm Email as the same unique address
    And I fill in Password with "Password1234!"
    And I fill in Confirm Password with "Password12345!"
    And I accept the Terms and Conditions
    And I accept the Age Confirmation
    And I accept Communications Preferences
    And I accept the Code of Ethics
    And I submit the form
    Then I should see "Password did not match" error for field "ConfirmPassword"

  Scenario: Create user – terms and conditions not accepted
    When I fill in First Name with "Alice"
    And I fill in Last Name with "Jones"
    And I fill in Date of Birth with "01/01/1990"
    And I fill in a unique Email address
    And I fill in Confirm Email as the same unique address
    And I fill in Password with "Password1234!"
    And I fill in Confirm Password with "Password1234!"
    And I accept the Age Confirmation
    And I accept Communications Preferences
    And I accept the Code of Ethics
    And I submit the form
    Then I should see "You must confirm that you have read and accepted our Terms and Conditions" error for field "TermsAccept"

