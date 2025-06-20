package Pages;

import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final By searchBar = By.id("search");
    private final By searchButton = By.cssSelector(".action.search");
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String query) {
        ElementActions.sendData(driver, searchBar, query);
        ElementActions.clickElement(driver, searchButton);;
    }
}
