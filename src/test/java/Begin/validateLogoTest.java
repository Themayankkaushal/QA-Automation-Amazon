package Begin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Homepage;

import java.io.IOException;

public class validateLogoTest extends driverintialization {
    public static Logger log = LogManager.getLogger(driverintialization.class.getName());

    @BeforeTest()
    public void openBrowser() throws IOException {
        driver=initilaizeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void checklogo()
    {
        Homepage homepage=new Homepage(driver);
Assert.assertTrue(homepage.getLogo().isDisplayed());
log.info("Test Cases Passed");
    }

    @AfterTest
    public void teardown()
    {
        driver.close();
        driver=null;
    }
}
