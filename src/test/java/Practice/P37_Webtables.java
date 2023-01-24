package Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P37_Webtables  extends TestBase {

    @Test
    public void Webtablestest(){

        //https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim.
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        //Demo Table altındaki tablodaki otel bilgilerini yazdırınız.
        List<WebElement> otelBilgileri = driver.findElements(By.xpath("//*[@class='tsc_table_s13']//tbody//tr"));
        otelBilgileri.forEach(t-> System.out.println(t.getText()));

        //Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız.
            //1.yol:
            int row=1;
            for (WebElement w:otelBilgileri) {
                if (w.getText().contains("601")){
                    System.out.println("Tablodaki "+row+".satırdaki otel bilgileri : "+w.getText());
                }
                row++;
             }

            //2.yol:
            System.out.println(
                driver.findElements(By.xpath("//*[@border='1']//tbody/tr")).
                        stream().filter(t -> t.getText().contains("601m")).
                        findFirst().get().getText());

        //Bütün Height bilgilerini yazdırınız.
        List<WebElement> heightBilgileri = driver.findElements(By.xpath("//*[@class='tsc_table_s13']//tbody//tr//td[3]"));
        heightBilgileri.forEach(t-> System.out.println(t.getText()));

        //Otel uzunluklarının hepsini toplayınız.
        List<String> list = new ArrayList<>();
        for (WebElement q:heightBilgileri) {
            list.add(q.getText());            // yükseklikleri bir liste attık.
        }
        for (int i=0; i<list.size(); i++){
            list.set(i, list.get(i).replace("m","")); // yüksekliklerden "m" yi kaldırdık
        }
        list.forEach(System.out::println);

        int toplam = 0;
        for (String s:list){
            toplam=toplam+Integer.parseInt(s);
            //toplam = toplam + Integer.valueOf(s); 2.yol
        }
        System.out.println("Otellerin toplam uzunluğu = "+toplam);

        //Bir method ile satır ve sutun bilgilerini çağıralım.
        tabloSatırSutun(3,3); //asagıdaki method'u kullandık.


    }

    private  void tabloSatırSutun(int satir, int sutun){
        System.out.println(satir +". satır"+sutun+" .s sutun bilgisi : "+driver.findElement(By.xpath("//*[@class='tsc_table_s13']//tbody//tr["+satir+"]//td["+sutun+"]")).getText());


    }



}
