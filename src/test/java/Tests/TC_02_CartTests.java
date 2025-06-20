package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SearchResultsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02_CartTests extends BaseTest {
    @Test(description = "Verify add product functionality!")
    @Description("Verify that the user can add a product to his shopping cart.")
    @Severity(SeverityLevel.CRITICAL)
    public void testAddToCart() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage result = new SearchResultsPage(driver);
        homePage.searchFor("Jacket");
        SearchResultsPage srp = new SearchResultsPage(driver);
        srp.selectFirstProduct();
        ProductPage product = new ProductPage(driver);
        product.selectSizeAndColor();
        product.addToCart();
        boolean productAdded = product.isSuccessMessageDisplayed();
        Assert.assertTrue(productAdded,"Product was not added to the cart!");
    }
}

