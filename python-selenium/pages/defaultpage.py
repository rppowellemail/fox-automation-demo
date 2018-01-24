# -*- coding: utf-8 -*-

from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class DefaultPage:
    def __init__(self, webdriver):
        self.webdriver = webdriver

    def click_AccountLink(self):
        xpath = "//a[@href='/account']"
        element = self.webdriver.find_element_by_xpath(xpath)
        element.click()

