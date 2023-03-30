package com.learning.util;

import com.learning.exceptions.FrameworkException;
import com.learning.exceptions.InvalidExcelFilePathException;
import com.learning.framework.constants.FrameworkConstants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExcelUtil {
    public static List<Map<String, String>> getTestData(String sheetName) {
        List<Map<String, String>> list = null;
        try (FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelFilePath())) {
            XSSFWorkbook workbook = null;
            workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet(sheetName);

            int getLastRowNum = sheet.getLastRowNum();
            int getLastColNum = sheet.getRow(0).getLastCellNum();

            Map<String, String> map = null;
            list = new ArrayList<>();

            for (int i = 1; i <= getLastRowNum; i++) {
                map = new HashMap<>();
                for (int j = 0; j < getLastColNum; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();

                    map.put(key, value);
                }
                list.add(map);

            }
        } catch (FileNotFoundException e) {
            throw new InvalidExcelFilePathException("Excel file you are trying to open is not found");
        } catch (IOException e) {
            throw new FrameworkException("IO exception is thrown for some reason");
        }

        return list;
    }
}
