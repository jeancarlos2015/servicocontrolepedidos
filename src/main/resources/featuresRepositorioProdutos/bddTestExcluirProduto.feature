Feature: eu, como cliente ou funcionario preciso excluir um produto de um produto

  Scenario: Exclusao do registro do produto
    Given I have 3 by 10 by unit of the product Feijao Tropeiro
    When I want to make the operation delete
    Then my operation should return true
