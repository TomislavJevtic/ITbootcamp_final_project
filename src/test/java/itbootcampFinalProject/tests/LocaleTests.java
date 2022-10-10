package itbootcampFinalProject.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest {
    @Test
    public void setToEs_test() {
        homePage.getLanguageBtn().click();
        driverWait.until(ExpectedConditions.visibilityOfAllElements(homePage.getEsBtn()));
        homePage.getEsBtn().click();
        String expectedTxt = "Página de aterrizaje";
        String actualTxt = driver.findElement(By.tagName("H1")).getText();
        System.out.println(actualTxt);

        Assert.assertEquals(actualTxt, expectedTxt);
    }

    @Test
    public void setToEn_test() {
        homePage.getLanguageBtn().click();
        driverWait.until(ExpectedConditions.visibilityOfAllElements(homePage.getEnBtn()));
        homePage.getEnBtn().click();
        String expectedTxt = "Landing";
        String actualTxt = driver.findElement(By.tagName("H1")).getText();
        System.out.println(actualTxt);

        Assert.assertEquals(actualTxt, expectedTxt);
    }

    @Test
    public void setToFr_test() {
        homePage.getLanguageBtn().click();
        driverWait.until(ExpectedConditions.visibilityOfAllElements(homePage.getFrBtn()));
        homePage.getFrBtn().click();
        String expectedTxt = "Page d'atterrissage";
        String actualTxt = driver.findElement(By.tagName("H1")).getText();
        System.out.println(actualTxt);

        Assert.assertEquals(actualTxt, expectedTxt);
    }
}
