package Tests;

import Pages.LoginPage;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    //variables
    WebDriver driver;

    //Tests
    @Test
    public void successfulLogin() {
        new LoginPage(driver)
                .enterUsername("problem_user")
                .enterPassword("secret_sauce")
                .clickLoginButton().assertSuccessfulLogin();
    }

    //configurations
    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        //annonyms object of login page and navigate to login page
        new Pages.LoginPage(driver).navigateToLoginPage();

    }

    @AfterMethod
    public void tearDown() {
     //   driver.quit();
    }

}