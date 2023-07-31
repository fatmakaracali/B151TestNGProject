package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReasableMethods;

public class C03_BlueRentalExcelTest {

    @Test
    public void test01(){

        /**
         Test yaptigiiz sayfadaki datalari .properties ya da excel dosyasindan alabiliriz.
         .properties dosyasindan verileri okuyabilmemiz icin ConfigReader class'i olusturmustuk.
         Ayni sekilde excel dosyasindaki verileri okuyabilmek icn ExcelReader class'i olusturduk
         Burdan alacagimiz email ve password bilgilerini String bir degiskene assign edip login testi
         yapacagimiz sitede sendKeys() methodu ile cok rahat kullanabiliriz
         */

        ExcelReader reader = new ExcelReader("src/main/java/techproed/resources/mysmoketestdata.xlsx","customer_info");
        String email= reader.getCellData(1,0);
        String password =reader.getCellData(1,1);

        //BlueRentalCar sayfasina gidelim

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));


        //mysmoketestdata excel dosyasindan bir kullanici ile login olalim

        BlueRentalPage rentalPage = new BlueRentalPage();
        rentalPage.login.click();
        ReasableMethods.bekle(2);
        rentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);

        //login oldugumuzu dogrulayalim

        Assert.assertTrue(rentalPage.verify.getText().contains("Sam"));

        /**
    Login webelementi login olduktan sonrada aynı locate sahip olabilme ihtimaline karşı
    daha garanti bir doğrulama yapmak için login olduktan sonra login webelementinin olduğu
    yerde login olduğumuz kullanıci ismi çıkacaktır. Bu webelementin yazısını getText() methodu
    ile alıp kullanıcı ismini içeriyomu içermiyomu olarak test ederiz
     */

        //sayfayi kapatalim

        Driver.closeDriver();
    }
}
