Feature: Register on the booking website
  As a user of the booking website
  I want to register on the site.
  Manage my trips

  Background: common steps
    Given the user is in the registration option

  @successfulRegistration
  Scenario: Successful Registration
    When enter email and password
    Then he will see the profile

  @registrationWithSocialNetworks
  Scenario Outline: Registration with <registrationOption>
    When the user registers with <registrationOption>
    Then he will see the profile
    Examples: data
      | registrationOption |
      | Facebook           |
      | Google             |
      | Apple              |

  @wrongPasswordConfirmation
  Scenario: wrong password confirmation
    When enter email and password
    Then you may see a password information message that does not match

  @existingAccount
  Scenario: existing account
    When enter email and password
    Then the user will be able to see an existing account message


