package com.wangzhe.poiExcel;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * POI解析Excel
 * @author Administrator
 *
 */
public class POIReadExcel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//需要解析的文件
		File file = new File("e:/POI/poi_test.xls");
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(file));
			//获取第一个工作表
//			HSSFSheet sheet = workbook.getSheet("sheet0");
			//读取默认第一个工作表
			HSSFSheet sheet = workbook.getSheetAt(0);
			int firstRowNum = 0;
			//获取最后一行行号
			int lastRowNum = sheet.getLastRowNum();
			for(int i=0;i<=lastRowNum;i++){
				HSSFRow row = sheet.getRow(i);
				//获取当前行最后一个单元格列号
				int lastCellNum = row.getLastCellNum();
				for(int j=0;j<lastCellNum;j++){
					HSSFCell cell = row.getCell(j);
					String value = cell.getStringCellValue();
					System.out.print(value+"  ");
				}
				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
