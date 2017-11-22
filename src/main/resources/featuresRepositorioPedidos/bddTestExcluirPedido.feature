Feature: eu, como cliente ou funcionario preciso excluir um pedido de um produto

  Scenario: Exclusao do registro do pedido
    Given I have a pedido with preco 20 and status pendente
    When I want to make the operation delete
    Then my operation should return true
