package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import constants.Constants;


public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet s;

	public static String getStringdata(int row, int col, String sheet) throws IOException {
		String filepath = Constants.TESTDATAFILE;
		f = new FileInputStream(filepath);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();
	}

	public static String getIntegerdata(int row, int col, String sheet) throws IOException {
		String filepath = Constants.TESTDATAFILE;
		f = new FileInputStream(filepath);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(row);
		XSSFCell c = r.getCell(col);
		int y = (int) c.getNumericCellValue();// convert double to int -type casting
		return String.valueOf(y);// convert int to string

	}

	
}
