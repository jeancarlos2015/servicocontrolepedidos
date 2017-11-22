Feature: eu, como funcionário preciso ser capaz de registrar um cliente

  Scenario: cadastro do cliente
    Given I have a cliente with name pedro and cpf 1234123412
    When I want to make the operation register
    Then my operation should return true
