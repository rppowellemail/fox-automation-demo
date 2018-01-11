This project is a demo of using Java/Selenium to create a user account on https://www.com.fox.com


## To Run

Be sure to have the webdriver installed in location set by System property:

* `webdriver.chrome.driver` - for Chrome
* `webdriver.firefox.marionette` - for Firefox

(See `util/SeleniumHandle` for values)

The `CreateAccountWorkflow` uses the following `page` objects to search for webelement by id, name, and mostly xpath:

* `com.fox.automation.page.DefaultPage`
* `com.fox.automation.page.AccountPage`

A user account is created in the `testaCreateAccountHappyPath` method, asserting success message and saving a screenshot.


Run with the following:

```
gradle test
```


Verified working with the following configurations:

Selenium 3.8.1

* Firefox 35.0.1 - geckodriver-v0.19.1 - Mac OSX
* Chrome Version 63.0.3239.132 - chromdriver 2.35 - Mac OSX

