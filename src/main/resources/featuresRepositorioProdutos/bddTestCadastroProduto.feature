Feature: eu, como cliente ou funcionario preciso registrar o produto de um produto

  Scenario: cadastro do produto
    Given I have 3 by 10 by unit of the product Feijao Tropeiro
    When I want to make the operation register
    Then my operation should return true
