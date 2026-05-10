import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginAssignmentTest {

    WebDriver driver;
    By userNameLocator = By.id("user-name");
    By passwordLocator = By.name("password");
    By loginButtonLocator = By.className("submit-button");
    String url = "https://www.selenium.dev/selenium/web/dynamic.html";


    @Test
    public void validStandard_userLogin() {
        driver.findElement(userNameLocator).sendKeys("standard_user");
        driver.findElement(passwordLocator).sendKeys("secret_sauce");
        driver.findElement(loginButtonLocator).click();


    }
    public void validLocked_out_userLogin() {
        driver.findElement(userNameLocator).sendKeys("locked_out_user");
        driver.findElement(passwordLocator).sendKeys("secret_sauce");
        driver.findElement(loginButtonLocator).click();


    }
    public void validProblem_userLogin() {
        driver.findElement(userNameLocator).sendKeys("problem_user");
        driver.findElement(passwordLocator).sendKeys("secret_sauce");
        driver.findElement(loginButtonLocator).click();


    }
    public void validPerformance_glitch_userLogin() {
        driver.findElement(userNameLocator).sendKeys("performance_glitch_user");
        driver.findElement(passwordLocator).sendKeys("secret_sauce");
        driver.findElement(loginButtonLocator).click();


    }
    public void validError_userLogin() {
        driver.findElement(userNameLocator).sendKeys("error_user");
        driver.findElement(passwordLocator).sendKeys("secret_sauce");
        driver.findElement(loginButtonLocator).click();


    }
    public void validVisual_userLogin() {
        driver.findElement(userNameLocator).sendKeys("visual_user");
        driver.findElement(passwordLocator).sendKeys("secret_sauce");
        driver.findElement(loginButtonLocator).click();


    }
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
