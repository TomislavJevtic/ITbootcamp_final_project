package itbootcampFinalProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {
    private By usernameField = By.id("email");
    private By passwordField = By.id("password");
    private By loginBtn = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");


    public WebElement getUsernameF() {
        return getDriver().findElement(usernameField);
    }

    public WebElement getPasswordF() {
        return getDriver().findElement(passwordField);
    }

    public WebElement getLoginBtn() {
        return getDriver().findElement(loginBtn);
    }

    public void login(String username, String password) {
        getUsernameF().sendKeys(username);
        getPasswordF().sendKeys(password);
        getLoginBtn().click();
    }


    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
}
