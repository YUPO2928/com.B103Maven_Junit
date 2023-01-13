package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_Screenshot2 extends TestBase {

    @Test
    public void screenShotOfSpecificElements() throws IOException {

        // Techpro education a git.
        driver.get("https://www.techproeducation.com");

        // Sosyal medya elemanlarını goruntusunu al.
        WebElement sosyalMedyaIkonlari =  driver.findElement(By.xpath("(//div[@class='elementor-widget-container'])[1]"));

        //1-ekran görüntüsünü cek.
        File image =  sosyalMedyaIkonlari.getScreenshotAs(OutputType.FILE);

        //2-görüntüyü yolunu olustur.
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        //3-Goruntuyu kaydet.              (folder / folder/file name)
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));

        //LOGO NUN EKRAN GORUNTUSUNU AL
        takeScreenshotOfElement(driver.findElement(By.xpath("//img[@class='attachment-large size-large lazyloaded']")));

    }



}