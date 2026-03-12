package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExelUtil {
	
	public static Object[][] getTestData() throws Exception 
	{
    
		FileInputStream file=new FileInputStream(System.getProperty("user.dir") + "/testdata/login.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet("Sheet1");
		int row=sheet.getPhysicalNumberOfRows();
		int col=sheet.getRow(0).getLastCellNum();
		Object[][] obj=new Object[row-1][col];
		for(int i=1;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				obj[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		workbook.close();
		return obj;
		
	}

}
