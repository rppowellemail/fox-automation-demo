package com.fox.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DefaultPage {
    WebDriver driver;

    public static By accountLink = By.xpath("//a[@href='/account']");

    public DefaultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void click_AccountLink() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(
//                ExpectedConditions.and(
//                        ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)),
//                        ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))
//                )
//        );
        WebElement webElement = driver.findElement(accountLink);
        webElement.click();
    }
}
