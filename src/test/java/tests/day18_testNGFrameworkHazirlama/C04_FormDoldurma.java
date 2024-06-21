package tests.day18_testNGFrameworkHazirlama;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C04_FormDoldurma {
    @Test
    public void formDoldurmaTesi() throws InterruptedException {
        //    1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");
        //    2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        TestOtomasyonuFormPage testOtomasyonuFormPage = new TestOtomasyonuFormPage();
        Select selectGun = new Select(testOtomasyonuFormPage.gunDropdownElemnti);
        selectGun.selectByIndex(5);
        //    3- Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        Select selectAy = new Select(testOtomasyonuFormPage.ayDropdownElemnti);
        selectAy.selectByValue("nisan");
        Thread.sleep(4000);
        //    4- Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        Select selectYil = new Select(testOtomasyonuFormPage.yilDropdownElemnti);
        selectYil.selectByVisibleText("1990");
        Thread.sleep(4000);
        //    5- Secilen değerleri konsolda yazdirin
        System.out.println(
                selectGun.getFirstSelectedOption().getText() + " - " +
                        selectAy.getFirstSelectedOption().getText()+ " - " +
                        selectYil.getFirstSelectedOption().getText()
        );
        Thread.sleep(4000);
        //    6- Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<WebElement> aySecenekElementleriList = selectAy.getOptions();
        System.out.println(ReusableMethods.stringListesineDonustur(aySecenekElementleriList));
//        for (WebElement each: aySecenekElementleriList
//             ) {
//            System.out.println(each.getText());
//
//        }
        //    7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        int expectedBoyut = 13;
        int actualBoyut = aySecenekElementleriList.size();
        Assert.assertEquals(actualBoyut,expectedBoyut);
        ReusableMethods.bekle(4);
        Driver.quitDriver();
    }
}
