package day11;
import org.junit.Assert;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
public class C03_FileExist {
    @Test
    public void isExistTest(){
        String userDIR = System.getProperty("user.dir");
        System.out.println(userDIR);//C:\Users\Yunus\IdeaProjects\com.B103Maven_Junit

        String userHOME =  System.getProperty("user.home");
        System.out.println(userHOME);//C:\Users\Yunus

        //logo.jpeg indirip MASAUSTUNE kaydedin
//        Logo masaustunde : /Users/Yunus/Desktop

        String dosyaYolu = userHOME +"/Desktop/logo.jpeg";
//        String dosyaYolu = userHOME +"\\Desktop\\logo.jpeg";
        System.out.println(dosyaYolu);
        boolean isExist = Files.exists(Paths.get(dosyaYolu));//doyda var ise tru, yok ise false
        Assert.assertTrue(isExist);
        /*
        1. fail -> PATH YANLIS : dosya masa ustunde degil, dosya adi yanlis, yada arada onedrive gibi ex dosyalar olarak
         */
    }
}
