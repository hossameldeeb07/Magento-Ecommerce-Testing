package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollUtils {
    private ScrollUtils() {
    }
    public static void scrollToElement(WebDriver driver, By locator) {
        WebElement element = Waits.waitForElementPresence(driver, locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
        Waits.waitForElementVisible(driver, locator);
    }
}
