package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {

    @Test
    public void readExcelTest() throws Exception {

// WORKBOOK(EXCEL DOSYASI) => WORKSHEET/SHEET(SAYFA) => ROW(SATIR) => CELL(VERI HUCRESI)

        //String path = "./src/test/java/resources/Capitals.xlsx"; => MAC ICIN
        String path = ".\\src\\test\\java\\resources\\Capitals.xlsx"; // WINDOWS ICIN

        //1- DOSYA AC
        FileInputStream fileInputStream = new FileInputStream(path);

        //2- EXCEL DOSYASINI AC / WORKBOOK AC
        Workbook workBook = WorkbookFactory.create(fileInputStream);

        //3- SAYFAYI/SHEET AC /Sheet 1
        //Sheet sheet1 = workBook.getSheetAt(0); // index ile sayfaya gitme; ilk index 0'dan baslar.
        Sheet sheet1 = workBook.getSheet("Sheet1"); // sheet in ism ile sayfaya gitme. "Sheet1" isimli sayfayı acar.

        //4- ILK SATIRA GIT / Row
        Row row1 = sheet1.getRow(0); //ilk satıra git.

        //5- ILK SATIRDAKI VERIYI AL
        Cell cell1 = row1.getCell(0); // ilk hücredeki datayı verir.

        //6- ALINAN VERIYI YAZDIR
        System.out.println("cell1 = " + cell1);

            //1. SATIR 2. SUTUN
            Cell cell12 = sheet1.getRow(0).getCell(1);
            System.out.println("cell12 = " + cell12);

            //3.SATIR 1.SUTUN YAZDIR VE "FRANCE" OLDUGUNU TEST ET.
            String  cell31 = workBook.getSheet("Sheet1").getRow(2).getCell(0).toString(); //data type ini string e dönüstürdük.
            System.out.println("cell31 = " + cell31);
            Assert.assertEquals("France", cell31);

            // Excel deki toplam Satır sayısını bul.
            int toplamSatirSayisi = sheet1.getLastRowNum()+1; // son satır numarası. index 0 dan basladıgı için sayma sayıları 1 den baslıyor bu sebeple 1 ekledik
            System.out.println("toplamSatırSayısı = " + toplamSatirSayisi);

            //Kullanılan toplam satır sayısını bul.
            int kullanilanToplamSatirSayisi = sheet1.getPhysicalNumberOfRows();
            System.out.println("kullanılanToplamSatırSayısı = " + kullanilanToplamSatirSayisi); //1 den baslıyor.

            //COUNTRY, CAPITALS key ve value ları map a alıp print et.
            //{{USA, D.C}, {FRANCE, PARIS}, ...}

            //Variable olusturalım. Bu variable exceldeki country, capital
            Map<String,String> ulkeBaskentleri = new HashMap<>();
            for(int satirSayisi=1; satirSayisi<kullanilanToplamSatirSayisi; satirSayisi++){
            String country = sheet1.getRow(satirSayisi).getCell(0).toString();
            String capital = sheet1.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country, capital);
            }
            System.out.println(ulkeBaskentleri);

    }
}
