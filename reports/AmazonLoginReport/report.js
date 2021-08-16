$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/loginPage.feature");
formatter.feature({
  "name": "Login to Amazon E-Commerce portal with user name and password",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "Common Steps",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Launch chrome browser chrome",
  "keyword": "Given "
});
formatter.match({
  "location": "loginPage.launch_chrome_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Set the english language",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.set_english_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on the login page and login page of the Amazon portal should open \"Sign-In\"",
  "keyword": "When "
});
formatter.match({
  "location": "loginPage.clickLoginPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login with valid user name and password",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Input the valid user name \"darshancbeceng@gmail.com\"",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.validUserName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Input the valid password \"**qwER1234##\"",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.validPassword(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on the login button to open the amazon and Validate the user \"Hello, Darshan\"",
  "keyword": "And "
});
formatter.match({
  "location": "loginPage.clickLoginbuttonValidateUser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.closeBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Login with valid user name and password",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Input the valid user name \u003cusername\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "Input the valid password \u003cpassword\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "Click on the login button to open the amazon and Validate the user \u003cuser\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "user"
      ]
    },
    {
      "cells": [
        "\"darshancbeceng@gmail.com\"",
        "\"**qwER1234##\"",
        "\"Hello, Darshan\""
      ]
    },
    {
      "cells": [
        "\"darshancbeceng1993@gmail.com\"",
        "\"**qwER1234##\"",
        "\"Hello, DarshanCB\""
      ]
    }
  ]
});
formatter.background({
  "name": "Common Steps",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Launch chrome browser chrome",
  "keyword": "Given "
});
formatter.match({
  "location": "loginPage.launch_chrome_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Set the english language",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.set_english_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on the login page and login page of the Amazon portal should open \"Sign-In\"",
  "keyword": "When "
});
formatter.match({
  "location": "loginPage.clickLoginPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login with valid user name and password",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Input the valid user name \"darshancbeceng@gmail.com\"",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.validUserName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Input the valid password \"**qwER1234##\"",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.validPassword(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on the login button to open the amazon and Validate the user \"Hello, Darshan\"",
  "keyword": "And "
});
formatter.match({
  "location": "loginPage.clickLoginbuttonValidateUser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.closeBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "Common Steps",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Launch chrome browser chrome",
  "keyword": "Given "
});
formatter.match({
  "location": "loginPage.launch_chrome_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Set the english language",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.set_english_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on the login page and login page of the Amazon portal should open \"Sign-In\"",
  "keyword": "When "
});
formatter.match({
  "location": "loginPage.clickLoginPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login with valid user name and password",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Input the valid user name \"darshancbeceng1993@gmail.com\"",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.validUserName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Input the valid password \"**qwER1234##\"",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.validPassword(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on the login button to open the amazon and Validate the user \"Hello, DarshanCB\"",
  "keyword": "And "
});
formatter.match({
  "location": "loginPage.clickLoginbuttonValidateUser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.closeBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Login with invalid user name and password",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Input the invalid username \u003cinvalusername\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "validate the error message \"We cannot find an account with that e-mail address\"",
  "keyword": "Then "
});
formatter.step({
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "invalusername"
      ]
    },
    {
      "cells": [
        "\"admin4566778@gmail.com\""
      ]
    },
    {
      "cells": [
        "\"admin12353636@gmail.com\""
      ]
    }
  ]
});
formatter.background({
  "name": "Common Steps",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Launch chrome browser chrome",
  "keyword": "Given "
});
formatter.match({
  "location": "loginPage.launch_chrome_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Set the english language",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.set_english_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on the login page and login page of the Amazon portal should open \"Sign-In\"",
  "keyword": "When "
});
formatter.match({
  "location": "loginPage.clickLoginPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login with invalid user name and password",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Input the invalid username \"admin4566778@gmail.com\"",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.invaliduser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate the error message \"We cannot find an account with that e-mail address\"",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.validateerrormsg(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.closeBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "Common Steps",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Launch chrome browser chrome",
  "keyword": "Given "
});
formatter.match({
  "location": "loginPage.launch_chrome_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Set the english language",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.set_english_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on the login page and login page of the Amazon portal should open \"Sign-In\"",
  "keyword": "When "
});
formatter.match({
  "location": "loginPage.clickLoginPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login with invalid user name and password",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Input the invalid username \"admin12353636@gmail.com\"",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.invaliduser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate the error message \"We cannot find an account with that e-mail address\"",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.validateerrormsg(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.closeBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Login with valid user name and invalid password",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Input the valid user name \u003cvalusername\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "Input the invalid password \u003cinvalpassword\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "Validate password error message \"There was a problem\"",
  "keyword": "And "
});
formatter.step({
  "name": "Validate password error \"Your password is incorrect\"",
  "keyword": "And "
});
formatter.step({
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "valusername",
        "invalpassword"
      ]
    },
    {
      "cells": [
        "\"darshancbeceng@gmail.com\"",
        "\"345367889\""
      ]
    },
    {
      "cells": [
        "\"darshancbeceng1993@gmail.com\"",
        "\"536377889\""
      ]
    }
  ]
});
formatter.background({
  "name": "Common Steps",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Launch chrome browser chrome",
  "keyword": "Given "
});
formatter.match({
  "location": "loginPage.launch_chrome_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Set the english language",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.set_english_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on the login page and login page of the Amazon portal should open \"Sign-In\"",
  "keyword": "When "
});
formatter.match({
  "location": "loginPage.clickLoginPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login with valid user name and invalid password",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Input the valid user name \"darshancbeceng@gmail.com\"",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.validUserName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Input the invalid password \"345367889\"",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.invalidpassword(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate password error message \"There was a problem\"",
  "keyword": "And "
});
formatter.match({
  "location": "loginPage.passwordErrormsg(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate password error \"Your password is incorrect\"",
  "keyword": "And "
});
formatter.match({
  "location": "loginPage.errorpassword(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.closeBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "Common Steps",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Launch chrome browser chrome",
  "keyword": "Given "
});
formatter.match({
  "location": "loginPage.launch_chrome_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Set the english language",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.set_english_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on the login page and login page of the Amazon portal should open \"Sign-In\"",
  "keyword": "When "
});
formatter.match({
  "location": "loginPage.clickLoginPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login with valid user name and invalid password",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Input the valid user name \"darshancbeceng1993@gmail.com\"",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.validUserName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Input the invalid password \"536377889\"",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.invalidpassword(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate password error message \"There was a problem\"",
  "keyword": "And "
});
formatter.match({
  "location": "loginPage.passwordErrormsg(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate password error \"Your password is incorrect\"",
  "keyword": "And "
});
formatter.match({
  "location": "loginPage.errorpassword(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "loginPage.closeBrowser()"
});
formatter.result({
  "status": "passed"
});
});