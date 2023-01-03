package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P13_Alert extends TestBase {

    //    go to url :http://demo.automationtesting.in/Alerts.html
    //    click  "Alert with OK" and click 'click the button to display an alert box:'
    //    accept Alert(I am an alert box!) and print alert on console
    //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    //    cancel Alert  (Press a Button !)
    //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    //    and then sendKeys 'TechProEducation' (Please enter your name)
    //    finally print on console this message "Hello TechproEducation How are you today"
    //    aseertion these message

    @Test
    public void test01() throws InterruptedException {

        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        WebElement alert = driver.findElement(By.xpath("//*[@onclick='alertbox()']"));
        alert.click();

        //    accept Alert(I am an alert box!) and print alert on console
        System.out.println(driver.switchTo().alert().getText()); // Alert üzerindeki yazıyı konsola yazdırdık.
        driver.switchTo().alert().accept();

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();

        //    cancel Alert  (Press a Button !)
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//*[text()='click the button to demonstrate the prompt box ']")).click();
        driver.switchTo().alert().sendKeys("TechProEducation");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        //    finally print on console this message "Hello TechproEducation How are you today"
        System.out.println(driver.findElement(By.id("demo1")).getText());

        //    aseertion these message
        Assert.assertNotEquals("Hello TechproEducation How are you today",driver.findElement(By.id("demo1")).getText());








    }

}
