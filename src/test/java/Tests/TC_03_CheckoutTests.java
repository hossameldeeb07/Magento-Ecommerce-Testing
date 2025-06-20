package Tests;

import Base.BaseTest;
import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_03_CheckoutTests extends BaseTest {
    @Test(description = "Verify check out functionality!")
    @Description("Verify that the user can purchase a product and check out successfully.")
    @Severity(SeverityLevel.CRITICAL)
    public void testCompleteCheckout() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage result = new SearchResultsPage(driver);
        homePage.searchFor("Jacket");
        SearchResultsPage srp = new SearchResultsPage(driver);
        srp.selectFirstProduct();
        ProductPage product = new ProductPage(driver);
        product.selectSizeAndColor();
        product.addToCart();
        CartPage cart = new CartPage(driver);
        cart.proceedToCheckout();
        CheckoutPage cop = new CheckoutPage(driver);
        cop.enterShippingInformation("hossameldeeb07@gmail.com","hossam", "eldeeb", "17th", "cairo", "Alabama","19865", "01023456789");
        cop.selectShippingMethod();
        cop.nextClick();
        cop.placeOrder();
        boolean successMessage = cop.isOrderSuccess();
        Assert.assertTrue(successMessage,"Purchase process is failed!");
    }
}
