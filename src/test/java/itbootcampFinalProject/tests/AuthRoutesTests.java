package itbootcampFinalProject.tests;
/*
Test #1: Forbids visits to home url if not authenticated
assert:
•	Ucitati /home stranu kada korisnik nije ulogovan
•	Verifikovati da se u url-u stranice javlja ruta /login

Test #2: Forbids visits to profile url if not authenticated
assert:
•	Ucitati /profile stranu
•	Verifikovati da se u url-u stranice javlja ruta /login

Test #3: Forbids visits to admin cities url if not authenticated
assert:
•	Ucitati /admin/cities stranu
•	Verifikovati da se u url-u stranice javlja ruta /login

Test #4: Forbids visits to admin users url if not authenticated
assert:
•	Ucitati /admin/users stranu
•	Verifikovati da se u url-u stranice javlja ruta /login

etWebDriverWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"),
"IMPORTANT: Verify your account"));


 */

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest{

    @Test
    public void test1(){
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        boolean expected = true;
        boolean actual = driver.getCurrentUrl().contains("/login");
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void test2(){
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        boolean expected = true;
        boolean actual = driver.getCurrentUrl().contains("/login");
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void test3(){
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        boolean expected = true;
        boolean actual = driver.getCurrentUrl().contains("/login");
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void test4(){
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        boolean expected = true;
        boolean actual = driver.getCurrentUrl().contains("/login");
        Assert.assertEquals(expected,actual);
    }
}
