package Practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;

public class P38_ReadExcel extends TestBase {

    @Test
     public void readExcelTest() throws IOException {

        //Bilgisayarınızdaki data isimli excel dosyasından kullanıcı bilgilerini alıp
        String dosyaYolu = "C:\\Users\\Yunus\\Desktop\\data.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        String email = workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString();
        System.out.println(email);

        String password = workbook.getSheet("Sayfa1").getRow(2).getCell(1).toString();
        System.out.println(password);


        //https://www.bluerentalcars.com/ adresine gidip.
        driver.get("https://www.bluerentalcars.com/ adresine gidip.");

        //Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım.
        driver.findElement(By.xpath("//*[@class='btn btn-primary btn-sm']")).click();
        WebElement emailAddress = driver.findElement(By.id("formBasicEmail"));
        emailAddress.sendKeys(email, Keys.TAB,password,Keys.ENTER);

        //Login olduğumuzu doğrulayalım.
        WebElement Login = driver.findElement(By.id("dropdown-basic-button"));
        assert Login.getText().equals("Erol Evren");








    }


}
