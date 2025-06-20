package Pages;

import Utils.ElementActions;
import Utils.ScrollUtils;
import Utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private final By sizeOption = By.id("option-label-size-143-item-168");
    private final By colorOption = By.id("option-label-color-93-item-56");
    private final By addToCartButton = By.id("product-addtocart-button");
    private final By successMessage = By.cssSelector(".message-success");
    private final WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSizeAndColor() {
        ElementActions.clickElement(driver, sizeOption);
        ElementActions.clickElement(driver, colorOption);
    }

    public void addToCart() {
        ScrollUtils.scrollToElement(driver,addToCartButton);
        ElementActions.clickElement(driver, addToCartButton);
    }


    public boolean isSuccessMessageDisplayed() {
        ScrollUtils.scrollToElement(driver,successMessage);
        return Waits.waitForElementVisible(driver, successMessage).isDisplayed();
    }

}
