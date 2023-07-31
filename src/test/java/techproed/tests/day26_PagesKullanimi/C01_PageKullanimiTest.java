package techproed.tests.day26_PagesKullanimi;


import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C01_PageKullanimiTest {

    @Test
    public void test01() {

        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim

        Driver.getDriver().get(ConfigReader.getProperty("opensourceUrl"));
        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim
        //Login Testinin basarili oldugunu test et
    }
}