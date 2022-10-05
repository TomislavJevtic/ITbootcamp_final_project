package itbootcampFinalProject.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test
    public void test1() {
        homePage.loginBtnClick();
        String expectedUrl = "https://vue-demo.daniel-avellaneda.com/login";
        String actualUrlR = driver.getCurrentUrl();
        Assert.assertEquals(actualUrlR, expectedUrl);
        // System.out.println(loginPage.getUsernameF().getAttribute("type"));
    }

    @Test()
    public void test2() {
        homePage.loginBtnClick();
        String expUsernameType = "email";
        String expPasswordType = "password";
        String actualUsernameType = loginPage.getUsernameF().getAttribute("type");
        String actualPasswordType = loginPage.getPasswordF().getAttribute("type");

        Assert.assertEquals(expUsernameType, actualUsernameType);
        Assert.assertEquals(expPasswordType, actualPasswordType);

    }

    //  getDriverWait().until(ExpectedConditions.elementToBeClickable(logoutMenuOption));

    @Test
    public void test3() {
//        loginPage.getUsernameF().clear();
        Faker faker = new Faker();
        homePage.loginBtnClick();
        loginPage.login(faker.bothify("????##@gmail.com"), faker.funnyName().name());
        String actualResult = driver.findElement
                (By.xpath(" //*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")).getText();

        String expResult = "User does not exists";
        Assert.assertEquals(actualResult, expResult);

    }

    @Test
    public void test4() {
//        loginPage.getUsernameF().clear();
        Faker faker = new Faker();
        homePage.loginBtnClick();
        String validUser = " admin@admin.com";
        loginPage.login(validUser, faker.funnyName().name());
        String actualResult = driver.findElement
                (By.xpath(" //*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")).getText();

        String expResult = "Wrong password";
        Assert.assertEquals(actualResult, expResult);

        boolean actualUrl = driver.getCurrentUrl().contains("/login");
        boolean expectedUrl = true;

        Assert.assertEquals(actualUrl, expectedUrl);

    }

    @Test
    public void test5() {
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
    public void test6() throws InterruptedException {
        String validUser = " admin@admin.com";
        String validPassword = "12345";

        homePage.loginBtnClick();
        loginPage.login(validUser, validPassword);
        driverWait.until(ExpectedConditions.urlContains("/home"));
        WebElement logoutBtn =
                driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]"));
        boolean isClickableLogout = logoutBtn.isEnabled();

        boolean expectedClickable = true;
        Assert.assertEquals(expectedClickable, isClickableLogout);
        logoutBtn.click();

        boolean expectedUrl = true;
        boolean actualUrl = driver.getCurrentUrl().contains("/login");
        Assert.assertEquals(expectedUrl, actualUrl);

        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expHomeUrlWhenLogout = "https://vue-demo.daniel-avellaneda.com/login";
        Thread.sleep(2000);
        String actualUrlWhenLogout = driver.getCurrentUrl();
        Assert.assertEquals(expHomeUrlWhenLogout, actualUrlWhenLogout);

    }

}


