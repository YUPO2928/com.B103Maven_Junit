package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.List;

public class Iframe_ClassWork_1  {

    //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    // ikinci emojiye tıklayın
    // ikinci emoji altındaki tüm öğelere tıklayın
    // ana iframe'e geri dön
    //formu doldurun,(Formu istediğiniz metinlerle doldurun)
    // uygula butonuna tıklayın.

    WebDriver driver;

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test
    public void test01(){
        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total iFrames : " + size);
        WebElement iframe=driver.findElement(By.xpath("(//iframe[@id='emoojis'])"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // ikinci emoji altındaki tüm öğelere tıklayın
        List<WebElement> animal = driver.findElements(By.xpath("//*[@class='mdl-tabs__panel is-active']//img"));

        animal.stream().forEach(t-> t.click());
        // ana iframe'e geri dön
        driver.switchTo().defaultContent();

        //formu doldurun,(Formu istediğiniz metinlerle doldurun)
        // uygula butonuna tıklayın.
        driver.findElement(By.id("text")).sendKeys("Yunus",
                Keys.TAB, "POYRAZ",
                Keys.TAB, "ANKARA",
                Keys.TAB, "ISTANBUL",
                Keys.TAB, "URFA",
                Keys.TAB, "IZMIR",
                Keys.TAB, "BURSA",
                Keys.TAB, "ANTAKYA",
                Keys.TAB, "ADANA",
                Keys.TAB, "BALIKESIR",
                Keys.TAB, "MILAS",
                Keys.TAB,
                Keys.ENTER);

    }

}
