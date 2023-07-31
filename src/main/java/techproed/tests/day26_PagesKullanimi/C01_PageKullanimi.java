package techproed.tests.day26_PagesKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReasableMethods;

public class C01_PageKullanimi {


    @Test
    public void test01() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        //Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Driver.getDriver().get(ConfigReader.getProperty("opensourceUrl"));
        ReasableMethods.bekle(3);


        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim
        //Admin
        //admin123
        OpenSourcePage sourcePage = new OpenSourcePage();
        sourcePage.username.sendKeys(ConfigReader.getProperty("kullaniciAdi"));
        sourcePage.password.sendKeys(ConfigReader.getProperty("sifre"));
        sourcePage.loginButton.click();
        ReasableMethods.bekle(3);

        //Login Testinin basarili oldugunu test et

        Assert.assertTrue(sourcePage.verify.isDisplayed());

        //sayfayi kapatiniz

        Driver.closeDriver();

    }


}
