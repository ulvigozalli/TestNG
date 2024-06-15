package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    //Driver class'i driver objesini olusturacagimiz
    //ve gerekli ayarlari yapacagimiz class olacaktir


    public static WebDriver driver;
    public static WebDriver getDriver(){
        if (driver == null){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
        driver=null;
    }
}
