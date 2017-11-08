Feature: eu, como cliente ou funcionario preciso excluir meu login

  Scenario: Exclusao de login
    Given I have a user jean and a password carlos12
    When I want to make the operation delete
    Then my operation should return true
