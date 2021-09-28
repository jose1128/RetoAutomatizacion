Feature: Customer Support

  @ChatWithLogin
  Scenario: start chat without login
    Given the user is in the contact customer service option
    When user starts chat without logging in
    And enter the reservation data
    Then the user will be able to see the started chat


  @ChatWithoutLogin
  Scenario: start chat with login
    Given the user is in the contact customer service option
    When user starts chat with logging in
    And enter the reservation data
    Then the user will be able to see the started chat






