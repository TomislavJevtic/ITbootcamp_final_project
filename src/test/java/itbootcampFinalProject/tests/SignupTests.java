package itbootcampFinalProject.tests;

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

}
