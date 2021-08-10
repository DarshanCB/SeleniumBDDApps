Feature: Login Netflix web application for the valid user

  Scenario: Login netflix web application with valid user name and password

    Given Launch chrome browser
    When Input valid email "darshancbeceng@gmail.com"
    Then Click on the getstarted button
    Then Input valid password "**qwER1234##"
    When Next button should be displayed
    Then Click on the next button
    When Choose your plan page should open "Choose your plan."
    Then Click on next button again
    Then Planning page should open "Choose the plan that’s right for you"
    And Close browser


