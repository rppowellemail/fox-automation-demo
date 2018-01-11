package com.fox.automation;

import com.fox.automation.model.UserAccount;
import com.fox.automation.page.AccountPage;
import com.fox.automation.page.DefaultPage;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import util.SeleniumHandle;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CreateAccountWorkflow {

    public static void main(String[] args) {
        CreateAccountWorkflow createAccountWorkflow = new CreateAccountWorkflow();
        createAccountWorkflow.testCreateAccountHappyPath();
    }

    @Test
    public void testCreateAccountHappyPath() {
        String baseUrl ="https://www.fox.com";

        String testdatestring = UserAccount.generateDateString();
        UserAccount u = UserAccount.generateUserAccount(testdatestring);

        System.out.println("Create Account for: " +  u.getEmail() + " (" + u.getPassword() + ")");

        WebDriver driver = SeleniumHandle.getDriver();

        driver.get(baseUrl);

        DefaultPage defaultPage = new DefaultPage(driver);
        defaultPage.click_AccountLink();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.click_button_SignUp();

        // Check to see that we are at Account/Create A Profile

        //System.out.println("assert: Create a Profile");
        //assert(accountPage.findElement_Account_headerText().getText() == "Create a Profile");

        assertEquals("assert: Create a Profile", "Create a Profile", accountPage.findElement_Account_headerText().getText());

        accountPage.send_input_signupFirstName(u.getFirstname());
        accountPage.send_input_signupLastName(u.getLastname());
        accountPage.send_input_signupEmail(u.getEmail());
        accountPage.send_input_signupPassword(u.getPassword());

        accountPage.select_Gender(u.getGender());

        accountPage.send_input_birthdate(u.getBirthdateMonth() + u.getBirthdateDay() + u.getBirthdateYear());

        accountPage.click_button_CreateProfile();

        //System.out.println("assert: Thanks for Signing Up!");
        //assert( accountPage.getElement_Account_signupSuccessHeaderText().getText() == "Thanks for Signing Up!");

        assertEquals("Registration Complete Message - signupSuccessHeaderText", "Thanks for Signing Up!", accountPage.getElement_Account_signupSuccessHeaderText().getText());

        //System.out.println("assert: Begin your personalized viewing experience now.");
        //assert( accountPage.getElement_Account_signupSuccessText().getText() == "Begin your personalized viewing experience now.");
        assertEquals("Registration Complete Message - signupSuccessText", "Begin your personalized viewing experience now.", accountPage.getElement_Account_signupSuccessText().getText());

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotFilename = this.getClass().getSimpleName() + "-testCreateAccountHappyPath-screenshot-"+testdatestring+".png";
        System.out.println("Saving screenshot '" + screenshotFilename + "'");
        try {
            FileUtils.copyFile(scrFile, new File(screenshotFilename));

        } catch (IOException e) {
            e.printStackTrace();
        }

        accountPage.click_button_Done();

        driver.close();

        // TODO: SeleniumHandle tearDown();
        driver.quit();

    }
}
