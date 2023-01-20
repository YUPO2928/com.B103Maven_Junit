package day15;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    private static Logger logger = LogManager.getLogger(C02_WebTables.class.getName());

    @Test
    public void WebTablesTest(){

        // https://the-internet.herokuapp.com/tables.
        driver.get("http://the-internet.herokuapp.com/tables");

        // Task 1 : Table1’i print edin.
        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println(table1);
        logger.info("TABLE 1 VERILER");

        // Task 2 : 3. Row’ datalarını print edin.
        List <WebElement> row3Elements = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
        row3Elements.stream().forEach(t-> System.out.println(t.getText()));

        // Task 3 : Son row daki dataları print edin.
        List<WebElement> sonSatir = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
        sonSatir.forEach(veri-> System.out.println(veri.getText()));

        // Task 4 : 5. Column datalarini print edin.
        List<WebElement> besinciSutunTumVeriler = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        besinciSutunTumVeriler.forEach(t-> System.out.println(t.getText()));

        // Task 5 : Iki parametreli bir Java metot oluşturalım: printData
        // Parameter 1 = row numarasi
        // Parameter 2 = column numarasi
        // printData(2,3);  => 2nd row, 3rd column daki datayı print etsin
    }


    public void printData (int satır, int sutun){
        driver.get("http://the-internet.herokuapp.com/tables");
        String myXpath = "//table[@id='table1']//tbody//tr["+satır+"]//td["+sutun+"]";
        System.out.println(driver.findElement(By.xpath(myXpath)).getText());

    }

    @Test
    public void printDataTest(){
        printData(2,3);
    }


}




