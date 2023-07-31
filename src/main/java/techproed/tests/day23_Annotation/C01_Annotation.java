package techproed.tests.day23_Annotation;

import org.testng.annotations.*;

public class C01_Annotation {

    @BeforeSuite

    public void suite(){
        System.out.println("Her seyden once bir kez calisir");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Testlerden önce bir kez calisir");
    }
    @BeforeClass
    public void beforeClass(){

        System.out.println("Her class'tan önce calisir");
    }

    @BeforeMethod
    public void setUp(){

        System.out.println("Junitteki @Before notasyonu gibi her method'tan önce calisir");
    }
    @Test
    public void test01() {
        System.out.println("Test1 calisti");
    }
    @Test
    public void test02() {
        System.out.println("Test2 calisti");
    }
    @Test
    public void test03() {
        System.out.println("Test3 calisti");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("Her şeyden sonra 1 kez çalışır");
    }
    @AfterTest
    public void afterTest() {
        System.out.println(" Testlerden sonra 1 kez çalışır");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("Her class'dan sonra 1 kez çalışır");
    }
    @AfterMethod
    public void tearDown() {
        System.out.println("Junit'teki @After notasyonu gibi her method'dan sonra çalışır");
    }
}
