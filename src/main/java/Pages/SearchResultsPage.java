package Pages;

import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    private final By productItems = By.cssSelector(".product-item-link");
    private final By errorMessage = By.cssSelector(".message.error");
    private final WebDriver driver;

    public By getProductItems() {
        return productItems;
    }

    public By getErrorMessage() {
        return errorMessage;
    }
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFirstProduct() {
        ElementActions.clickElement(driver,productItems);
    }

}
