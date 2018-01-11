package com.fox.automation;

import com.fox.automation.model.UserAccount;
import com.fox.automation.page.AccountPage;
import com.fox.automation.page.DefaultPage;
import com.fox.automation.util.SeleniumHandle;
import org.openqa.selenium.WebDriver;

public class CreateAccountWorkpath {

    public static void main(String[] args) {
        CreateAccountWorkpath createAccountWorkpath = new CreateAccountWorkpath();
        createAccountWorkpath.doCreateAccount();
    }

    public void doCreateAccount() {
        String baseUrl ="https://www.fox.com";

        UserAccount u = UserAccount.generateUserAccount(UserAccount.generateDateString());

        System.out.println("Create Account for: " +  u.getEmail() + " (" + u.getPassword() + ")");

        WebDriver driver = SeleniumHandle.getDriver();

        driver.get(baseUrl);

        DefaultPage defaultPage = new DefaultPage(driver);
        defaultPage.click_AccountLink();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.click_button_SignUp();

        // Check to see that we are at Account/Create A Profile

        System.out.println("assert: Create a Profile");
        assert (accountPage.findElement_Account_headerText().getText() == "Create a Profile");


        accountPage.send_input_signupFirstName(u.getFirstname());
        accountPage.send_input_signupLastName(u.getLastname());
        accountPage.send_input_signupEmail(u.getEmail());
        accountPage.send_input_signupPassword(u.getPassword());

        accountPage.select_Gender(u.getGender());

        accountPage.send_input_birthdate(u.getBirthdateMonth() + u.getBirthdateDay() + u.getBirthdateYear());

        accountPage.click_button_CreateProfile();

        System.out.println("assert: Thanks for Signing Up!");
        assert( accountPage.getElement_Account_signupSuccessHeaderText().getText() == "Thanks for Signing Up!");

        System.out.println("assert: Begin your personalized viewing experience now.");
        assert( accountPage.getElement_Account_signupSuccessText().getText() == "Begin your personalized viewing experience now.");

        accountPage.click_button_Done();

        //driver.close();
        //driver.quit();

    }
}
