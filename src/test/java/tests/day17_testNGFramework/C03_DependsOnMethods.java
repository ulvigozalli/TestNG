package tests.day17_testNGFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;

public class C03_DependsOnMethods {
    // 3 farkli test methodu olusturup, asagidaki gorevleri yerine getirin
    // 1 - testotomasyonu anasayfasina gidin ve sayfaya gittiginizi test edin
    // 2 - phone icin arama yapin ve urun bulunabildigini test edin
    // 3 - ilk urune tiklayip, acilan sayfada case sensitive olmaksizin
    //urun isminin phone icerdigini test edin

    WebDriver driver;
    @BeforeClass
    public void setup(){
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
    @Test
    public void testotomasyonuTesti() throws InterruptedException {
        driver.get("https://www.testotomasyonu.com/");
        WebElement logo = driver.findElement(By.xpath("(//*[@alt='Logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
        Thread.sleep(2000);
    }
   @Test (dependsOnMethods = "testotomasyonuTesti")
    public void urunAra() throws InterruptedException {
       WebElement aramakutusu = driver.findElement(By.id("global-search"));
       aramakutusu.sendKeys("phone" + Keys.ENTER);
       Thread.sleep(2000);
       // 2 - phone icin arama yapin ve urun bulunabildigini test edin
        WebElement aramaSonucYaziElementi = driver.findElement(By.className("product-count-text"));
        String actualText = aramaSonucYaziElementi.getText();
        String expectedText = "0 Products Found";
        Assert.assertNotEquals(actualText,expectedText);
    }
    // 3 - ilk urune tiklayip, acilan sayfada case sensitive olmaksizin
    //urun isminin phone icerdigini test edin
    @Test (dependsOnMethods = "urunAra")
    public void urunIsimicerik(){
        driver.findElement(By.xpath("(//*[@class=\"prod-img\"])[1]")).click();
        WebElement urunIsim = driver.findElement(By.xpath("//*[@class=\" heading-sm mb-4\"]"));
        String actualProdName = urunIsim.getText().toLowerCase();
        String expectedProdName = "phone";
        Assert.assertTrue(actualProdName.contains(expectedProdName));
    }
}
