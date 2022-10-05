package itbootcampFinalProject.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BaseTest {

    public SignupTests() {
    }

    @Test
    public void test1() {
        signupPage.getSignUpClick();
        boolean expected = true;
        boolean actual = driver.getCurrentUrl().contains("/signup");
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void test2() {
        signupPage.getSignUpClick();
        boolean expectedType = true;
        boolean actualEmailType = signupPage.getEmail().getAttribute("type").equalsIgnoreCase("email");
        boolean actualPasswordType = signupPage.getPassword().getAttribute("type").equalsIgnoreCase("password");
        boolean actualConfirmPassType = signupPage.getConfirmPassword().getAttribute("type").equalsIgnoreCase("password");

        Assert.assertEquals(expectedType, actualEmailType);
        Assert.assertEquals(expectedType, actualPasswordType);
        Assert.assertEquals(expectedType, actualConfirmPassType);

    }

    @Test
    public void test3() {

        signupPage.getSignUpClick();
        String randomName = "TestTest";
        String validEmail = "admin@admin.com";
        String validPassword = "123654";
        signupPage.completeSignUpForm(randomName, validEmail, validPassword, validPassword);

        boolean actualErrorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")).getText().equalsIgnoreCase("E-mail already exists");
        boolean expectedRes = true;

        Assert.assertEquals(actualErrorMessage, expectedRes);
        boolean actualUrl = driver.getCurrentUrl().contains("/signup");
        Assert.assertEquals(actualUrl, expectedRes);

    }
    @Test
    public void test4() {

        signupPage.getSignUpClick();
        String myName = "Tomislav Jevtic";
        String myEmail = "tomislav.jevtic@itbootcamp.rs";
        String myPassword = "123654";
        signupPage.completeSignUpForm(myName, myEmail, myPassword, myPassword);
        driverWait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[3]/button"))));
        String expectedResult= "IMPORTANT: Verify your account";
        String actualPopupMessage=driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]")).getText();

        Assert.assertEquals(actualPopupMessage, expectedResult);

    }

}
