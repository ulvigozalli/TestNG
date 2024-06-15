package tests.day17_testNGFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Priority {
    //3 farkli test moetodu olusturun
    //ve her bir method'da asagida verilen websayfalarindan birine gidip
    //o  sayfaya gidildigini test edin
    // 1 - testotomasyonu.com,
    // 2 - wisequarter.com
    // 3 - bestbuy.com

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
    /*
        JUnit'de test metodlarinin hangi siralama ile calisacagi ongorulemez
        TestNG test metodlari default olarak isim sirasina gore calisir

        1-  priority degeri atamazsak default olarak degeri 0 olur
        2 - priority kucukten buyuge dogru siralanir
        3 - priority degerleri her turlu tamsayi olabilir, aralik sarti yoktur
        4 - eger bir methoda priority atamazsak default degeri 0 gore siralanir
        5 - eger birden fazla methodun priority degeri esitse esit olanlar kendi icinde
        harf siralamsina gore calisir, digerleri ile priority degerine gore siralanir


    */
    @Test (priority = 2)
    public void testotomasyonuTest(){
        driver.get("https://www.testotomasyonu.com");
        //url'in testotomasyonu icerdigini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrlIcerik = "testotomasyonu";
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }

    @Test (priority = 33)
    public void wisequarterTest(){
        driver.get("https://www.wisequarter.com");
        //url'in wisequarter.com icerdigini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrlIcerik = "wisequarter";
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }
    @Test (priority = -17)
    public void bestbuyTest(){
        driver.get("https://www.bestbuy.com");
        //url'in bestbuy.com icerdigini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrlIcerik = "bestbuy";
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }
}
