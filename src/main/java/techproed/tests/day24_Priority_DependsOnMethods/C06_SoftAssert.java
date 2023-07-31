package techproed.tests.day24_Priority_DependsOnMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C06_SoftAssert {

    /*
    SoftAssert kullaniminda junitteki daha önce kullandigimiz methodlarin aynisini kullaniriz.
    Daha önceden kullandigimiz assertion nerde hata alirsa orada testlerin calismasini durudurur.
    SoftAssert'te ne kadar  assertion kullansakta nerede assertAll() methodu kullanirsak testlerimiz de kullandigimiz
     assertionlar orada sonlanir ve hata varsa bunu bize
    konsolda belirtir
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {


        //Amazon sayfasına gidelim

        driver.get("https://amazon.com");

        //Url'in amazon.com.tr olup olmadığını doğrulayınız

        SoftAssert softAssert = new SoftAssert();  //SoftAssert kullanabilmek icin SoftAssert class'indan obje olusturmaliyiz
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.com.tr"); //bilerek hata alacagiz

        //Başlığın best içerdiğini test edelim
        softAssert.assertTrue(driver.getTitle().contains("best"));  //bilerek hata alacagiz

        //Arama kutusunda iphone aratalım

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin

        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        softAssert.assertTrue(sonucYazisi.getText().contains("samsung"));//-->Bilerek hata alıcaz

        softAssert.assertAll();     //bunu yazmayi unutma

        System.out.println("Burası çalışmaz");  //bunu konsola yazdirmaz


    }


    @Test
    public void test02() {


        //Amazon sayfasına gidelim

        driver.get("https://amazon.com");

        //Url'in amazon.com.tr olup olmadığını doğrulayınız

        SoftAssert softAssert = new SoftAssert();  //SoftAssert kullanabilmek icin SoftAssert class'indan obje olusturmaliyiz
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.com.tr"); //bilerek hata alacagiz

        //Başlığın best içerdiğini test edelim
        softAssert.assertTrue(driver.getTitle().contains("best"));  //bilerek hata alacagiz

        //Arama kutusunda iphone aratalım

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin

        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        softAssert.assertTrue(sonucYazisi.getText().contains("samsung"));//-->Bilerek hata alıcaz


        System.out.println("Burası çalışir");

        softAssert.assertAll();    //testi burada sonlandirdik
    }

    @Test
    public void test03() {


        //Amazon sayfasına gidelim

        driver.get("https://amazon.com");

        //Url'in amazon.com.tr olup olmadığını doğrulayınız

        SoftAssert softAssert = new SoftAssert();  //SoftAssert kullanabilmek icin SoftAssert class'indan obje olusturmaliyiz
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.com.tr"); //bilerek hata alacagiz

        //Başlığın best içerdiğini test edelim
        softAssert.assertTrue(driver.getTitle().contains("best"));  //bilerek hata alacagiz
        softAssert.assertAll();        //Testi burada sonlandirdik

        //Arama kutusunda iphone aratalım

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin

        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        softAssert.assertTrue(sonucYazisi.getText().contains("samsung"));//-->Bilerek hata alıcaz


        System.out.println("Burası çalışmaz");


    }

    @Test
    public void test04() {


        //Amazon sayfasına gidelim

        driver.get("https://amazon.com");

        //Url'in amazon.com.tr olup olmadığını doğrulayınız

        SoftAssert softAssert = new SoftAssert();  //SoftAssert kullanabilmek icin SoftAssert class'indan obje olusturmaliyiz
        softAssert.assertNotEquals(driver.getCurrentUrl(), "https://www.amazon.com.tr"); //bilerek hata alacagiz

        //Başlığın best içerdiğini test edelim
        softAssert.assertFalse(driver.getTitle().contains("best"));


        //Arama kutusunda iphone aratalım

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin

        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        softAssert.assertFalse(sonucYazisi.getText().contains("samsung"));//-->Bilerek hata alıcaz




        softAssert.assertAll();

        System.out.println("Burası çalışIR");  //hata almayacagimiz icin calisir

    }
}