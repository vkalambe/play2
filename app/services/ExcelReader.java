package services;

import models.Book;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {
    public static List<Book> readExcel() {
        List<Book> books=new ArrayList<Book>();
        try {
            FileInputStream file = new FileInputStream(new File("D:\\Book1.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Book book=null;

            while (rowIterator.hasNext()) {
                book=new Book();
                Row row = (Row) rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();



                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    cell.setCellType(CellType.STRING);
                    if (cell.getColumnIndex() == 0) {
                        book.setId(Integer.valueOf( cell.getStringCellValue()));
                    }
                    if (cell.getColumnIndex() == 1) {
                        book.setTitle(cell.getStringCellValue());
                    }
                    if (cell.getColumnIndex() == 2) {
                        book.setPrice(Integer.valueOf(cell.getStringCellValue()));
                    }
                    if (cell.getColumnIndex() == 3) {
                        book.setAuthor(cell.getStringCellValue());
                    }
                }

                books.add(book);
                System.out.println(book.toString());
            }

            //System.out.println(rowCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}
