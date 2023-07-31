package techproed.tests.day24_Priority_DependsOnMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Ignore {

    WebDriver driver;
    @BeforeMethod
    public  void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    /*

    Birden fazla test methodu calistirmak istedigimizde o anlik gereksiz gördugumuz test methodunu atlamak(ignore)
    isteyebiliriz. Bunun icin @Test notasyonu ustune ya da yanina @Ignore notasyonu eklememiz yeterlidir. @Ignore notasyonu
    ile atladigimiz method konsolda gözukmez , raporlamalarda gözukur. Eger bir methodu tamamen iptal etmek isterseniz @Test
    notasyonundan sonra parametre olarak (enabled = false) kullanabiliriz
     */

    @Ignore                                    //   @Ignore calismaz ama raporda gözukur
    @Test
    public void amazonTest(){
        driver.get("https://amazon.com");
    }


    @Test(enabled = false)                     //(enabled = false) ile methodu iptal ettik, calismaz, raporda da görunmez
    public void youtubeTest(){
        driver.get("https://youtube.com");
    }


    @Test
    public void facebookTest(){
        driver.get("https://facebook.com");
    }

    @AfterMethod

    public void tearDown(){
        driver.close();
    }
}
