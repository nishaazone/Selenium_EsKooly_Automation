//package utils;
//
//import org.apache.poi.ss.usermodel.*;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.lang.reflect.Method;
//
//public class ReadXLSdata
//{
//    public String[][] getdata(Method m) throws IOException
//    {
//        String excelSheetName = "Sheet1";
//        File f = new File(System.getProperty("user.dir") + "/src/main/java/testdata/emp2.xlsx");
//        FileInputStream fis = new FileInputStream(f);
//        Workbook wb = WorkbookFactory.create(fis);
//        Sheet sheetName = wb.getSheet(excelSheetName);
//
//        int totalRows = sheetName.getPhysicalNumberOfRows();
//        System.out.println(totalRows);
//        Row rowCells = sheetName.getRow(0);
//        int totalCols = rowCells.getPhysicalNumberOfCells();
//        System.out.println(totalCols);
//        DataFormatter format = new DataFormatter();
//
//        String testData[][] = new String[totalRows][totalCols];
//        for (int i = 1; i <= totalRows; i++)
//        {
//            Row row = sheetName.getRow(i);
//            if (row != null) {
//                for (int j = 0; j < totalCols; j++)
//                {
//                    Cell cell = row.getCell(j);
//                    if (cell != null) {
//                        testData[i - 1][j] = format.formatCellValue(cell);
//                    }
//                }
//            }
//        }
//        return testData;
//    }
//}




package utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ExcelReader
{
    private String filePath;
    private String sheetName;
    public ExcelReader(String filePath, String sheetName)
    {
        this.filePath = filePath;
        this.sheetName = sheetName;
    }
    public List<Map<String, String>> readExcelData() throws IOException
    {
        List<Map<String, String>> data = new ArrayList();
        FileInputStream excelFile = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheet(sheetName);
        // Read header row to determine column positions
        Row headerRow = sheet.getRow(0);
        Map<String, Integer> columnPositions = new HashMap<>();
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            Cell cell = headerRow.getCell(i);
            columnPositions.put(cell.getStringCellValue(), i);
        }

        // Read data rows
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row dataRow = sheet.getRow(i);
            Map<String, String> rowData = new HashMap<>();
            for (String columnName : columnPositions.keySet()) {
                int columnIndex = columnPositions.get(columnName);
                Cell cell = dataRow.getCell(columnIndex);
                if (cell != null) {
                    rowData.put(columnName, cell.getStringCellValue());
                } else {
                    rowData.put(columnName, ""); // Handle empty cells
                }
            }
            data.add(rowData);
        }
        excelFile.close();
        return data;
    }
}