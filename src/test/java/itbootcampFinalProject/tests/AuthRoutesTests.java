package itbootcampFinalProject.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @Test
    //Forbids visits to home url if not authenticated
    public void test1() {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        boolean actual = driver.getCurrentUrl().contains("/login");
        Assert.assertTrue(actual);
    }

    @Test
    //Forbids visits to profile url if not authenticated
    public void test2() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        boolean actual = driver.getCurrentUrl().contains("/login");
        Assert.assertTrue(actual);
    }

    @Test
    //Forbids visits to admin cities url if not authenticated
    public void test3() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        boolean actual = driver.getCurrentUrl().contains("/login");
        Assert.assertTrue(actual);
    }

    @Test
    //Forbids visits to admin users url if not authenticated
    public void test4() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        boolean actual = driver.getCurrentUrl().contains("/login");
        Assert.assertTrue(actual);
    }
}
