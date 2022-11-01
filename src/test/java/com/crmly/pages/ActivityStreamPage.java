package com.crmly.pages;

import com.crmly.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivityStreamPage {

    public ActivityStreamPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[.='Message'])[2]")
    public WebElement msgBtn;

    @FindBy(id = "bx-b-uploadfile-blogPostForm")
    public WebElement uploadFiles;

    @FindBy(xpath = "(//input[@type='file'])[1]")
    public WebElement chooseFilesBtn;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendMsgBtn;

    @FindBy(xpath = "(//div[.='Photo:'])[1]")
    public WebElement photoUploadedProof;

    @FindBy(xpath = "(//div[.='Files:'])[1]")
    public WebElement filesUploadedProof;

    @FindBy(xpath = "(//img[contains(@id,'disk-attach-image')])[1]")
    public WebElement displayedPhoto;

    @FindBy(xpath = "//span[.='In text']")
    public WebElement inTextLabel;

    @FindBy(xpath = "//span[contains(@id, 'check-in-text-n3')]")
    public WebElement insertInTextBtn;

    @FindBy(xpath = "(//input[@class='feed-add-post-files-activity-checkbox'])[1]")
    public WebElement editCheckbox;

    @FindBy(xpath = "(//a[.='Edit'])[1]")
    public WebElement editButton;

    @FindBy(xpath = "//span[@class='del-but']")
    public WebElement deleteButton;

    @FindBy(xpath = "//span[@class='f-wrap']")
    public WebElement attachFileName;

    @FindBy(xpath = "//span[@class='files-name-edit-btn']")
    public WebElement renameButton;

    @FindBy(xpath = "//input[@class='files-name-edit-inp']")
    public WebElement renameInput;

    @FindBy(xpath = "//a[contains(@title, 'Renamed')]")
    public WebElement renamedFileSent;

}
