Feature: Testing to the bookings service

  Scenario: Acceso exitoso
    Given the user has an account
    When validate user credentials
      | username | password    |
      | admin    | password123 |
    And validate response code "200"
    Then Then validate user access

  Scenario: List all ids bookings
    Given list ids
    When show the list of ids
    And validate response code booking "200"


  Scenario: Show reservations
    Given list reservation with id="25573"
    When show booking information
    And validate response code booking reserve "200"

  @test
  Scenario: Create new reservation
      #que el usuario no hyaa creado una reserva
    Given the user has not created a reservation
    When register reservation data
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | wELSER    | Cubas    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |
    Then validate response code booking created "200"
    And verify the response body contains the bookingid

  @test
  Scenario: Updates a current booking
    Given Que exista una reserva
    When Actualizar datos de una reserva
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | wELSER    | Cubas    | 120        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |
    Then Validar condigo de respuesta "200"
    And Mostrar reserva actualizada


  Scenario: Partial Update Booking
    Given Que exista una reserva
    When Actualizar algunos datos de una reserva
      | firstname | lastname |
      | Renato    | Cabezas  |
    Then Validar condigo de respuesta "200"
    And Mostrar reserva actualizada


    Scenario: Delete booking
      Given Que exista una reserva
      When Eliminar una reserva
      Then Validar condigo de respuesta "201"
      And Mostrar reserva eliminada


      Scenario: Ping - HealthCheck
      Given Que exista la api
      When Que funcione la api
        Then Validar condigo de respuesta "201"


