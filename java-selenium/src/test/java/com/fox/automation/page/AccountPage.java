package com.fox.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void click_button_SignUp() {
        By By_SignUpButton = By.xpath("//button[text()='Sign Up']");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.presenceOfElementLocated(By_SignUpButton),
                        ExpectedConditions.visibilityOfElementLocated(By_SignUpButton)
                )
        );
        WebElement webElement = driver.findElement(By_SignUpButton);
        webElement.click();

    }

    public WebElement findElement_Account_headerText() {
        /**
         *
         * Find WebElement for Account_textHeader
         *
         * Note: class is different for different sizes:
         *  * Account_headerTextDesktop_
         *  * Account_headerText_
         *
         */
        By By_Account_headerText = By.xpath("//div[starts-with(@class, 'Account_headerText')]");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By_Account_headerText));
        List<WebElement> elements =  driver.findElements(By_Account_headerText);
        return elements.get(1);
    }

    public WebElement find_Account_container() {
        String xpath = "//div[@class]";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))
                )
        );
        WebElement webElement = driver.findElement(By.xpath(xpath));
        return webElement;
    }

    public void send_input_signupFirstName(String firstname) {
        WebElement webElement=driver.findElement(By.name("signupFirstName"));
        webElement.sendKeys(firstname);
    }

    public void send_input_signupLastName(String firstname) {
        WebElement webElement=driver.findElement(By.name("signupLastName"));
        webElement.sendKeys(firstname);
    }

    public void send_input_signupEmail(String firstname) {
        WebElement webElement=driver.findElement(By.name("signupEmail"));
        webElement.sendKeys(firstname);
    }

    public void send_input_signupPassword(String firstname) {
        WebElement webElement=driver.findElement(By.name("signupPassword"));
        webElement.sendKeys(firstname);
    }

    public void select_Gender(String gender) {
        /**
         * Here is where things get tricky - the 'Gender' is a dynamic/javascript dropdown - click it once to reveal options
         */

        //String xpath ="//a[text()='Gender']";
        String dropdown_xpath = "//div[starts-with(@class, 'Account_signupBirthdayGenderContainer_')]/div/div/div/div/a";

        WebElement webElement = driver.findElement(By.xpath(dropdown_xpath));
        webElement.click();

        /**
         * Now find/iterate through options to build HashMap
         */
        String options_xpath = "//div[starts-with(@class, 'Account_signupBirthdayGenderContainer_')]/div/div/div[2]/a/div";
        List<WebElement> elements = driver.findElements(By.xpath(options_xpath));

        HashMap<String, WebElement> genderOptions = new HashMap<String, WebElement>();

        for (WebElement element : elements) {
            // System.out.println("gender_selection:" + element.getText() + " -> " + element);
            genderOptions.put(element.getText(), element);
        }

        /**
         * Find and select the option
         */
        webElement = genderOptions.get(gender);
        webElement.click();
    }


    public void send_input_birthdate(String birthdate) {
        String xpath= "//input[@placeholder='Birthdate']";
        WebElement webElement = driver.findElement(By.xpath(xpath));
        webElement.sendKeys(birthdate);
    }


    public void click_button_CreateProfile() {
        String xpath = "//button[text()='Create Profile']";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))
                )
        );
        WebElement webElement = driver.findElement(By.xpath(xpath));
        webElement.click();
    }

    public WebElement getElement_Account_signupSuccessHeaderText() {
        String xpath = "//div[starts-with(@class, 'Account_signupSuccessHeaderText')]";
        WebElement webElement = driver.findElement(By.xpath(xpath));
        return webElement;
    }

    public WebElement getElement_Account_signupSuccessText() {
        String xpath = "//div[starts-with(@class, 'Account_signupSuccessText')]";
        WebElement webElement = driver.findElement(By.xpath(xpath));
        return webElement;
    }

    public WebElement getElement_Account_signupErrorGenericText() {
        String xpath = "//div[starts-with(@class, 'Account_signupErrorGenericText_')]";
        WebElement webElement = driver.findElement(By.xpath(xpath));
        return webElement;

    }

    public void click_button_Done() {
        String xpath = "//button[text()='Done']";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))
                )
        );
        WebElement webElement = driver.findElement(By.xpath(xpath));
        webElement.click();
    }
}
