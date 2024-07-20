package testClasses;

import org.testng.annotations.Test;

public class CheckBoxTest extends BaseClass {
	
	@Test (groups = {"Smoke"})
	
	public void validatingCheckBox() throws Exception
	{
		cob.CheckboxElement();
		System.out.println("Smoke Test");
	}
	
	

}
