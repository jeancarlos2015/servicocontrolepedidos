Feature: eu, como cliente ou funcionario preciso registrar o pedido de um produto

  Scenario: cadastro do pedido
    Given I have a pedido with preco 20 and status pendente
    When I want to make the operation register
    Then my operation should return true
