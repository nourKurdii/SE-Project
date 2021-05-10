Feature: automate menu

  Background: Given user in home page

  Scenario: user wanna go to computer components from the menu
    When user press on menu and choose "Computers" submenu
    Then the forth item in Computers list will be "Computer Components"
