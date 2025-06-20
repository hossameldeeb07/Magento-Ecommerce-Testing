package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementActions {
    private ElementActions(){

    }
    //sendKeys
    public static void sendData(WebDriver driver , By locator , String Data){
        Waits.waitForElementVisible(driver,locator);
        driver.findElement(locator).sendKeys(Data);
    }
    //clicking
    public static void clickElement(WebDriver driver , By locator){
        Waits.waitForElementClickable(driver,locator);
        driver.findElement(locator).click();
    }
}
