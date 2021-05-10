Feature: sign Out

  Scenario: client wanna sign out
    Given user logs in
    When user hover on acount&lists button and press on sign out button
    Then user will be switched to "Amazon Sign-In" page
