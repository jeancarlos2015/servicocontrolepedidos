Feature: eu, como cliente ou funcionario preciso excluir o registro do cliente

  Scenario: Exclusao do registro do cliente
    Given I have a cliente with name joao and cpf 1234123412
    When I want to make the operation delete
    Then my operation should return true
