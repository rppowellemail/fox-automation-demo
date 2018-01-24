import time
from selenium import webdriver
from selenium.common.exceptions import NoSuchElementException

import sys
from os import path
sys.path.append( path.dirname( path.dirname( path.abspath(__file__) ) ) )

from pages.defaultpage import DefaultPage
from pages.accountpage import AccountPage

from models.useraccount import UserAccount

baseURL = "https://www.fox.com"


if __name__ == '__main__':

    chromedriver_fullname = path.join(path.dirname( path.dirname( path.abspath(__file__) ) ), 'chromedriver')
    webdriver = webdriver.Chrome(chromedriver_fullname)
    webdriver.set_page_load_timeout(30)
    webdriver.implicitly_wait(1)

    webdriver.get(baseURL)

    defaultpage = DefaultPage(webdriver)
    defaultpage.click_AccountLink()

    accountpage = AccountPage(webdriver)
    accountpage.click_button_SignUp()

    if (True):
        e = accountpage.findElement_Account_headerText()
        print(e)

    testdatestring = UserAccount.generateDateString()
    user = UserAccount.generateUserAccount(testdatestring)

    print(" ".join(("User:", user.firstname, user.lastname)))

    accountpage.send_input_signupFirstName(user.firstname)
    accountpage.send_input_signupLastName(user.lastname)
    accountpage.send_input_signupEmail(user.email)
    accountpage.send_input_signupPassword(user.password)
    accountpage.select_Gender(user.gender)
    accountpage.send_input_birthdate(user.birthdateMonth + user.birthdateDay + user.birthdateYear)

    accountpage.webdriver.save_screenshot(
        path.join(path.dirname( path.dirname( path.abspath(__file__) ) ), 'screenshot-' + testdatestring + '-001-before-submit.png')
    )

    accountpage.click_button_CreateProfile()

    accountpage.webdriver.save_screenshot(
        path.join(path.dirname( path.dirname( path.abspath(__file__) ) ), 'screenshot-' + testdatestring + '-002-after-submit.png')
    )

    print("get_element_Account_signupSuccessHeaderText()")
    try:
        accountpage.get_element_Account_signupSuccessHeaderText()
    except NoSuchElementException:
        print("get_element_Account_signupSuccessHeaderText() - NOT FOUND")

    print("get_element_Account_signupSuccessText()")
    try:
        accountpage.get_element_Account_signupSuccessText()
    except NoSuchElementException:
        print("get_element_Account_signupSuccessText() - NOT FOUND")

    print("get_element_Account_signupErrorGenericText()")
    try:
        element = accountpage.get_element_Account_signupErrorGenericText()
        print(element.text)
    except NoSuchElementException:
        pass

