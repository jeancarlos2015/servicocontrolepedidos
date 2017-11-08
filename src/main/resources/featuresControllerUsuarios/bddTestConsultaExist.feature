Feature: eu, como cliente ou funcionario preciso saber se o meu login existe

  Scenario: Verificar se o usuario e senha existe
    Given I have a user jean and a password carlos12
    When I want to make the operation exist
    Then my operation should return true
