package itbootcampFinalProject.tests;

import itbootcampFinalProject.pages.FakerInputs;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {


    @Test
    public void editProfileTest() {


        homePage.loginBtnClick();
        loginPage.login(adminPage.getValidUser(), adminPage.getValidPassword());

        homePage.getMyProfile().click();
        FakerInputs fake = new FakerInputs();


        myProfilePage.editProfile(fake.getNameF(), fake.getPhoneF(), fake.getCityF(), fake.getCountryF(), fake.getTwitterF(), fake.getGitHubF());
        myProfilePage.getSaveBtn().click();

        driverWait.until(ExpectedConditions.visibilityOfAllElements(
                driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"))));

        boolean isSuccessDisplayed =
                driver.findElement(By.xpath
                        ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")).getText().contains("Profile saved successfuly");
        Assert.assertTrue(isSuccessDisplayed);

        System.out.println(driver.findElement(By.id("name")).getText());

        boolean isNameValid = myProfilePage.getName().getAttribute("value").contains(fake.getNameF());
        Assert.assertTrue(isNameValid);

    }


}
