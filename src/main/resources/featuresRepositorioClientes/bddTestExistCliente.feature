Feature: eu, como cliente ou funcionario preciso verificar a existência da conta do cliente

  Scenario: O cliente existe?
    Given I have a cliente with name joao and cpf 1234123412
    When I want to make the operation consult
    Then my operation should return true
