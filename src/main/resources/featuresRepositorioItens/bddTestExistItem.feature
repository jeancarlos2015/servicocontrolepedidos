Feature: eu, como funcionario preciso verificar a existência de um item

  Scenario: O item existe?
    Given I have a plate that is composed by spaghetti by price 10
    When I want to make the operation consult
    Then my operation should return true
