package itbootcampFinalProject.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @Test
    public void test1() {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        boolean expected = true;
        boolean actual = driver.getCurrentUrl().contains("/login");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        boolean expected = true;
        boolean actual = driver.getCurrentUrl().contains("/login");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        boolean expected = true;
        boolean actual = driver.getCurrentUrl().contains("/login");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        boolean expected = true;
        boolean actual = driver.getCurrentUrl().contains("/login");
        Assert.assertEquals(expected, actual);
    }
}
