package com.wangzhe.jxlExcel;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * JXL创建Excel
 * @author Administrator
 *
 */
public class JXLExpExcel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] title = {"id","name","sex"};

		File file = new File("e:/POI/jxl_test.xls");
		try {
			file.createNewFile();
			//创建工作薄
			WritableWorkbook workbook = Workbook.createWorkbook(file);
			//创建sheet
			WritableSheet sheet = workbook.createSheet("sheet1", 0);
			Label label =null;
			for(int i=0;i<title.length;i++){
				//Label(列，行,内容)
				label = new Label(i,0,title[i]);
				sheet.addCell(label);
			}
			//追加数据
			for(int i=1;i<10;i++){
				label = new Label(0,i,"a"+i);
				sheet.addCell(label);
				label = new Label(1,i,"user"+i);
				sheet.addCell(label);
				label = new Label(2,i,"男");
				sheet.addCell(label);
			}
			//写入数据
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
