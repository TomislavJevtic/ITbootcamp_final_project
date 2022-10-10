package itbootcampFinalProject.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BaseTest {

    public SignupTests() {
    }

    @Test
    public void visitsTheSignupPage() {
        signupPage.getSignUpClick();
        boolean actual = driver.getCurrentUrl().contains("/signup");
        Assert.assertTrue(actual);

    }

    @Test
    public void checksInputTypes() {
        signupPage.getSignUpClick();

        boolean actualEmailType = signupPage.getEmail().getAttribute("type").equalsIgnoreCase("email");
        boolean actualPasswordType = signupPage.getPassword().getAttribute("type").equalsIgnoreCase("password");
        boolean actualConfirmPassType = signupPage.getConfirmPassword().getAttribute("type").equalsIgnoreCase("password");

        Assert.assertTrue(actualEmailType);
        Assert.assertTrue(actualPasswordType);
        Assert.assertTrue(actualConfirmPassType);

    }

    @Test
    public void displaysErrorsWhenUserAlreadyExists() {

        signupPage.getSignUpClick();
        String randomName = "TestTest";
        String validEmail = "admin@admin.com";
        String validPassword = "123654";
        signupPage.completeSignUpForm(randomName, validEmail, validPassword, validPassword);

        boolean actualErrorMessage = driver.findElement
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")).getText().equalsIgnoreCase("E-mail already exists");
        Assert.assertTrue(actualErrorMessage);

        boolean actualUrl = driver.getCurrentUrl().contains("/signup");
        Assert.assertTrue(actualUrl);

    }

    @Test
    public void signup() {

        signupPage.getSignUpClick();
        String myName = "Tomislav Jevtic";
        String myEmail = "tomislav.jevtic@itbootcamp.rs";
        String myPassword = "123654";
        signupPage.completeSignUpForm(myName, myEmail, myPassword, myPassword);
        driverWait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[3]/button"))));
        String expectedResult = "IMPORTANT: Verify your account";
        String actualPopupMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]")).getText();
        //  popup window close
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[3]/button")).click();
        // logoutBtn when not admin
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]")).click();

        Assert.assertEquals(actualPopupMessage, expectedResult);


    }

}
