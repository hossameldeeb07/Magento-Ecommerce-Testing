package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SearchResultsPage;
import Utils.ElementActions;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_SQL_Injection_Security_Test extends BaseTest {
    @Test(description = "Test search functionality for SQL injection vulnerability")
    @Severity(SeverityLevel.CRITICAL)
    public void testSearchSqlInjection() {
        String sqlPayloads = "' OR '1'='1";
        HomePage home = new HomePage(driver);
        home.searchFor(sqlPayloads);
        SearchResultsPage srp = new SearchResultsPage(driver);

        boolean isVulnerable = driver.findElements(srp.getErrorMessage()).isEmpty()
                && !driver.getPageSource().contains("SQL")
                && !driver.getPageSource().contains("syntax");

        Assert.assertFalse(isVulnerable,
                "Potential SQL injection vulnerability detected with payload: " + sqlPayloads);
    }
}
