# -*- coding: utf-8 -*-

from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class AccountPage:
    def __init__(self, webdriver):
        self.webdriver = webdriver

    def click_button_SignUp(self):
        xpath = "//button[text()='Sign Up']";
        wait = WebDriverWait(self.webdriver, 10)
        wait.until(EC.presence_of_element_located((By.XPATH, xpath)))
        wait = WebDriverWait(self.webdriver, 10)
        wait.until(EC.visibility_of_element_located((By.XPATH, xpath)))
        element = self.webdriver.find_element_by_xpath(xpath)
        element.click()

    def findElement_Account_headerText(self):
        # Account_headerTextDesktop_1IzPi
        #
        xpath ="//div[starts-with(@class, 'Account_headerText')]";
        wait = WebDriverWait(self.webdriver, 10)
        wait.until(EC.presence_of_element_located((By.XPATH, xpath)))
        element = self.webdriver.find_element_by_xpath(xpath)
        return element

    def send_input_signupFirstName(self, firstname):
        element = self.webdriver.find_element_by_name("signupFirstName")
        element.send_keys(firstname)

    def send_input_signupLastName(self, lastname):
        element = self.webdriver.find_element_by_name("signupLastName")
        element.send_keys(lastname)

    def send_input_signupEmail(self, email):
        element = self.webdriver.find_element_by_name("signupEmail")
        element.send_keys(email)

    def send_input_signupPassword(self, password):
        element = self.webdriver.find_element_by_name("signupPassword")
        element.send_keys(password)

    def select_Gender(self, gender):

        gender_dropdown_xpath = "//div[starts-with(@class, 'Account_signupBirthdayGenderContainer_')]/div/div/div/div/a"

        gender_dropdown = self.webdriver.find_element_by_xpath(gender_dropdown_xpath)
        gender_dropdown.click();

        options_xpath = "//div[starts-with(@class, 'Account_signupBirthdayGenderContainer_')]/div/div/div[2]/a/div"
        gender_dropdown_elements = self.webdriver.find_elements_by_xpath(options_xpath)
        gender_options = {}
        for gender_dropdown_element in gender_dropdown_elements:
            print(gender_dropdown_element.text + " -> " + str(gender_dropdown_element))
            gender_options[gender_dropdown_element.text] = gender_dropdown_element
        gender_options[gender].click()

    def send_input_birthdate(self, birthdate):
        xpath= "//input[@placeholder='Birthdate']"
        element = self.webdriver.find_element_by_xpath(xpath)
        element.send_keys(birthdate)

    def click_button_CreateProfile(self):
        xpath = "//button[text()='Create Profile']"
        wait = WebDriverWait(self.webdriver, 10)
        wait.until(EC.presence_of_element_located((By.XPATH, xpath)))
        wait = WebDriverWait(self.webdriver, 10)
        wait.until(EC.visibility_of_element_located((By.XPATH, xpath)))
        element = self.webdriver.find_element_by_xpath(xpath)
        element.click()

    def get_element_Account_signupSuccessHeaderText(self):
        xpath = "//div[starts-with(@class, 'Account_signupSuccessHeaderText')]"
        element = self.webdriver.find_element_by_xpath(xpath)
        return element

    def get_element_Account_signupSuccessText(self):
        xpath = "//div[starts-with(@class, 'Account_signupSuccessText')]"
        element = self.webdriver.find_element_by_xpath(xpath)
        return element

    def get_element_Account_signupErrorGenericText(self):
        xpath = "//div[starts-with(@class, 'Account_signupErrorGenericText_')]"
        element = self.webdriver.find_element_by_xpath(xpath)
        return element

    def click_button_Done(self):
        xpath = "//button[text()='Done']"
        wait = WebDriverWait(self.webdriver, 10)
        wait.until(EC.presence_of_element_located((By.XPATH, xpath)))
        wait = WebDriverWait(self.webdriver, 10)
        wait.until(EC.visibility_of_element_located((By.XPATH, xpath)))
        element = self.webdriver.find_element_by_xpath(xpath)
        element.click()

