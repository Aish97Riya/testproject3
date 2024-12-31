package exceldata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class xldatacls {

	@Test(dataProvider="xldata")
	public static void printdt(String Name,String Gender)
	{
		System.out.println(Name+"  "+Gender);
	}
	@DataProvider(name="xldata")
	public Object[][] pass() throws IOException
	{
		File f=new File("C:\\Users\\HP\\Desktop\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook bk= new XSSFWorkbook(fis);
		XSSFSheet sh=bk.getSheet("sheet4");
		int r=sh.getLastRowNum();
		r=r+1;
		System.out.println(r);
		int c=sh.getRow(0).getLastCellNum();
		System.out.println(c);
		Object[][]	ob= new Object[r][c];
		for (int i=0;i<r;i++)
		{
			for (int j=0;j<c;j++)
			{
				ob[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return ob;
	
	}
}


