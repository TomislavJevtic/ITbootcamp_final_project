package itbootcampFinalProject.tests;
/*
•	Verifikovati da se u url-u stranice javlja /admin/cities ruta
•	Verifikovati postojanje logut dugmeta

 */

import com.github.javafaker.Faker;
import itbootcampFinalProject.pages.AdminPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCityTests extends BaseTest{

    @Test
    public void test1(){
        homePage.loginBtnClick();
        String validUser = " admin@admin.com";
        String validPassword = "12345";
        loginPage.login(validUser,validPassword);
    homePage.getAdminBtn().click();
    homePage.getAdminBtnCities().click();
    boolean isUrlValid = true;
    boolean actualUrl = driver.getCurrentUrl().contains("/admin/cities");
        Assert.assertEquals(isUrlValid,actualUrl);
    boolean expLogoutBtn= true;
    boolean actualLogBtn = adminPage.getLogoutBtn().isEnabled();
    Assert.assertEquals(expLogoutBtn,actualLogBtn);
    adminPage.getLogoutBtn().click();
    }
    @Test
    public void test2(){
        Faker faker = new Faker();
        homePage.loginBtnClick();
        String validUser = " admin@admin.com";
        String validPassword = "12345";
        loginPage.login(validUser,validPassword);
        homePage.getAdminBtn().click();
        homePage.getAdminBtnCities().click();

        adminPage.getNewItemBtn().click();
        String newCity = "Stalac";//faker.address().cityName();
        driver.findElement(By.id("name")).sendKeys(newCity);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]")).click();
        String actualMessage= driver.findElement(By.xpath
                ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")).getText();
        boolean isExpMessage = true;
        boolean isActualMessage = actualMessage.contains("Saved successfully");
        Assert.assertEquals(isExpMessage,isActualMessage);
        homePage.getLogoutBtn().click();
    }
    @Test
    public void test3() throws InterruptedException {
        homePage.loginBtnClick();
        String validUser = " admin@admin.com";
        String validPassword = "12345";
        loginPage.login(validUser,validPassword);
        homePage.getAdminBtn().click();
        homePage.getAdminBtnCities().click();

        adminPage.getFirstEditBtn().click();
        driver.findElement(By.id("name")).sendKeys("-edited");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]")).click();
       // Thread.sleep(1000);
        driverWait.until(ExpectedConditions.visibilityOfAllElements
                (driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"))));
        String actualMessage= driver.findElement(By.xpath
                ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")).getText();
        boolean isExpMessage = true;
        boolean isActualMessage = actualMessage.contains("Saved successfully");
        Assert.assertEquals(isExpMessage,isActualMessage);

    }
    @Test()
    public void test4() throws InterruptedException {
        homePage.getAdminBtn().click();
        homePage.getAdminBtnCities().click();

        adminPage.getSearchF().sendKeys("Stalac-edited");
        boolean isDisplayed = true;
        Thread.sleep(500);
        String actualEdit = driver.findElement(By.xpath
                ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]")).getText();
        boolean actualDisplayed =actualEdit.contains("Stalac-edited");
        Assert.assertEquals(isDisplayed,actualDisplayed);
    }
    @Test()
    public void test5(){

        homePage.getAdminBtn().click();
        homePage.getAdminBtnCities().click();

        adminPage.getSearchF().sendKeys("Stalac-edited");
        boolean isDisplayed = true;
        String actualEdit = driver.findElement(By.xpath
                ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]")).getText();
        boolean actualDisplayed =actualEdit.contains("Stalac-edited");
        Assert.assertEquals(isDisplayed,actualDisplayed);
        adminPage.getFirstDeleteBtn().click();
        driverWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/button[2]"))));
      //  WebElement deletePopUpBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[6]/div/div/div[2]/button[2]"));

        //deletePopUpBtn.click();

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/button[2]")).click();
        driverWait.until(ExpectedConditions.visibilityOfAllElements
                (driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div"))));
        boolean isDeleted = driver.findElement
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")).getText().contains("Deleted successfully");
        boolean isDeletedExp=true;
        Assert.assertEquals(isDeletedExp,isDeleted);
        adminPage.getLogoutBtn().click();



    }
}
