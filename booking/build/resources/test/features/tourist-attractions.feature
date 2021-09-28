Feature: tourist attractions

  Scenario: book tour successfully
    Given the user navigate to Atracciones turísticas
    When the user reserves the attraction
      | attraction                        | destiny                     | adults | kids |
      | Tour por el Bosque de Chapultepec | Ciudad de México, México DF | 2      | 1    |
    Then the user will see the total price is 722.771,19 COP


  @priceFilter
  Scenario: validate price filter
    Given the user navigate to Atracciones turísticas
    And the user search the attraction in Ciudad de México, México DF
    When the user select the price filter COP 0 - COP 90.080 for tourist attractions
    Then the user will see tourist attractions with prices less than 90080