Feature: eu, como usuário do sistema preciso ter acesso aos meus dados de segurança.

  Scenario: Decriptacao de login
    Given I have a user jean and a password jotajota
    When I want to make the operation decript
    Then If the my operation should  return true