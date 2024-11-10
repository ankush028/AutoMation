package com.qacapital2.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {


    /**
     * @purpose To read data from excel sheet
     * @param
     * @return data of excel sheet in 2D array
     */
    public static Object[][] getData() throws IOException {
        String filePath = "//home//ankush//Downloads//file_example_XLSX_50.xlsx";
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Object[][] data = null;
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();
        data = new Object[rowCount - 1][colCount];
        for (int i = 1; i < rowCount - 1; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                if (cell != null) {
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            data[i - 1][j] = cell.getNumericCellValue();
                            break;
                        case STRING:
                            data[i - 1][j] = cell.getStringCellValue();
                            break;
                        case BOOLEAN:
                            data[i - 1][j] = cell.getBooleanCellValue();
                            break;
                    }
                }
            }
        }
            return data;
        }
        public static Object[][] getHardData(){
        Object[][] obj = {
                {"Ankush","Agrawal"},
                {"Boom","Boom2"}
        };


            return obj;
        }
    }
