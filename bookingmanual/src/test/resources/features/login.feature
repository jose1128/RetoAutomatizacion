Feature: login on booking webside
  As a user of the booking website
  I need to login
  to enjoy its content

  Background: common steps
    Given the user is in the login option

  @successfulLogin
  Scenario: Successful login
    When enter credentials
    Then he will see the profile

  @loginWithSocialNetworks
  Scenario Outline: login with <registrationOption>
    When the user logs in with <registrationOption>
    Then he will see the profile
    Examples: Data
      | registrationOption |
      | Facebook           |
      | Google             |
      | Apple              |

  @nonExistentAccount
  Scenario: non-existent account
    When enter credentials
    Then will display the account not exiting message

  @wrongCredentials
  Scenario: wrong credentials
    When enter credentials
    Then he will display a message of incorrect credentials



