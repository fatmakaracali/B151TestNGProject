package techproed.tests.day28_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C06_DataProviderTest {

    @DataProvider
    public static Object[][] veriler() {
        return new Object[][]{{"tuba"},
                {"esma"},
                {"fatma"},
                {"zulfiye"},
                {"ömer"},
                {"hamit"},
                {"tamer"},
                {"ahsen"}};
    }

    @Test(dataProvider = "veriler")
    public  void test01(String data){
        System.out.println(data);

    }

    @Test(dataProvider = "veriler")
    public  void test02(String isim){
        System.out.println(isim);

    }

    @Test(dataProvider = "veriler")
    public  void test03(String name){

    }

    @Test(dataProvider = "veriler")
    public  void test04(String ad){

    }
}
