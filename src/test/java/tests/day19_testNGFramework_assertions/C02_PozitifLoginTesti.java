package tests.day19_testNGFramework_assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.time.Duration;
import static utilities.Driver.driver;
public class C02_PozitifLoginTesti {
    @Test
    public void pozitifLoginTest(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        ReusableMethods.bekle(2);
        testotomasyonuPage.accountLinki.click();

        //3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage
                .loginEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        //4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage
                .loginPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        ReusableMethods.bekle(2);
        //5- Login butonuna basarak login olun
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(testotomasyonuPage.loginSiginButonu).perform();
        testotomasyonuPage
                .loginSiginButonu
                .click();
        ReusableMethods.bekle(2);
        actions.moveToElement(testotomasyonuPage.logOutButonu).perform();
        //6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logOutButonu.isDisplayed());
        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }
}
