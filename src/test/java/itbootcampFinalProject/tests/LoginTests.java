package itbootcampFinalProject.tests;

import com.github.javafaker.Faker;
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

    @Test
    public void test3() {
        Faker faker = new Faker();
        homePage.loginBtnClick();
        loginPage.login(faker.bothify("????##@gmail.com"), faker.funnyName().name());
    }
}


