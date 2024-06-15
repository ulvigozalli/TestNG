package tests.day18_testNGFrameworkHazirlama;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;

public class C02_PageClassKullanimi {
    @Test
    public void test01(){
        //testotomasyonu sayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");
        //phone icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys("phone"+ Keys.ENTER);
        //arama sonucunda urun bulunabildigini test edin
        String aramaSonucElementiYaziActual = testotomasyonuPage.aramasonucElementi.getText();
        String aramaSonucElementiYaziUnExpected = " 0 Products Found";
        Assert.assertNotEquals(aramaSonucElementiYaziActual,aramaSonucElementiYaziUnExpected);
        //sayfayi kapatin
        Driver.quitDriver();
    }
}
