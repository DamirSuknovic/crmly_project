package com.crmly.pages;

import com.crmly.utilities.ConfigurationReader;
import com.crmly.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrmLyLoginPage {

    public CrmLyLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void loginType(String userType) {
        String username = "";
        String password = "";

        switch (userType) {
            case "Helpdesk":
                username = ConfigurationReader.getProperty("helpdesk_username");
                password = ConfigurationReader.getProperty("helpdesk_password");
                break;
            case "Marketing":
                username = ConfigurationReader.getProperty("marketing_username");
                password = ConfigurationReader.getProperty("marketing_password");
                break;
            case "HR":
                username = ConfigurationReader.getProperty("hr_username");
                password = ConfigurationReader.getProperty("hr_password");
                break;
            default:
                System.out.println("Invalid entry, please try again!");
        }
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        logInBtn.click();

    }

    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@name='USER_PASSWORD']")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement logInBtn;

//    public void login(String username, String password) {
//        inputUsername.sendKeys(username);
//        inputPassword.sendKeys(password);
//        logInBtn.click();
//    }


}
