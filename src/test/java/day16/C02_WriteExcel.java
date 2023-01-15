package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void writeExcelTest() throws Exception {

        // WORKBOOK => SHEET => ROW => CELL  => YAZ => KAYDET

        String path = ".\\src\\test\\java\\resources\\Capitals.xlsx"; // WINDOWS ICIN

        //1- DOSYA AC
        FileInputStream fileInputStream = new FileInputStream(path);

        //2- EXCEL DOSYASINI AC / WORKBOOK AC
        Workbook workBook = WorkbookFactory.create(fileInputStream);

        //3- SAYFAYI/SHEET AC /Sheet 1
        //Sheet sheet1 = workBook.getSheetAt(0); // index ile sayfaya gitme; ilk index 0'dan baslar.
        Sheet sheet1 = workBook.getSheet("Sheet1"); // sheet in ism ile sayfaya gitme. "Sheet1" isimli sayfayı acar.


        Cell cell3 = row1.createCell(2);

        //6- NUFUZ YAZDIR.
        cell3.setCellValue("NUFUS");

        //7- KAYDET : KAYIT ISLEMI "fileOutputStream" ILE YAPILIR.
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workBook.write(fileOutputStream);

        sheet1.getRow(1).createCell(2).setCellValue("4500000");
        sheet1.getRow(2).createCell(2).setCellV        //4- ILK SATIRA GIT / Row
        Row row1 = sheet1.getRow(0); //ilk satıra git.

        //5- ILK SATIR 3.SUTUN CREATE ET. (CREATE=YAZDIR)alue(1000000);




    }


}
