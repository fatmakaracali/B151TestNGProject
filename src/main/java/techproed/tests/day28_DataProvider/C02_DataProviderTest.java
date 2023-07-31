package techproed.tests.day28_DataProvider;


import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReasableMethods;

public class C02_DataProviderTest {
    @DataProvider
    public static Object[][] arabalar() {
        return new Object[][]{{"volvo"}, {"audi"}, {"mercedes"}, {"ford"}};
    }

    /*
        Google sayfasına gidip
        DataProvider ile belirtilen araç isimlerini aratalım
         */
    @Test(dataProvider = "arabalar")
    public void test01(String araclar) {
        //Google sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));



        //Dataprovider'daki verilerle arama yapalım
        GooglePage googlePage = new GooglePage();

        googlePage.cerez.click();
        googlePage.aramaKutusu.sendKeys(araclar, Keys.ENTER);
        ReasableMethods.bekle(3);
        //Her arama için sayfa resmi alalım
        ReasableMethods.tumSayfaResmi();

        //Sayfayı kapatalım
        Driver.closeDriver();


    }
}