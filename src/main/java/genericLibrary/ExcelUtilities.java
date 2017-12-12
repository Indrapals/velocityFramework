package genericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtilities {

	
	/**
	 * @author Indrapal Singh
	 * To configure, read and write excel file(Testdata file) 
	 */
	private static XSSFWorkbook ExcelWBook;

	private static XSSFSheet ExcelWSheet;

	private static XSSFCell Cell;

	private static XSSFRow Row;
	
	public static void setExcelFile(String Path,String SheetName) throws Exception {

			try {

   			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheetAt(0);

			} catch (Exception e){

				throw (e);

			}

	}
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

    public static String getCellData(int RowNum, int ColNum) throws Exception{

			try{
	
			ExcelUtilities.setExcelFile(ConfigProperties.getObject("pathTestData"),ConfigProperties.getObject("sheetName"));

  			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

  			String CellData = Cell.getStringCellValue();

  			return CellData;

  			}catch (Exception e){

				return"";

  			}

    }
  //This method is to write in the Excel cell, Row num and Col num are the parameters

	public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

			try{

  			Row  = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

				} else {

					Cell.setCellValue(Result);

				}

			// Constant variables Test Data path and Test Data file name

  				FileOutputStream fileOut = new FileOutputStream(ConfigProperties.getObject("pathTestData"));

  				ExcelWBook.write(fileOut);

  				fileOut.flush();

					fileOut.close();

				}catch(Exception e){

					throw (e);

			}

		}

}