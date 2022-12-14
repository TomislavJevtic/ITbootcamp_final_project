package itbootcampFinalProject.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test
    public void visitsTheLoginPage() {
        homePage.loginBtnClick();
        String expectedUrl = "https://vue-demo.daniel-avellaneda.com/login";
        String actualUrlR = driver.getCurrentUrl();
        Assert.assertEquals(actualUrlR, expectedUrl);

    }

    @Test()
    public void checksInputTypes() {
        homePage.loginBtnClick();
        String expUsernameType = "email";
        String expPasswordType = "password";
        String actualUsernameType = loginPage.getUsernameF().getAttribute("type");
        String actualPasswordType = loginPage.getPasswordF().getAttribute("type");

        Assert.assertEquals(expUsernameType, actualUsernameType);
        Assert.assertEquals(expPasswordType, actualPasswordType);

    }


    @Test
    public void displaysErrorsWhenUserDoesNotExist() {

        Faker faker = new Faker();
        homePage.loginBtnClick();
        loginPage.login(faker.bothify("????##@gmail.com"), faker.funnyName().name());
        String actualResult = driver.findElement
                (By.xpath(" //*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")).getText();

        String expResult = "User does not exists";
        Assert.assertEquals(actualResult, expResult);

    }

    @Test
    public void displaysErrorsWhenPasswordWrong() {
        Faker faker = new Faker();
        homePage.loginBtnClick();
        String validUser = " admin@admin.com";
        loginPage.login(validUser, faker.funnyName().name());

        String actualResult = driver.findElement
                (By.xpath(" //*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")).getText();
        String expResult = "Wrong password";
        Assert.assertEquals(actualResult, expResult);

        boolean actualUrl = driver.getCurrentUrl().contains("/login");
        Assert.assertTrue(actualUrl);

    }

    @Test
    public void validLogin() {
        String validUser = " admin@admin.com";
        String validPassword = "12345";
        homePage.loginBtnClick();
        loginPage.login(validUser, validPassword);
        driverWait.until(ExpectedConditions.urlContains("/home"));
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://vue-demo.daniel-avellaneda.com/home";

        Assert.assertEquals(actualUrl, expectedUrl);
        homePage.getLogoutBtn().click();


    }


    @Test
    public void logout() {
        String validUser = " admin@admin.com";
        String validPassword = "12345";

        homePage.loginBtnClick();
        loginPage.login(validUser, validPassword);
        driverWait.until(ExpectedConditions.urlContains("/home"));
        WebElement logoutBtn =
                driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]"));

        boolean isClickableLogout = logoutBtn.isEnabled();
        Assert.assertTrue(isClickableLogout);

        logoutBtn.click();

        boolean actualUrl = driver.getCurrentUrl().contains("/login");
        Assert.assertTrue(actualUrl);

        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expHomeUrlWhenLogout = "https://vue-demo.daniel-avellaneda.com/login";
        String actualUrlWhenLogout = driver.getCurrentUrl();
        Assert.assertEquals(expHomeUrlWhenLogout, actualUrlWhenLogout);

    }

}


