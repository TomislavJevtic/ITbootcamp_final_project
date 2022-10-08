package itbootcampFinalProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfilePage extends BasePage {

    private By name = By.id("name");
    private By phone = By.id("phone");
    private By city = By.id("city");
    private By country = By.id("country");
    private By twitter = By.id("urlTwitter");
    private By gitHub = By.id("urlGitHub");
    private By saveBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");

    public WebElement getSaveBtn() {
        return getDriver().findElement(saveBtn);
    }

    public WebElement getName() {
        return getDriver().findElement(name);
    }

    public WebElement getPhone() {
        return getDriver().findElement(phone);
    }

    public WebElement getCity() {
        return getDriver().findElement(city);
    }

    public WebElement getCountry() {
        return getDriver().findElement(country);
    }

    public WebElement getTwitter() {
        return getDriver().findElement(twitter);
    }

    public WebElement getGitHub() {
        return getDriver().findElement(gitHub);
    }

    public void editProfile(String name, String phone, String city, String country, String twit, String git) {
        getName().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getPhone().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getCity().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getCountry().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getTwitter().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getGitHub().sendKeys(Keys.CONTROL + "A", Keys.DELETE);

        getName().sendKeys(name);
        getPhone().sendKeys(phone);
        getCity().sendKeys(city);
        getCountry().sendKeys(country);
        getTwitter().sendKeys(twit);
        getGitHub().sendKeys(git);

    }


    public MyProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
}
