package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.BrowserActions;
import utils.ElementActions;

public class LoginPage {

    //variables
    private final WebDriver driver;
//locators

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");
// constructor

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //navigate to login page
    public void navigateToLoginPage() {
        BrowserActions.navigateToUrl(driver, "https://www.saucedemo.com/");
    }

    // actions
    public LoginPage enterUsername(String username) {

        ElementActions.sendData(driver, this.username, username);
        return this;

    }

    public LoginPage enterPassword(String password) {
        ElementActions.sendData(driver, this.password, password);
        return this;

    }

    public LoginPage clickLoginButton() {
        ElementActions.clickElement(driver, loginButton);
        return this;
    }

    public String getErrorMessage() {
        return ElementActions.getText(driver, errorMessage);
    }

    //validation
    public LoginPage assertSuccessfulLogin() {

        Assert.assertEquals(BrowserActions.getCurrentUrl(driver), "https://www.saucedemo.com/inventory.html");
        return this;
    }

    public LoginPage assertUnsuccessfulLogin() {
        Assert.assertEquals(getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
        return this;
    }
}