package com.crmly.utilities;

import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    public static void sleep(int seconds){
        seconds *= 1000;
        try{
            Thread.sleep(seconds);
        }catch (InterruptedException e){
        }
    }

    public static boolean assertWebElementNotPresent(WebElement webElement) throws Exception{

        try {
            Driver.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            webElement.getText();
            return false;
        } catch (Exception ignored) {
            return true;
        }
    }

}
