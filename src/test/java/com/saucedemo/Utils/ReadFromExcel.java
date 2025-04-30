package com.saucedemo.Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFromExcel {

    public static String testData_dir = System.getProperty("user.dir")+ "/src/test/java/com/saucedemo/TestData/data.xlsx";

    static FileInputStream fileInputStream;

    static {
        try {
            fileInputStream = new FileInputStream(testData_dir);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static XSSFWorkbook workbook;

    static {
        try {
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ReadFromExcel() throws IOException {
    }

    static XSSFSheet sheet=workbook.getSheet("Login Details");
    public static String username=sheet.getRow(1).getCell(0).getStringCellValue();
    public static String password=sheet.getRow(1).getCell(1).getStringCellValue();


}
