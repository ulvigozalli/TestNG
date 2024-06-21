package tests.day19_testNGFramework_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_TestDatasiKullanimi {
    @Test
    public void aramaTesti() throws InterruptedException {
        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(3);
        // phone icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);
        ReusableMethods.bekle(3);
        // arama sonucunda urun bulunabildigini test edin
        Assert.assertTrue(testotomasyonuPage.sonucElementleriList.size()>0);
        //String ActualSonuc = testotomasyonuPage.aramasonucElementi.getText();
        //String ExpectedSonuc = "0 Products Found";
        //Assert.assertNotEquals(ActualSonuc,ExpectedSonuc,"Urun Bulundu");
        // sayfayi kapatin
        Driver.quitDriver();

    }


}
