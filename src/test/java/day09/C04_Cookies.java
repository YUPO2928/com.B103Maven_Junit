package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {

    @Test
    public void handleCookiesTest() {

        // 1. Amazona git.
        driver.get("https://www.amazon.com");
        waitFor(2);

        // 2. toplam cookie sayisini bul.
        Set<Cookie> allCookies = driver.manage().getCookies(); //toplam cerez sayısı
        int cookiesSayısı = allCookies.size();
        System.out.println("cookiesSayısı = " + cookiesSayısı + " adet cookies var");

        // 3. Tum cookies'i yazdıralım.
        for(Cookie eachCookie : allCookies){
            System.out.println("COOKIES : " +eachCookie);
            System.out.println("COOKIES ISIMLERI : " +eachCookie.getName());
        }

        // 4. Bir Cookie yi ismiyle bul.
        System.out.println(driver.manage().getCookieNamed("i18n-prefs")); //cookie'yi ismi ile cagırıyorum.

        // 5. Yeni bir cookie ekle.
        Cookie favoriCookie = new Cookie("Cilolotam","antep-Fıstıklı-Cikilota"); // cookie olusturduk. (MAP)
        driver.manage().addCookie(favoriCookie);
        waitFor(3);
        System.out.println("cookiesSayısı = " + cookiesSayısı + " adet cookies var");

        // 6. Bir Cookie yi ismi ile sil.
        driver.manage().deleteCookieNamed("session-id-time");
        waitFor(3);

        // 7. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        waitFor(5);
        System.out.println("TUM COOKIES LERI SILDIM. YENI COOKIE SAYISI : "+driver.manage().getCookies().size());




    }
}