Feature: eu, como gerente preciso registrar as vendas do estabelecimento

  Scenario: cadastro do venda
    Given sell 3 for price 12 of the Feijao Tropeiro
    When I want to make the operation register
    Then my operation should return true
