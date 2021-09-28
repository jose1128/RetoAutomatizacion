Feature: user register

  Scenario: register successfully
    Given the user navigate to Hazte una cuenta
    When user register in booking page with jose_1997@gmail.com and Jose12364558
    Then the user will see ¡Te damos la bienvenida a Booking.com! message