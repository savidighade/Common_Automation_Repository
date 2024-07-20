package testClasses;

import java.util.Map;

import org.openqa.selenium.devtools.v85.input.Input;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilclasses.ExcelReader;

public class TextBoxTest extends BaseClass {

	@DataProvider(name = "data")

	public Object[][] readExcelData()

	{
		String FilePath = "\\testdataDemoqa.xlsx";
		String testDataFile = WORKING_DIR + System.getProperty("file.separator") + FilePath;
		return ExcelReader.readData(testDataFile, "TextboxSheet");

	}

	@Test(dataProvider = "data", groups = "Regression")
	public void validatingTextBox(Map<String, String> input) throws Exception {
		tbp.textBoxElement(input);
		System.out.println("Regression Test");
	}

}
