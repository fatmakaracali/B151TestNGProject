package techproed.tests.day26_PagesKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePageClass;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReasableMethods;

public class C02_PageKullanimi {

    @Test
    public void test01(){

        Driver.getDriver().get(ConfigReader.getProperty("opensourceUrl"));
        OpenSourcePageClass.username().sendKeys(ConfigReader.getProperty("kullaniciAdi"));
        OpenSourcePageClass.password().sendKeys(ConfigReader.getProperty("sifre"));
        ReasableMethods.bekle(3);
        OpenSourcePageClass.loginButton().click();

        Assert.assertTrue(OpenSourcePageClass.verify().isDisplayed());

        Driver.closeDriver();
    }
}
