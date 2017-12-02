Feature: eu, como funcionario preciso excluir um item de um produto

  Scenario: Exclusao do registro do item
    Given I have a plate that is composed by spaghetti by price 10
    When I want to make the operation delete
    Then my operation should return true
