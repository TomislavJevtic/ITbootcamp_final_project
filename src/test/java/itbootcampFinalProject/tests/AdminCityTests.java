package itbootcampFinalProject.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCityTests extends BaseTest {

    @Test
    public void visitsAdminPageAndListCities() {
        homePage.loginBtnClick();
        loginPage.login(adminPage.getValidUser(), adminPage.getValidPassword());
        homePage.getAdminBtn().click();
        homePage.getAdminBtnCities().click();

        boolean actualUrl = driver.getCurrentUrl().contains("/admin/cities");
        Assert.assertTrue(actualUrl);

        boolean actualLogBtn = adminPage.getLogoutBtn().isEnabled();
        Assert.assertTrue(actualLogBtn);

    }

    @Test(dependsOnMethods = "visitsAdminPageAndListCities")
    public void createNewCity() {

        homePage.getAdminBtn().click();
        homePage.getAdminBtnCities().click();

        adminPage.getNewItemBtn().click();
        String newCity = "Stalac";
        driver.findElement(By.id("name")).sendKeys(newCity);
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[3]/button[2]")));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[3]/button[2]")).click();

        String actualMessage = driver.findElement(By.xpath
                ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")).getText();

        boolean isActualMessage = actualMessage.contains("Saved successfully");
        Assert.assertTrue(isActualMessage);

    }

    @Test(dependsOnMethods = "createNewCity")
    public void editCity() {

        homePage.getAdminBtn().click();
        homePage.getAdminBtnCities().click();

        adminPage.getFirstEditBtn().click();
        driver.findElement(By.id("name")).sendKeys("-edited");
        driverWait.until(ExpectedConditions.elementToBeClickable(By.className("btnSave")));
        driver.findElement(By.className("btnSave")).click();
        driverWait.until(ExpectedConditions.visibilityOfAllElements
                (driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"))));
        String actualMessage = driver.findElement(By.xpath
                ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")).getText();

        boolean isActualMessage = actualMessage.contains("Saved successfully");
        Assert.assertTrue(isActualMessage);

    }

    @Test(dependsOnMethods = "editCity")
    public void searchCity() {
        homePage.getAdminBtn().click();
        homePage.getAdminBtnCities().click();
        adminPage.getSearchF().sendKeys("Stalac-edited");

        String actualEdit = driver.findElement(By.xpath
                ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]")).getText();
        boolean actualDisplayed = actualEdit.contains("Stalac-edited");
        Assert.assertTrue(actualDisplayed);
    }

    @Test(dependsOnMethods = "searchCity")
    public void deleteCity() {

        homePage.getAdminBtn().click();
        homePage.getAdminBtnCities().click();

        adminPage.getSearchF().sendKeys("Stalac-edited");

        String actualEdit = driver.findElement(By.xpath
                ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]")).getText();
        boolean actualDisplayed = actualEdit.contains("Stalac-edited");
        Assert.assertTrue(actualDisplayed);
        adminPage.getFirstDeleteBtn().click();
        driverWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/button[2]"))));

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/button[2]")).click();
        driverWait.until(ExpectedConditions.visibilityOfAllElements
                (driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div"))));
        boolean isDeleted = driver.findElement
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")).getText().contains("Deleted successfully");

        Assert.assertTrue(isDeleted);


    }
}