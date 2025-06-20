package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private Waits(){

    }
    // Wait for element to be present
    public static WebElement waitForElementPresence(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(25))
                .until(d -> d.findElement(locator));
    }

    // Wait for element to be visible
    public  static WebElement waitForElementVisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(25))
                .until(d -> {
                    WebElement element = waitForElementPresence(driver, locator);
                    return element.isDisplayed() ? element : null;
                });
    }

    // Wait for element to be clickable
    public static WebElement waitForElementClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(25))
                .until(d -> {
                    WebElement element = waitForElementVisible(driver, locator);
                    return element.isEnabled() ? element : null;
                });
    }
}
