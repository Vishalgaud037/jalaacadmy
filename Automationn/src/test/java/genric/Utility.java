package genric;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {

	public static String getProperty(String filepath, String key) throws FileNotFoundException, IOException {
	Properties p= new Properties();
	p.load(new FileInputStream(filepath));
	String value = p.getProperty(key);
	return value;
	
	}
	public static String getData(String path, String sheet, int r, int c) throws IOException {
		 Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		String value = wb.getSheet(sheet).getRow(r).getCell(c).getStringCellValue();
		
	wb.close();
	
	return value;
	
	}
	
	
	
		
	

	
	}

