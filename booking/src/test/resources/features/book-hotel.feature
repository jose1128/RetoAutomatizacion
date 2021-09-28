Feature: Book hotel
  I as a booking user
  I need to make a reservation and apply filters
  to find a good hotel

  @bookSuccessfully
  Scenario: book hotel successfully
    Given the user enters the reservation data
      | destination                 | departureDate | returnDate |
      | Jardín, Antioquia, Colombia | 2021-09-29    | 2021-09-30 |
    When the user reserves the hotel Sergeant Pepper
    Then the user will see the price COP 100.000 of the reservation

  @priceFilter
  Scenario: validate price filter
    Given the user enters the reservation data
      | destination                 | departureDate | returnDate |
      | Jardín, Antioquia, Colombia | 2021-09-29    | 2021-09-30 |
    When the user select the price filter COP 0 - COP 225,000 for Book hotel
    Then the user will see hotels with prices less than 225000

  @starsFilter
  Scenario: Validate stars filter
    Given the user enters the reservation data
      | destination                 | departureDate | returnDate |
      | Jardín, Antioquia, Colombia | 2021-09-29    | 2021-09-30 |
    When the user select the stars filter 3 estrellas
    Then the user will see hotels with 3 stars



