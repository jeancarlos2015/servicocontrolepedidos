Feature: eu, como cliente ou funcionario preciso registrar um login

  Scenario: cadastro de login
    Given I have a user marina and a password senhasenha
    When I want to make the operation register
    Then my operation should return true
