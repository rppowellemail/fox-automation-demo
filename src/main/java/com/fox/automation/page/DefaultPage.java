package com.fox.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DefaultPage {
    WebDriver driver;

    public DefaultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void click_AccountLink() {
        String xpath = "//a[@href='/account']";
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(
//                ExpectedConditions.and(
//                        ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)),
//                        ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))
//                )
//        );
        WebElement webElement = driver.findElement(By.xpath(xpath));
        webElement.click();
    }
}
