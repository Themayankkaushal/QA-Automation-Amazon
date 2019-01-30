package Begin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class driverintialization {
    public static WebDriver driver;
    public  static Properties prop;
    public WebDriver initilaizeDriver() throws IOException {
         prop=new Properties();
        FileInputStream fis=new FileInputStream("C:\\Users\\kaush\\IdeaProjects\\amazonframework\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);
        String browserName=prop.getProperty("browser");
     if (driver==null) {

         if (browserName.equalsIgnoreCase("chrome")) {
             //System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
             WebDriverManager.chromedriver().setup();
             ChromeOptions options = new ChromeOptions();
             options.addArguments("--incognito");
             DesiredCapabilities capabilities = DesiredCapabilities.chrome();
             capabilities.setCapability(ChromeOptions.CAPABILITY, options);
             driver = new ChromeDriver(capabilities);


         } else {
             // System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver.exe");
             WebDriverManager.firefoxdriver().setup();
             driver = new FirefoxDriver();
         }
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         return driver;

     }
     else
         return driver;
    }
    public void getScreenshot(String result) throws IOException {
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C://Users//kaush//OneDrive//Desktop//Screenshots//"+result+"Screenshot.PNG"));

    }
}
