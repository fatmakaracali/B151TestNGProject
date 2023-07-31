package techproed.tests.day26_PagesKullanimi;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReasableMethods;

public class C04_PozitifTest {

    @Test(groups = "smoke")
    public void test01(){


          //  Acceptance Criteria:

         //    Admin olarak, uygulamaya giriş yapabilmeliyim

         //   https://www.bluerentalcars.com/

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

         //   Admin email: jack@gmail.com

        //    Admin password: 12345

        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        ReasableMethods.bekle(3);
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("blueRentalEmail"), Keys.TAB ,
                                      ConfigReader.getProperty("blueRentalPassword"),Keys.ENTER);


        //Giris yapildigini dogrula

        Assert.assertTrue(blueRentalPage.verify.getText().contains("Jack"));

        //sayfayi kapatiniz

        Driver.closeDriver();

    }

}
