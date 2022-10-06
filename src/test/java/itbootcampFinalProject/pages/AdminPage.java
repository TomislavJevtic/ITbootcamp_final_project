package itbootcampFinalProject.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends BasePage {

    private By searchField = By.id("search");
    private By newItemBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    private By LogoutBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");
    private By firstEditBtn = By.id("edit");
    private By firstDeleteBtn = By.id("delete");


    public WebElement getSearchF() {
        return getDriver().findElement(searchField);
    }

    public WebElement getNewItemBtn() {
        return getDriver().findElement(newItemBtn);
    }

    public WebElement getLogoutBtn() {
        return getDriver().findElement(LogoutBtn);
    }

    public WebElement getFirstEditBtn() {
        return getDriver().findElement(firstEditBtn);
    }

    public WebElement getFirstDeleteBtn() {
        return getDriver().findElement(firstDeleteBtn);
    }


    public AdminPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
}
