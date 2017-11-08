Feature: eu, como cliente ou funcionario preciso consultar meu login

  Scenario: Consulta de login
    Given I have a user jean and a password carlos12
    When I want to make the operation consult
    Then my operation should return true
