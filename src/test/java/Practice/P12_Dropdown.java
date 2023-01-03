package Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class P12_Dropdown extends TestBase {

    @Test
    public void test01(){
        //Amazon sayfasına gidelim.
        //Dropdown menuyu yazdıralım.
        //Dropdown menuyu baby seçelim.
        //arama bölümünden milk aratalım.

        //Amazon sayfasına gidelim.
        driver.get("https://www.Amazon.com");

        //Dropdown menuyu yazdıralım.
            //1.yol-----
        List<WebElement> dropdown1 = driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
        dropdown1.forEach(t-> System.out.println(t.getText()));

            //2.yol-----
        WebElement dropdown2 = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropdown2);
        for (WebElement w:select.getOptions()) {
            System.out.println(w.getText());
        }

        //Dropdown menuyu baby seçelim.
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby", Keys.TAB, "Milk", Keys.ENTER);

    }
}
