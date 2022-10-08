package itbootcampFinalProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {
    private By name = By.id("name");
    private By email = By.id("email");
    private By password = By.id("password");
    private By confirmPassword = By.id("confirmPassword");
    private By signMeUp =
            By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]");

    public WebElement getName() {
        return getDriver().findElement(name);
    }

    public WebElement getEmail() {
        return getDriver().findElement(email);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getConfirmPassword() {
        return getDriver().findElement(confirmPassword);
    }

    public WebElement getSignUpBtn() {
        return getDriver().findElement(signMeUp);
    }

    public void getSignUpClick() {
        getSignUpBtn().click();
    }

    public void completeSignUpForm(String name, String email, String password, String confirmPassword) {
        getName().sendKeys(name);
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getConfirmPassword().sendKeys(confirmPassword);
        getConfirmPassword().sendKeys(Keys.ENTER);
        // getSignUpBtn().click();
    }


    public SignupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
}
