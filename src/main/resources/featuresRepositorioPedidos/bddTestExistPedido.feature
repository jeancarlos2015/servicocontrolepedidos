Feature: eu, como funcionario ou cliente preciso verificar a existência de um pedido

  Scenario: O pedido existe?
    Given I have a pedido with preco 20 and status pendente
    When I want to make the operation consult
    Then my operation should return true
