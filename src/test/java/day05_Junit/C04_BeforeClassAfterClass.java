package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {

    /*
    @BeforeClass ve @AfterClass notasyonlari sadece static method'lar icin calisir.
@BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test method'larinin hepsini ayni anda calistirip
en son @AfterClass'i calistiririz.
    Ama sadece @Before ve @After kullanirsak her test icin @Before ve @After'i kullanir.
 */


    @BeforeClass
    public static void setUp(){
        System.out.println("Bütün Testlerden önce çalısır");
        System.out.println("-----------------------------");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Bütün Testlerden sonra çalıştır");


    }


    @Before
    public void setup01(){
        System.out.println("Her Testlerden önce çalıştı");
        System.out.println("-----------------------------");


    }

    @After
    public void teardown01(){
        System.out.println("Her Test'ten sonra çalışır");
        System.out.println("-----------------------------");


    }


    @Test
    public void test01(){

        System.out.println("ilk test");
        System.out.println("-----------------------------");

    }

    @Test
    public void test02(){

        System.out.println("ikinci test");
        System.out.println("-----------------------------");

    }

    @Test
    @Ignore
    public void test03(){
        System.out.println("ucuncu test");

    }


}
