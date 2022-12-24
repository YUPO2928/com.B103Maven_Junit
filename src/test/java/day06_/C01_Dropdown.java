package day06_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


/*

==> html --> dropdown menu select tag ile yapılır.
==> Eger test sinifinda birden fazla method olusturulmussa @Before kullanilir

 */

public class C01_Dropdown {

        WebDriver driver;

        /*
        Example:
        // Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken.
        // Dogun yilini, ayini, ve gununu su sekilde secer : 2000, January, 10

         */


        @Before
                public void setup(){

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        }
        @After
            public void tearDown(){
            driver.close();

        }

            @Test
                    public void selectByIndexTest() {
                    //1-LOCATE dropdown element
                WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
                WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
                WebElement day = driver.findElement(By.xpath("//select[@id='day']"));

                //2-Select objesi olustur.
                Select yearDropdown = new Select(year);
                Select monthDropDownMenu = new Select(month);
                Select dayDropDownMenu = new Select(day);

                //3- Select objesini kullanarak 3 farklı sekilde secim yapabilirim.
                        /*
                            1-selectByIndex
                            2-selectByValue
                            3-selectByVisibleText
                         */

                yearDropdown.selectByIndex(22); //secenek sırası 0 dan baslar 2000 yılı 23. sırada
                monthDropDownMenu.selectByValue("0"); // option in value degeri ile secim yapılabilir. January seceneginin value si 0
                dayDropDownMenu.selectByVisibleText("10"); // CASE SENSITIVE

            }



             @Test
                public void printAllTest(){

                    //Tum eyalet isimlerini consola yazdıralım.
                 WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
                 Select stateDropDown = new Select(state);
                 List<WebElement> stateList = stateDropDown.getOptions();

                 for(WebElement eachstate:stateList ){
                     System.out.println(eachstate.getText());

                 }

                stateList.stream().forEach(t-> System.out.println(t.getText()));
             }

            /*
                 1) What is dropdown? Dropdown nedir?
                 Dropdown liste olusturmak icin kullanilir.

                 2) How to handle dropdown elements? Dropdown nasil automate edilir?
                -Dropdown'i Locate ederiz
                -Select objecti'i olustururum
                -Select objecti'i ile istedigim secenegi secerim
                 NOT: Select object'i olusturma nedenim, dropdownlarin Select class'i ile olusturulmasi

                 3) Tum dropdown seceneklerini nasil print ederiz?
                 - tum dropdown elementlerini getOptions() methodu ile listeye koyariz
                 - sonra secenekleri loop ile yazdirabiliriz.

                 4) Bir seceneğin secili oldugunu otamate etmek için ne yapılır.
                 Örnek : Gum olarak "10" u sectk ama ya secilmediyse?
                 getFirstSelectedOption() secili olan seceneği return eder. (text return eder.)

            */

            @Test
                public void getSelectedOptionsTest(){

                        //State dropdowndaki varsayılan secili seceneğin 'select a state' oldugunu verify edin.
                       WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
                       Select stateDropDown = new Select(state);
                       String varSayılanText = stateDropDown.getFirstSelectedOption().getText();
                        Assert.assertEquals("Select a State", varSayılanText);

            }




}