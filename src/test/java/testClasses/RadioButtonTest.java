package testClasses;

import org.testng.annotations.Test;

public class RadioButtonTest extends BaseClass{
	

	@Test(groups = {"Smoke"})
	
	public void validatingRadioButton() throws Exception
	{
		rob.RadiobuttonElement();
		System.out.println("Smoke Test");
	}
}
