Feature: Client searches about specified item

  @search
  Scenario: search for specified item and add it to cart
    Given user has logged in 
    When user enters "laptop" in the search field and chose first laptop and change the quantity to "1" and add it to the cart
    Then the item will be "Added to Cart" successfully


