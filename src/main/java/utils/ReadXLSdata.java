package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class ReadXLSdata
{
    public String[][] getdata(Method m) throws IOException
    {
        String excelSheetName = "Sheet1";
        File f = new File(System.getProperty("user.dir") + "/src/main/java/testdata/emp2.xlsx");
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheetName = wb.getSheet(excelSheetName);

        int totalRows = sheetName.getPhysicalNumberOfRows();
        System.out.println(totalRows);
        Row rowCells = sheetName.getRow(0);
        int totalCols = rowCells.getPhysicalNumberOfCells();
        System.out.println(totalCols);
        DataFormatter format = new DataFormatter();

        String testData[][] = new String[totalRows][totalCols];
        for (int i = 1; i <= totalRows; i++)
        {
            Row row = sheetName.getRow(i);
            if (row != null) {
                for (int j = 0; j < totalCols; j++)
                {
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        testData[i - 1][j] = format.formatCellValue(cell);
                    }
                }
            }
        }
        return testData;
    }
}