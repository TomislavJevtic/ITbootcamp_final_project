package itbootcampFinalProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By languageBtn = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button");
    private By homeBtn = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[1]");
    private By aboutBtn = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[2]");

    private By loginBtn = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");
    private By signUpBtn = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]");

    public WebElement getLanguageBtn() {
        return getDriver().findElement(languageBtn);
    }

    public WebElement getAboutBtn() {
        return getDriver().findElement(aboutBtn);
    }

    public WebElement getLoginBtn() {
        return getDriver().findElement(loginBtn);
    }

    public WebElement getSignUpBtn() {
        return getDriver().findElement(signUpBtn);
    }

    public WebElement getHomeBtn() {
        return getDriver().findElement(homeBtn);
    }

    public void loginBtnClick() {
        getLoginBtn().click();
    }


    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
}
