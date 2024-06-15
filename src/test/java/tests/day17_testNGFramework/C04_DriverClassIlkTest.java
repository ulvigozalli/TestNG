package tests.day17_testNGFramework;

import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverClassIlkTest {
    @Test
    public void test01() throws InterruptedException {
        Driver.getDriver().get("https://www.testotomasyonu.com");
        Thread.sleep(3000);
        Driver.quitDriver();
    }


}
