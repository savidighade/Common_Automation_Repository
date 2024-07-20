package testClasses;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilclasses.ExcelReader;

public class WebTablesTest extends BaseClass
{
	
	@DataProvider(name = "data")
	 
	public Object[][] readExcelData()
 
	{
		String FilePath="\\testdataDemoqa.xlsx";
		String testDataFile=WORKING_DIR+System.getProperty("file.separator")+FilePath;
		return ExcelReader.readData(testDataFile,"WebtablesElement");
			}
	
	@Test (dataProvider = "data", groups = "Regression")
	public void validatingWebTables(Map<String, String> input) throws Exception
	{
		wtb.webTablesElement(input);
	}

}
