package techproed.tests.day26_PagesKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePageTechPro;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReasableMethods;

public class C03_PageKullanimi {

    @Test
    public void test01(){

        //https://testcenter.techproeducation.com/index.php?page=form-authentication

        Driver.getDriver().get(ConfigReader.getProperty("techproUrl"));


        //Page object Model kullanarak sayfaya giriş yapildigini test edin

        OpenSourcePageTechPro techproPage =new OpenSourcePageTechPro();
        techproPage.username.sendKeys(ConfigReader.getProperty("techpro_test_username"));
        techproPage.password.sendKeys(ConfigReader.getProperty("techpro_test_password"));
        ReasableMethods.bekle(3);
        techproPage.loginButton.click();
        Assert.assertTrue(techproPage.girisVerify.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et

        techproPage.logoutButton.click();
        ReasableMethods.bekle(3);
        Assert.assertTrue(techproPage.logoutVerify.isDisplayed());

        //sayfayi kapatiniz

        Driver.closeDriver();

    }

}
