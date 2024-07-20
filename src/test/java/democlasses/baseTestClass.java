package democlasses;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageClasses.testCheckBoxPage;

public class baseTestClass {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	public testCheckBoxPage tp;
	public ChromeOptions chromeoptions;
	public EdgeOptions edgeoptions;
	public JavascriptExecutor js;
	public static String WORKING_DIR = System.getProperty("user.dir");

	@BeforeClass(alwaysRun = true)

	public void setup() throws IOException, InterruptedException {

		if (driver == null) {

			// String projectPath = System.getProperty("user.dir");
			// FileReader fr = new FileReader(projectPath +
			// "src\\main\\resources\\configFiles\\config.properties");

			FileReader fr = new FileReader(
					"C:\\Users\\savita.dighade\\Downloads\\PractiseFramework 11\\Automation_Practise\\src\\"
							+ "main\\resources\\configFiles\\config.properties");

			  String propFilePath = WORKING_DIR + System.getProperty("file.separator") + "/conf.properties";
		        prop.load(new FileReader(propFilePath));
			//prop.load(fr);

		}

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			chromeoptions = new ChromeOptions();

			chromeoptions.addArguments("--remote-allow-origins=*");

			// options.addArguments("--headless");

			driver = new ChromeDriver(chromeoptions);

			// options.setHeadless(true);

			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));

			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

			WebElement element = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M16 132h41')]"));

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView();", element);
			element.click();

			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		} else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();

			edgeoptions = new EdgeOptions();
			edgeoptions.addArguments("--remote-allow-origins=*");

			driver = new EdgeDriver(edgeoptions);
			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));

			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

			WebElement element1 = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M16 132h41')]"));

			JavascriptExecutor js1 = ((JavascriptExecutor) driver);
			js1.executeScript("arguments[0].scrollIntoView();", element1);
			element1.click();

			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		}

		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--remote-allow-origins=*");

			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));

			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

			WebElement element1 = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M16 132h41')]"));

			JavascriptExecutor js1 = ((JavascriptExecutor) driver);
			js1.executeScript("arguments[0].scrollIntoView();", element1);
			element1.click();

			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
			
		} else {
			System.out.println("Browser not found");
		}
	}

	@BeforeMethod(alwaysRun = true)
	public void createObject() {
		tp = new testCheckBoxPage(driver);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		System.out.println("Teardown Successfully");
	}

}
