package techproed.tests.day28_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C01_DataProviderTest {


    /**
     Dataprovider, bircok veriyi test caselerde loop kullanmadan aktarmak icin kullanilir
     TestNG'den gelen bir özelliktir.
     2 boyutlu Object Array return eder
     Kullanimi icin @Test notasyonundan sonra parametre olarak (dataProvider="method ismi") yazilir.
     Kac tane veri ile calisacaksak test methoduna o kadar parametre eklenir.

     Data driven testing'de datalarimizi 3 farkli sekilde kullanabiliriz.
     1- .properties dosyasindan datalari alabiliz.   --> ConfigReader.getProperty() ile
     2- Excel dosyasindan datalari alabiliriz        -->ExcelReader class'i ile
     3- DataProvider kullanarak datalari alabiliriz  -->DataProvider methodu ile
     */

    @DataProvider(name="test02")
    public static Object[][] isimler() {

        return new Object[][]{{"tuba"},
                {"esma"},
                {"fatma"},
                {"zulfiye"},
                {"ömer"},
                {"hamit"},
                {"tamer"},
                {"ahsen"}};
    }

    @DataProvider
    public static Object[][] arabalar() {
        return new Object[][]{{"volvo"},
                {"toyota"},
                {"sahin"},
                {"murat"}};
    }

    /**
    Olusturdugumuz dataProvider methodunu baska bir test methodunda da kullanabiliri<
     */



    @Test(dataProvider ="isimler")
    public void test01(String data){
        System.out.println(data);

    }

    @Test(dataProvider="test02")
    public void test02(String isim){
        System.out.println(isim);
    }

    @Test(dataProvider="arabalar")
    public void test03(String arabalar){
        System.out.println(arabalar);

    }
}
