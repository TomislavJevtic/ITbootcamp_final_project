package itbootcampFinalProject.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {


    @Test
    public void editProfileTest() {
        Faker faker = new Faker();
        String nameF = faker.name().firstName();
        String phoneF = faker.number().digits(6);
        String cityF = faker.address().city();
        String countryF = faker.address().country();
        String twitterF = faker.bothify("https://???????.com");
        String gitHubF = faker.bothify("https://???????.com");

        homePage.loginBtnClick();
        String validUser = " admin@admin.com";
        String validPassword = "12345";
        loginPage.login(validUser, validPassword);

        homePage.getMyProfile().click();


        myProfilePage.editProfile(nameF, phoneF, cityF, countryF, twitterF, gitHubF);
        myProfilePage.getSaveBtn().click();

        driverWait.until(ExpectedConditions.visibilityOfAllElements(
                driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"))));

        boolean isSuccessDisplayed =
                driver.findElement(By.xpath
                        ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")).getText().contains("Profile saved successfuly");
        Assert.assertTrue(isSuccessDisplayed);

        System.out.println(driver.findElement(By.id("name")).getText());

        boolean isNameValid = myProfilePage.getName().getAttribute("value").contains(nameF);
        Assert.assertTrue(isNameValid);

    }


}
