package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readData(String fileName) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+ fileName +".xlsx");
		XSSFSheet wbs = wb.getSheetAt(0);
		XSSFRow wbsrow = wbs.getRow(1);
		XSSFCell cell = wbsrow.getCell(0);
		String celldata = cell.getStringCellValue();
		System.out.println(celldata);

		int rowNo = wbs.getLastRowNum();
		/*
		 * for (int i = 1; i <= rowNo; i++) { XSSFRow row = wbs.getRow(i); XSSFCell
		 * cell2 = row.getCell(0); String celldata = cell2.getStringCellValue();
		 * System.out.println(celldata);
		 */
      
		short cellNo = wbs.getRow(0).getLastCellNum();
       String[][] data =new String[rowNo][cellNo];
		for (int i = 1; i <= rowNo; i++) {
			for (int j = 0; j < cellNo; j++) {
				XSSFRow row = wbs.getRow(i);
				XSSFCell cells = row.getCell(j);
				String cellDetails = cells.getStringCellValue();
				data[i-1][j] = cellDetails;
				 
				
				/*
				 * System.out.println(datas); wb.close();
				 */
			}

		}
		return data;

	}

}
