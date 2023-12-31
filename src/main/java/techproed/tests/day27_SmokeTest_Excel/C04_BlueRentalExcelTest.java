package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReasableMethods;

public class C04_BlueRentalExcelTest {

    @Test
    public void test01(){

        //Excel dosyamızdaki tüm email ve password'ler ile
        //BlueRentalCar sayfasına gidip login olalım

        String dosyaYolu ="src/main/java/techproed/resources/mysmoketestdata.xlsx";
        String sayfaIsmi ="customer_info";
        ExcelReader reader = new ExcelReader(dosyaYolu,sayfaIsmi);

        //Sayfaya gidelim

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));



        //Bir loop olusturup excel dosyasindaki tum veriler ile login olalim

        for (int i = 1; i <= reader.rowCount(); i++) {  //i'yi 1'den baslattik, cunku veriler 1.satirdan basliyor
            String email= reader.getCellData(i,0);
            String password = reader.getCellData(i,1);
            System.out.println(email +" || "+password);

            BlueRentalPage rentalPage = new BlueRentalPage();
            rentalPage.login.click();
            ReasableMethods.bekle(3);
            rentalPage.email.sendKeys(email, Keys.TAB, password,Keys.ENTER);
            ReasableMethods.bekle(2);

            rentalPage.verify.click();
            ReasableMethods.bekle(3);
            Assert.assertTrue(rentalPage.logOut.isDisplayed());
            rentalPage.logOut.click();
            ReasableMethods.bekle(3);
            rentalPage.ok.click();

            Driver.closeDriver();



        }
    }
}
