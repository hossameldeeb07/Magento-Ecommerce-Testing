package Pages;

import Utils.ElementActions;
import Utils.ScrollUtils;
import Utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
    private final By emailField = By.cssSelector("#customer-email");
    private final By firstNameField = By.name("firstname");
    private final By lastNameField = By.name("lastname");
    private final By streetAddressField = By.name("street[0]");
    private final By cityField = By.name("city");
    private final By zipCodeField = By.name("postcode");
    private final By phoneNumberField = By.name("telephone");
    private final By nextButton = By.cssSelector(".button.action.continue.primary");
    private final By placeOrderButton = By.cssSelector("button.action.primary.checkout[title='Place Order']");
    private final By shippingMethodButton = By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input");
    private final By stateList = By.cssSelector("select[name='region_id']");
    private final By successPurchaseMessage = By.xpath("//span[@class='base' and contains(., 'Thank you')]");
    private final WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterShippingInformation(String email ,String firstName, String lastName, String street,
                                         String city,String state , String zip, String phone) {
        ElementActions.sendData(driver,emailField,email);
        ElementActions.sendData(driver, firstNameField, firstName);
        ElementActions.sendData(driver, lastNameField, lastName);
        ElementActions.sendData(driver, streetAddressField, street);
        ElementActions.sendData(driver, cityField, city);
        ScrollUtils.scrollToElement(driver,nextButton);
        WebElement dropdown = driver.findElement(stateList);
        Select select = new Select(dropdown);
        select.selectByVisibleText(state);
        ElementActions.sendData(driver, zipCodeField, zip);
        ElementActions.sendData(driver, phoneNumberField, phone);
    }

    public void selectShippingMethod() {
        ElementActions.clickElement(driver,shippingMethodButton );
    }

    public void nextClick(){
        ElementActions.clickElement(driver,nextButton);
    }

    public void placeOrder() {
        ScrollUtils.scrollToElement(driver, placeOrderButton);
        WebElement button = Waits.waitForElementVisible(driver, placeOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    public boolean isOrderSuccess() {
        return Waits.waitForElementVisible(driver, successPurchaseMessage)
                .getText().contains("Thank you");
    }
}
