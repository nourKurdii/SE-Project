Feature: empty the cart

  Scenario: client wanna delete one item that he added
    Given user logs in and one item is already added to the cart
    When user opens the cart and presses delete button
    Then cart quantity will be "0"
