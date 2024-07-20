package testClasses;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageClasses.ButtonsPage;
import pageClasses.CheckBoxPage;
import pageClasses.CheckoutPage;
import pageClasses.RadioButtonPage;
import pageClasses.TextBoxPage;
import pageClasses.WebTablePage;
import pageClasses.testCheckBoxPage;

public class BaseClass {

	public WebDriver driver;
	public CheckoutPage cop;
	public JavascriptExecutor js;
	public CheckBoxPage cob;
	public RadioButtonPage rob;
	public TextBoxPage tbp;
	public ButtonsPage bp;
	public WebTablePage wtb;
	public static Properties prop = new Properties();
	public static String WORKING_DIR = System.getProperty("user.dir");
	public static FileReader fr;
	public ChromeOptions chromeoptions;
	public EdgeOptions edgeoptions;

	@BeforeClass(alwaysRun = true)

	public void setup() throws IOException, InterruptedException {

		if (driver == null) {

			String relativePath = "src\\main\\resources\\configFiles\\config.properties";
			String propFilePath = WORKING_DIR + System.getProperty("file.separator") + relativePath;
			prop.load(new FileReader(propFilePath));
		}

		// Chrome browser
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			chromeoptions = new ChromeOptions();

			chromeoptions.addArguments("--remote-allow-origins=*");

			// options.addArguments("--headless");

			driver = new ChromeDriver(chromeoptions);

			// options.setHeadless(true);

			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));

			WebElement element = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M16 132h41')]"));

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView();", element);
			element.click();

		}

		// Edge Browser
		else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();

			edgeoptions = new EdgeOptions();
			edgeoptions.addArguments("--remote-allow-origins=*");

			driver = new EdgeDriver(edgeoptions);
			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));

			WebElement element = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M16 132h41')]"));

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView();", element);
			element.click();

		}

		// Firefox Browser
		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--remote-allow-origins=*");

			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));

			WebElement element = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M16 132h41')]"));

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView();", element);
			element.click();

		} else {
			System.out.println("Browser not found");
		}
	}

	@BeforeMethod(alwaysRun = true)

	public void createObject() {
		// cop = new CheckTextoutPage(driver);

		cob = new CheckBoxPage(driver);

		rob = new RadioButtonPage(driver);

		tbp = new TextBoxPage(driver);

		bp = new ButtonsPage(driver);

		wtb = new WebTablePage(driver);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
		System.out.println("Teardown Successfully");
	}

}
