package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SearchResultsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01_SearchTests extends BaseTest {
    @Test(priority = 1 , description = "Verify search functionality (VALID)!")
    @Description("Verify valid product search returns results")
    @Severity(SeverityLevel.CRITICAL)
    public void testValidProductSearch() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage result = new SearchResultsPage(driver);
        homePage.searchFor("Jacket");
        boolean results = !driver.findElements(result.getProductItems()).isEmpty();
        Assert.assertTrue(results, "No results found for valid search");
    }

    @Test(priority = 2,description = "Verify search functionality (INVALID)!")
    @Description("Verify invalid product search shows no results message")
    @Severity(SeverityLevel.NORMAL)
    public void testInvalidProductSearch() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage result = new SearchResultsPage(driver);
        homePage.searchFor("asd");
        boolean results = driver.findElements(result.getProductItems()).isEmpty();
        Assert.assertTrue(results,"No results message is not displayed!");
    }
}
