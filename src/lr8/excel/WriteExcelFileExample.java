package lr8.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelFileExample {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("Songs");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Название");
        headerRow.createCell(1).setCellValue("Исполнитель");
        headerRow.createCell(2).setCellValue("Год выпуска");
        headerRow.createCell(3).setCellValue("Жанр");

        Row dataRow1 = sheet.createRow(1);
        dataRow1.createCell(0).setCellValue("Bohemian Rhapsody");
        dataRow1.createCell(1).setCellValue("Queen");
        dataRow1.createCell(2).setCellValue(1975);
        dataRow1.createCell(3).setCellValue("Rock");

        Row dataRow2 = sheet.createRow(2);
        dataRow2.createCell(0).setCellValue("Billie Jean");
        dataRow2.createCell(1).setCellValue("Michael Jackson");
        dataRow2.createCell(2).setCellValue(1982);
        dataRow2.createCell(3).setCellValue("Pop");

        Row dataRow3 = sheet.createRow(3);
        dataRow3.createCell(0).setCellValue("Smells Like Teen Spirit");
        dataRow3.createCell(1).setCellValue("Nirvana");
        dataRow3.createCell(2).setCellValue(1991);
        dataRow3.createCell(3).setCellValue("Grunge");

        String filePath = "src/lr8/excel/example.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("Данные записаны в файл: " + filePath);
    }
}
