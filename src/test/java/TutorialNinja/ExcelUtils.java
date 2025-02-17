package TutorialNinja;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("File not found at: " + filePath);
        }

        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            fis.close();
            throw new IOException("Sheet " + sheetName + " not found in the file: " + filePath);
        }

        int rows = sheet.getLastRowNum();
        int columns = sheet.getRow(0).getLastCellNum();
        Object[][] excelData = new Object[rows][columns];

        for (int i = 1; i <= rows; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < columns; j++) {
                Cell cell = (row != null) ? row.getCell(j) : null;
                excelData[i - 1][j] = (cell != null) ? cell.toString() : "";
            }
        }

        workbook.close();
        fis.close();
        return excelData;
    }
}
