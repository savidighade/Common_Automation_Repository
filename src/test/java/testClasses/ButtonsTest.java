package testClasses;

import org.testng.annotations.Test;

public class ButtonsTest extends BaseClass {

	@Test (groups = {"Smoke"})
	public void validatingButtons() throws Exception
	{
		bp.buttonsElement();
		System.out.println("Smoke Test");
	}
}
