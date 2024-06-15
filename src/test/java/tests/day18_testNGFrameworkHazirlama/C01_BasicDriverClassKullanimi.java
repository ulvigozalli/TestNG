package tests.day18_testNGFrameworkHazirlama;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_BasicDriverClassKullanimi {
    @Test
    public void test1(){
        //testotomasyonu sayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");
        //phone icin arama yapin
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        WebElement aramasonucElementi = Driver.getDriver().findElement(By.className("product-count-text"));
        String aramaSonucElementiYaziActual = aramasonucElementi.getText();
        String aramaSonucElementiYaziUnExpected = " 0 Products Found";
        Assert.assertNotEquals(aramaSonucElementiYaziActual,aramaSonucElementiYaziUnExpected);

        //sayfayi kapatin
        Driver.quitDriver();
    }
}
