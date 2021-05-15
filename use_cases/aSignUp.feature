Feature: sign Up

  @tag1
  Scenario: user wanna create an account
    Given user in the websites home page
    When user open sign-in page and click on create amazon account button and enter name "Nour" and mail "noor.kurdi073@gmail.com" and password "1234password" country "PS" phone "598116160" then click create buton
    Then account will be created and user will be switched to "Amazon.com" page
