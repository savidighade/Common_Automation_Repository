package democlasses;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class launchBrowser {
	public WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;

	@Test
	public void launchBrowser() throws InterruptedException, IOException {
		FileReader fr = new FileReader(
				"C:\\Users\\savita.dighade\\Downloads\\PractiseFramework 11\\Automation_Practise\\src\\"
						+ "main\\resources\\configFiles\\config.properties");

		prop.load(fr);

		WebDriverManager.edgedriver().setup();

		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("testurl"));

		Thread.sleep(3000);

	}
}
