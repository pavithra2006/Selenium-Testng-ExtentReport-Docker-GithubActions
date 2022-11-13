package com.learning.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public final class SendDataFromExcelToDataProviderThenToTest {
    @Test(dataProvider = "getDataFromJson")
    public void printValueInConsole(HashMap map){
        map.forEach((k,v) -> System.out.println("key:" + k + ", value: " + v));
    }

    @DataProvider
    public Object[] getDataFromJson() throws IOException {

        HashMap<String, String> map1 = new ObjectMapper()
                .readValue(new File(System.getProperty("user.dir") + "/src/test/resources/data1.json"),
                        new TypeReference<HashMap<String, String>>() {});

        HashMap<String, String> map2 = new ObjectMapper()
                .readValue(new File(System.getProperty("user.dir") + "/src/test/resources/data2.json"),
                        new TypeReference<HashMap<String, String>>() {});

        return new Object[]{map1, map2};
    }

    @DataProvider
    public Object[] getDataUsingHashMap() throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/learning/tests/TestDataSheet.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Data");

        int rowNum = sheet.getLastRowNum();
        int colNum = sheet.getRow(0).getLastCellNum();

        HashMap<String, String> map;
        Object[] data = new Object[rowNum];

        for(int i = 1; i < rowNum+1; i++){
            map = new HashMap<>();
            for(int j = 0; j < colNum; j++){
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value);
                data[i-1] = map;
            }
        }

        return data;
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
