Feature: eu, como cliente ou funcionario preciso alterar meu login

  Scenario: Alteracao de login
    Given I have a user jean and a password carlos12
    When I want to make the operation change
    Then my operation should return true
