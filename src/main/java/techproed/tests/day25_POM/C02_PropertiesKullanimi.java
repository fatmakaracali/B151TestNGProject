package techproed.tests.day25_POM;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_PropertiesKullanimi {


    @Test
    public void amazonTest() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        /*
        Çok fazla amazon sayfasına gittiğimizi düşünelim ve amazon url'inde
      bir değişiklik olduğunda bütün test'lerden url'i düzeltmek yerine
      sadece .properties dosyasından düzelterek tüm testlerdeki url'i
      düzeltmiş oluruz
         */

        String userName = ConfigReader.getProperty("username");
        String password =ConfigReader.getProperty("password");
        System.out.println(userName);
        System.out.println(password);
    }

}
