Feature: eu, como gernete preciso verificar se as vendas existem

  Scenario: O venda existe?
    Given sell 3 for price 12 of the Feijao Tropeiro
    When I want to make the operation consult
    Then my operation should return true
