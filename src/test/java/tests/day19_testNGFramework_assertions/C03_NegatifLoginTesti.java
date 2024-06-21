package tests.day19_testNGFramework_assertions;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_NegatifLoginTesti {

    //1- https://www.testotomasyonu.com/ anasayfasina gidin

    //2- account linkine basin
    //3-  3 farkli test method’u olusturun.
    //	- gecerli email, gecersiz password
    //	- gecersiz email, gecerli password
    //	- gecersiz email, gecersiz password.
    //4- Login butonuna basarak login olmayi deneyin
    //5- Basarili olarak giris yapilamadigini test edin

    @Test
    public void gecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();
        ReusableMethods.bekle(2);
        //	- gecerli email, gecersiz password
        testotomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testotomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        //4- Login butonuna basarak login olmayi deneyin
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(testotomasyonuPage.loginSiginButonu).perform();
        testotomasyonuPage.loginSiginButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginEmailKutusu.isDisplayed());
        ReusableMethods.bekle(3);
        Driver.quitDriver();
    }
    @Test
    public void gecersizEmailTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();
        ReusableMethods.bekle(2);
        //	- gecersiz email, gecercli password
        testotomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        //4- Login butonuna basarak login olmayi deneyin
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(testotomasyonuPage.loginSiginButonu).perform();
        testotomasyonuPage.loginSiginButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginEmailKutusu.isDisplayed());
        ReusableMethods.bekle(3);
        Driver.quitDriver();
    }
    @Test
    public void gecersizEmailgecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();
        ReusableMethods.bekle(2);
        //	- gecersiz email, gecersiz password
        testotomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        //4- Login butonuna basarak login olmayi deneyin
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(testotomasyonuPage.loginSiginButonu).perform();
        testotomasyonuPage.loginSiginButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginEmailKutusu.isDisplayed());
        ReusableMethods.bekle(3);
        Driver.quitDriver();
    }

}
