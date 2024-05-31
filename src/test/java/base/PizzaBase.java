package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PizzaBase {

	public Properties prop;
	WebDriver driver;
	static int screenshotCounter = 1;

	public WebDriver initializeBrowser() throws IOException {

		prop = new Properties();

		File file = new File("src\\main\\java\\resources\\data.properties");

		FileInputStream fis = new FileInputStream(file);

		prop.load(fis);

		String browser = prop.getProperty("browser");

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		long timeoutInSeconds = Duration.ofSeconds(10).toMillis();
		driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.MILLISECONDS);

		return driver;
	}

	public String generateNewEmailTimeStamp() {
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";
	}

	// public String takeScreenShot(String testname, WebDriver driver) throws
	// IOException {

	// File srcScreenShot = ((TakesScreenshot)
	// driver).getScreenshotAs(OutputType.FILE);
	// String screenshotFilePath = System.getProperty("user.dir") +
	// "\\Screenshots\\" + testname + ".png";
	// FileUtils.copyFile(srcScreenShot, new File(screenshotFilePath));

	// return screenshotFilePath;

	// }

	public String takeScreenShot(String testname, WebDriver driver) throws IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		testname = dateFormat.format(new Date()) + "_" + screenshotCounter + ".png";

		File srcScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotFilePath = System.getProperty("user.dir") + "\\Screenshots\\" + testname + ".png";
		FileUtils.copyFile(srcScreenShot, new File(screenshotFilePath));
		screenshotCounter++;

		return screenshotFilePath;
	}
}
