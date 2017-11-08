Feature: eu, como usuário do sistema quero criptografar meus dados de segurança
  Scenario: Encriptacao de login
    Given I have a user jean and a password senhasenha
    When I want to make the operation encript
    Then If the my operation should  return true