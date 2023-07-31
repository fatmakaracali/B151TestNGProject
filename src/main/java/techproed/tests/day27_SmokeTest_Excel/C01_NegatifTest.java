package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReasableMethods;

public class C01_NegatifTest {

    @Test
    public void test01(){


        //Description:
        //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
        //Acceptance Criteria
        //Customer email: fake@bluerentalcars.com
        //Customer password: fakepass
        //Error:
        //User with email fake@bluerentalcars.com not found


        //https://www.bluerentalcars.com/ adresine gidelim negatif senaryo ile login olamadığımızı test edelim

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("fakeEmail"), Keys.TAB,
                                      ConfigReader.getProperty("fakePassword"),Keys.ENTER);



        ReasableMethods.visibleWait(blueRentalPage.wrongVerify,5);
        Assert.assertTrue(blueRentalPage.wrongVerify.isDisplayed());

        //Sayfayi kapatiniz

        Driver.closeDriver();




    }
}
