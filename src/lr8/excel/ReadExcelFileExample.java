package lr8.excel;

import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelFileExample {
    private static final String FILE_PATH = "src/lr8/excel/example.xlsx";
    private static final String SHEET_NAME = "Songs";

    public static void main(String[] args) {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("Excel-файл не найден: " + FILE_PATH);
            System.out.println("Сначала запустите WriteExcelFileExample, чтобы создать файл.");
            return;
        }

        try (FileInputStream inputStream = new FileInputStream(file);
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {

            XSSFSheet sheet = workbook.getSheet(SHEET_NAME);
            if (sheet == null) {
                System.out.println("Лист с именем '" + SHEET_NAME + "' не найден.");
                System.out.println("Проверьте имя листа в Excel-файле или измените константу SHEET_NAME.");
                return;
            }

            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл занят или недоступен: " + FILE_PATH);
            System.out.println("Закройте файл в Excel и запустите программу повторно.");
        } catch (NotOfficeXmlFileException e) {
            System.out.println("Неверный формат файла. Программа ожидает файл .xlsx.");
            System.out.println("Создайте файл заново через WriteExcelFileExample.");
        } catch (IOException e) {
            System.out.println("Ошибка чтения Excel-файла: " + e.getMessage());
            System.out.println("Проверьте путь к файлу, формат .xlsx и права доступа.");
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка при чтении Excel-файла: " + e.getMessage());
        }
    }
}
