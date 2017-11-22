Feature: eu, como gerente preciso excluir dados referentes a venda

  Scenario: Exclusao do registro do venda
    Given sell 3 for price 12 of the Feijao Tropeiro
    When I want to make the operation delete
    Then my operation should return true
