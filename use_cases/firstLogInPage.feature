Feature: client Log in
   Background: Given user in the home page

  Scenario: user wanna log in
    When user enters "s11821365@stu.najah.edu" and "1234password"
    Then user will be switched to "Amazon.com:" main page

