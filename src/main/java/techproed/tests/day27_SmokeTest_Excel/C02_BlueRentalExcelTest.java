package techproed.tests.day27_SmokeTest_Excel;

import org.testng.annotations.Test;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;

public class C02_BlueRentalExcelTest {

    @Test(groups = "smoke")
    public void test01(){
        //mysmoketestdata excel dosyasindaki 1.satir bilgilerini konsola yazdiralim

        String dosyaYolu ="src/main/java/techproed/resources/mysmoketestdata.xlsx";
        String sayfaIsmi ="customer_info";
        ExcelReader reader = new ExcelReader(dosyaYolu,sayfaIsmi);
        System.out.println("Birinci Email ="+reader.getCellData(1, 0));
        System.out.println("Birinci password ="+reader.getCellData(1, 1));

        Driver.closeDriver();
    }
}
