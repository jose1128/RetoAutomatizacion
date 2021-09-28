Feature: Register on the booking website
  As a user of the booking website
  I want to register on the site.
  Manage my trips

  Scenario: Successful Registration
    Given the user is in the registration option
    When enter email and password
    Then he will see the profile

