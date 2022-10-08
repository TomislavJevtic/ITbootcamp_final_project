package itbootcampFinalProject.tests;

import itbootcampFinalProject.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait driverWait;

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected AdminPage adminPage;
    protected MyProfilePage myProfilePage;

    public BaseTest() {
    }

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));

        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        signupPage = new SignupPage(driver, driverWait);
        adminPage = new AdminPage(driver, driverWait);
        myProfilePage = new MyProfilePage(driver, driverWait);
    }

    @BeforeMethod
    public void methodSetup() {
        driver.get("https://vue-demo.daniel-avellaneda.com/");
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}





