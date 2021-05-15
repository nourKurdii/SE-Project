Feature: client Log in
   Background: Given user in the home page
@login
  Scenario: user wanna log in
    When user enters "noor.kurdi073@gmail.com" and "1234password"
    Then user will be switched to "Amazon.com:" main page

