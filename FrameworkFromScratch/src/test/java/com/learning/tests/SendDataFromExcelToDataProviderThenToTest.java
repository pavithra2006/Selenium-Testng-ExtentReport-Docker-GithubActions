package com.learning.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public final class SendDataFromExcelToDataProviderThenToTest {
    @Test(dataProvider = "getDataProviderFromExcel")
    public void printValueInConsole(String id, String fn, String ln, String age){
        System.out.println("id:" + id);
        System.out.println("fn:" + fn);
        System.out.println("ln:" + ln);
        System.out.println("age:" + age);
    }

    @DataProvider
    public Object[][] getDataProviderFromExcel() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/learning/tests/TestDataSheet.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Data");

        int rowNum = sheet.getLastRowNum();
        int colNum = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowNum][colNum];
        for(int i = 1; i < rowNum+1; i++){ // first row
            for(int j = 0; j < colNum; j++){
                data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }

        return data;
    }

}
