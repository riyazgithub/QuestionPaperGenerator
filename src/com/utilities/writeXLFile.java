package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class writeXLFile {

	public static String fileName = "partA.xls";
	public writeXLFile(){

	}

	public void updateXL(cellInfo cellUpdate) throws IOException{
		FileInputStream fin = new FileInputStream(writeXLFile.fileName);
		POIFSFileSystem fs = new POIFSFileSystem(fin);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row;
		HSSFCell cell;	
		
		row = sheet.getRow(cellUpdate.getRowNumber());
		cell = row.getCell(2);
		cellUpdate.setCount(cellUpdate.getCount()+1);
		cell.setCellValue((cellUpdate.getCount())+"");
		
		FileOutputStream fos = new FileOutputStream("partA.xls");
		wb.write(fos);
		fos.close();
		wb.close();
	}

	private  void writeXL(String fileName) {
		try {
			FileInputStream fin = new FileInputStream(fileName);
			POIFSFileSystem fs = new POIFSFileSystem(fin);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFRow row;
			HSSFCell cell;
			HSSFCell cell1;

			int rows; // No of rows
			
			rows = sheet.getPhysicalNumberOfRows();

			int cols = 0; // No of columns
			int tmp = 0;

			for (int i = 0; i < 10 || i < rows; i++) {
				row = sheet.getRow(i);
				if (row != null) {
					tmp = sheet.getRow(i).getPhysicalNumberOfCells();
					if (tmp > cols)
						cols = tmp;
				}
			}

			//constructing data structure
			
			HashMap<String, LinkedList<String>> hm = new HashMap<String, LinkedList<String>>();
			
			for (int r = 0; r < rows; r++) {
				row = sheet.getRow(r);
				if (row != null) {
				cell = row.getCell(1);	
				if(hm.get(cell+"")==null)
					hm.put(cell+"", new LinkedList<String>());
			
					LinkedList<String> ll = hm.get(cell+"");
					ll.add(row.getCell(0)+"");
				System.out.println(row.getCell(2));
				cell1=row.getCell(2);
				cell1.setCellValue(cell1.getNumericCellValue()+1);
				System.out.println(row.getCell(2));
				
					
//					for (int c = 0; c < cols; c++) {
//						cell = row.getCell(c);
//						if (cell != null) {
//							System.out.println(cell.getCellType());
//						}
//					}
				}
					
			}	
			System.out.println(hm);
			FileOutputStream fos = new FileOutputStream("partA.xls");
			wb.write(fos);
			fos.close();
			wb.close();
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
	}

}
