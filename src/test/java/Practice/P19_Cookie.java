package Practice;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class P19_Cookie extends TestBase {

    /*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.

     */

    @Test
    public void CookieTest01() throws InterruptedException {

        //Techproeducation adresine gidiniz.
        driver.get("https://www.techproeducation.com");
        Thread.sleep(5000);

        //Sayfadaki cookie lerin sayısını yazdırınız.
        Set<Cookie> cookies = driver.manage().getCookies();

        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız.
        System.out.println("cookies.size() = " + cookies.size());
        cookies.stream().forEach(t-> System.out.println(t.getName()+ " : " + t.getValue()));

        //Yeni bir cookie ekleyiniz.
        Cookie myCookie = new Cookie("myCookie","123456789"); //cookie oluşturduk.
        driver.manage().addCookie(myCookie); //yeni oluşturdugumuz cookie'yi ekledik.

        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız.
        Set<Cookie> cookies2 = driver.manage().getCookies();
        System.out.println("cookies2.size() = " + cookies2.size());

        cookies2.stream().forEach(t-> System.out.println(t.getName()+ " : " + t.getValue()));

        //Oluşturduğumuz cookie'i silelim.
        driver.manage().deleteCookie(myCookie);
        Set<Cookie> cookies3 = driver.manage().getCookies();
        System.out.println(cookies3.size());

        //Tüm cookieleri silelim.
        driver.manage().deleteAllCookies();
        Set<Cookie> cookies4 = driver.manage().getCookies();
        System.out.println(cookies4.size());



    }

}
