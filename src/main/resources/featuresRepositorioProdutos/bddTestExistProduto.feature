Feature: eu, como funcionario ou cliente preciso verificar a existência de um produto

  Scenario: O produto existe?
    Given I have 3 by 10 by unit of the product Feijao Tropeiro
    When I want to make the operation consult
    Then my operation should return true
