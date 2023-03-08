package com.learning.util;

import com.learning.frameworkConstants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelUtil {
    private ExcelUtil() {

    }

    public static List<Map<String, String>> getTestData() {
        FileInputStream fis = null;
        List<Map<String, String>> list = null;
        try {
            fis = new FileInputStream(FrameworkConstants.getExcelFilePath());
            XSSFWorkbook workbook = null;
            workbook = new XSSFWorkbook(fis);
            String sheetName = "Sheet 1";
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int getLastRowNum = sheet.getLastRowNum();
            int getLastColNum = sheet.getRow(0).getLastCellNum();

            System.out.println("row" + getLastRowNum);
            System.out.println("col " + getLastColNum);

            Map<String, String> map = null;
            list = new ArrayList<>();

            for (int i = 1; i <= getLastRowNum; i++) {
                map = new HashMap<>();
                for (int j = 0; j < getLastColNum - 2; j++) {
//                for (int j = 0; j < getLastColNum; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();

                    map.put(key, value);
                }
                list.add(map);
                System.out.println(map + " + map" + i);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (Objects.nonNull(fis)) { // due to some reason if fis is already closed, so do null check and close
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


        return list;
    }
}
