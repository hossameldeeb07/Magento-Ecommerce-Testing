package Pages;

import Utils.ElementActions;
import Utils.ScrollUtils;
import Utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private final By shoppingCart =By.cssSelector("#maincontent > div.page.messages > div:nth-child(2) > div > div > div > a");
    private final By proceedToCheckoutButton = By.cssSelector("#maincontent > div.columns > div > div.cart-container > div.cart-summary > ul > li:nth-child(1) > button");

    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void proceedToCheckout() {
        ScrollUtils.scrollToElement(driver,shoppingCart);
        ElementActions.clickElement(driver,shoppingCart);
        ElementActions.clickElement(driver, proceedToCheckoutButton);
    }
}
