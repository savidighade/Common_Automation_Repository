package testClasses;

import org.testng.annotations.Test;

import democlasses.baseTestClass;

public class testBrowser extends baseTestClass
{
	@Test (groups={"imp"})
	public void validateCheckboxPage() throws Exception
	{
		tp.CheckboxElement();
		System.out.println("Smoke Test");
	}
	

}
