package myPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyMain {

	public static void main(String[] args) throws IOException {
		//----Create new workbook
		File f = new File("src\\myPackage\\myExcel.xlsx");
		System.out.println(f.getAbsolutePath());
		if(f.exists())
			f.delete();
		f.createNewFile();
		FileOutputStream fos = new FileOutputStream(f);
		XSSFWorkbook wb1 = new XSSFWorkbook();
		wb1.write(fos);
		wb1.close();
		
		//-----Open existing workbook
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		if(f.isFile()&&f.exists()) {
			System.out.println("Workbook Opened");
		}else
			System.out.println("Error while Opening Workbook");
		
		//------Create new sheet
		XSSFSheet sheet1 = wb.createSheet("Main");
		System.out.println("WorkSheet 'Main' Created");
		
		//------Write into the sheet
		XSSFRow row;
		Map<String, Object[]> hm = new HashMap<String, Object[]>();
		hm.put("1", new Object[] {"EMP ID","EMP Name", "Designation"});
		hm.put("2", new Object[] {"381936","Prasad Borle", "Sr Test Engineer"});
		
		int rowId = 0;
		for(String key : hm.keySet()) {
			row = sheet1.createRow(rowId++);
			int cellId = 0;
			for(Object o : hm.get(key)) {
				Cell cell = row.createCell(cellId++);
				cell.setCellValue((String) o);
			}
		}
		System.out.println("Data Written");
		
		//------save the workbook
		FileOutputStream fos1 = new FileOutputStream(f);
		wb.write(fos1);
		fos1.close();
		fis.close();
		wb.close();
		System.out.println("Workbook Closed");
		
		//-------read a workbook
		FileInputStream fis2 = new FileInputStream(f);
		XSSFWorkbook wb2 = new XSSFWorkbook(fis2);
		XSSFSheet sheet2 = wb2.getSheetAt(0);
		Iterator<Row> rItr = sheet2.rowIterator();
		System.out.println("Reading Data....");
		while(rItr.hasNext()) {
			Row rowX = rItr.next();
			Iterator<Cell> cItr = rowX.cellIterator();
			while(cItr.hasNext()) {
				Cell cellX = cItr.next();
				CellType ct;
				switch(cellX.getCellTypeEnum()) {//_NONE,BLANK,BOOLEAN,FORMULA,NUMERIC,STRING,ERROR
				case NUMERIC:
					System.out.print(cellX.getNumericCellValue()+"\t");
					break;
				case STRING:
					System.out.print(cellX.getStringCellValue()+"\t");
					break;
				}
			}
			System.out.print("\n");
		}
		fis2.close();
		wb2.close();
	}

}
