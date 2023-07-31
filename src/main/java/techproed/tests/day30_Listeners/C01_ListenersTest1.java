package techproed.tests.day30_Listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

@Listeners(techproed.utilities.Listeners.class)
public class C01_ListenersTest1 {

    /*
    Bir class'ta listeners kullanabilmek icin class'tan önce @Listeners notasyonu eklememis gerekir. Ve bunotasyon icine
    olusturdugumuz Listeners class'inin yolunu parametre olarak eklemeliyiz
     */
    /*
    @Test notasyonundan sonra parametre olarak invocationCount = 10 eklersek belirttiğimiz sayı kadar
    testlerimizi çalıştırır. successPercentage = 90 bu parametre ise yüzdelik belirtir yani ikisi bir arada
    kullanılırsa 10 testten 1 tanesi çalışmaz ise sorun olmaz ama 2 tanesi çalışmaz ise onTestFailedButWithinSuccessPercentage()
    methodu devreye girer.
    */


   @Test(invocationCount = 10,successPercentage = 90)
    public void test01(){

       System.out.println("PASSED");
       Assert.assertTrue(true);
       Assert.assertEquals(2,2);

   }
   @Test
    public void test02(){
       System.out.println("FAILED");
       Assert.assertTrue(false);
   }

   @Test
    public void test03(){
       System.out.println("SKIP");
       throw new SkipException("Bu method atlandi");
   }

   @Test
   public void test04() {
      Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
      Driver.getDriver().findElement(By.id("lkhjlkjhlj")).click();
   }
}
