Feature: eu, como item ou funcionario preciso registrar o item de um produto

  Scenario: cadastro do item
    Given I have a plate that is composed by spaghetti by price 10
    When I want to make the operation register
    Then my operation should return true
