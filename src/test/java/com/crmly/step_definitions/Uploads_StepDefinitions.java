package com.crmly.step_definitions;

import com.crmly.pages.ActivityStreamPage;
import com.crmly.pages.CrmLyLoginPage;
import com.crmly.utilities.BrowserUtils;
import com.crmly.utilities.ConfigurationReader;
import com.crmly.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Uploads_StepDefinitions {

    ActivityStreamPage activityStreamPage = new ActivityStreamPage();
    CrmLyLoginPage loginPage = new CrmLyLoginPage();

    @Given("user logs in as {string}")
    public void user_logs_in_as(String userType) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginType(userType);
    }

    // Scenario #1
    @When("user clicks on Upload Files button")
    public void user_clicks_on_upload_files_button() {
        activityStreamPage.msgBtn.click();
     //   BrowserUtils.sleep(1);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.uploadFiles));
        activityStreamPage.uploadFiles.click();
    }
    @When("uploads three files")
    public void uploads_three_files() {
        activityStreamPage.chooseFilesBtn.sendKeys("/Users/suknovic/Desktop/Group12/Project/TestAutomation/TestJPGPhoto.jpg");
      //  BrowserUtils.sleep(5);
        activityStreamPage.chooseFilesBtn.sendKeys("/Users/suknovic/Desktop/Group12/Project/TestAutomation/TestPresentation.pdf");
      //  BrowserUtils.sleep(5);
        activityStreamPage.chooseFilesBtn.sendKeys("/Users/suknovic/Desktop/Group12/Project/TestAutomation/TestDocument.docx");
        BrowserUtils.sleep(3);
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.insertInTextBtn));
        activityStreamPage.sendMsgBtn.click();

    }
    @Then("user is able to upload files")
    public void user_is_able_to_upload_files() {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.photoUploadedProof));
        BrowserUtils.sleep(3);
        Assert.assertTrue(activityStreamPage.photoUploadedProof.isDisplayed());

//        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.filesUploadedProof));
        Assert.assertTrue(activityStreamPage.filesUploadedProof.isDisplayed());
    }

    // Scenario #2
    @When("user uploads picture")
    public void user_uploads_picture() {
        activityStreamPage.msgBtn.click();

     //   BrowserUtils.sleep(2);
        activityStreamPage.uploadFiles.click();
      //  BrowserUtils.sleep(2);
        activityStreamPage.chooseFilesBtn.sendKeys("/Users/suknovic/Desktop/Group12/Project/TestAutomation/TestJPGPhoto.jpg");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.insertInTextBtn));
        activityStreamPage.sendMsgBtn.click();
    }
    @Then("user should display uploaded picture")
    public void user_should_display_uploaded_picture() {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.displayedPhoto));
        BrowserUtils.sleep(2);
        Assert.assertTrue(activityStreamPage.displayedPhoto.isDisplayed());
    }

    // Scenario #3
    @When("user inserts file into text")
    public void user_inserts_file_into_text() {
        activityStreamPage.msgBtn.click();
   //     BrowserUtils.sleep(3);
        activityStreamPage.uploadFiles.click();
    //    BrowserUtils.sleep(2);
        activityStreamPage.chooseFilesBtn.sendKeys("/Users/suknovic/Desktop/Group12/Project/TestAutomation/TestPresentation.pdf");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.insertInTextBtn));
        activityStreamPage.insertInTextBtn.click();
   //     BrowserUtils.sleep(2);
    }
    @Then("user sees In text label on button")
    public void user_sees_in_text_label_on_button() {
        String actualText = activityStreamPage.inTextLabel.getText();
        System.out.println(actualText);
        String expectedText = "In text";
        Assert.assertEquals(expectedText, actualText);
    }

    // Scenario #4
    @When("user uploads docx document")
    public void user_uploads_docx_document() {
        activityStreamPage.msgBtn.click();
   //     BrowserUtils.sleep(2);
        activityStreamPage.uploadFiles.click();
    //    BrowserUtils.sleep(2);
        activityStreamPage.chooseFilesBtn.sendKeys("/Users/suknovic/Desktop/Group12/Project/TestAutomation/TestDocument.docx");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.insertInTextBtn));
        activityStreamPage.sendMsgBtn.click();

    }
    @Then("recipient should see Edit button")
    public void recipient_should_see_edit_button() {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.editButton));
        BrowserUtils.sleep(5);
        Assert.assertTrue(activityStreamPage.editButton.isDisplayed());
    }

    // Scenario #5
    @When("user uploads any file")
    public void user_uploads_any_file() {
        activityStreamPage.msgBtn.click();

   //     BrowserUtils.sleep(1);
        activityStreamPage.uploadFiles.click();
    //    BrowserUtils.sleep(2);
        activityStreamPage.chooseFilesBtn.sendKeys("/Users/suknovic/Desktop/Group12/Project/TestAutomation/TestPresentation.pdf");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.insertInTextBtn));
    }
    @When("user clicks on delete upload")
    public void user_clicks_on_delete_upload() {
   //     BrowserUtils.sleep(2);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.deleteButton));
        activityStreamPage.deleteButton.click();
    }
    @Then("user should be able to remove attachment before sending")
    public void user_should_be_able_to_remove_attachment_before_sending() {
        boolean result = false;
        try {
            result = BrowserUtils.assertWebElementNotPresent(activityStreamPage.deleteButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(result);

    }

    // Scenario #6
    @When("user uploads any file to send")
    public void user_uploads_any_file_to_send() {
        activityStreamPage.msgBtn.click();

   //     BrowserUtils.sleep(1);
        activityStreamPage.uploadFiles.click();
   //     BrowserUtils.sleep(1);
        activityStreamPage.chooseFilesBtn.sendKeys("/Users/suknovic/Desktop/Group12/Project/TestAutomation/TestPresentation.pdf");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.insertInTextBtn));
    }
    @When("user click on pen icon to rename")
    public void user_click_on_pen_icon_to_rename() {
    //    BrowserUtils.sleep(2);
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(activityStreamPage.attachFileName).perform();
    //    BrowserUtils.sleep(2);
        activityStreamPage.renameButton.click();
    //    BrowserUtils.sleep(2);
        activityStreamPage.renameInput.sendKeys("Renamed", Keys.ENTER);

    }
    @When("user send message with renamed file")
    public void user_send_message_with_renamed_file() {
   //     BrowserUtils.sleep(2);
        activityStreamPage.sendMsgBtn.click();
    }
    @Then("recipient should receive renamed file")
    public void recipient_should_receive_renamed_file() {
        BrowserUtils.sleep(5);
        String actualFileText = activityStreamPage.renamedFileSent.getText();
        Assert.assertTrue(actualFileText.contains("Renamed"));
    }



}
