package com.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class readXLFile {

	public readXLFile(){
		
	}


	public  HashMap<String, LinkedList<cellInfo>> readXL(String fileName) {
		
		
		HSSFRow row;
		HSSFCell cell;
		HashMap<String, LinkedList<cellInfo>> hm = new HashMap<String, LinkedList<cellInfo>>();	
		try {
			FileInputStream fin = new FileInputStream(fileName);
			POIFSFileSystem fs = new POIFSFileSystem(fin);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			LinkedList<cellInfo> ll;
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
			
	
			
			for (int r = 1; r < rows; r++) {
				row = sheet.getRow(r);
				if (row != null) {
				cell = row.getCell(1);	
				if(hm.get(cell+"")==null)
					hm.put(cell+"", new LinkedList<cellInfo>());
			
					 
					ll = hm.get(cell+"");
					HSSFCell levelCell,countCell;
					levelCell = row.getCell(1);
					countCell =  row.getCell(2);
					
					cellInfo cellinfo=new cellInfo(row.getCell(0)+"", (Double.parseDouble(levelCell+"")), (Double.parseDouble(countCell+"")),row.getRowNum());
					ll.add(cellinfo);

				}
					
			}
			// Sorting Linked list
			
			
			Set<String> keySet= hm.keySet();
			for(String key:keySet)
			{
				ll=hm.get(key);
//				System.out.println("LL1 - sort: "+ll);
				Collections.sort(ll,new cellInfoComparator());
//				System.out.println("LL1: "+ll);

			}
			
			wb.close();
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
		
		return hm;
	}
	
	

}
