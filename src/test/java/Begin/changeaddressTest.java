package Begin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.Login;

import java.io.IOException;

public class changeaddressTest extends driverintialization {
    public static Logger log = LogManager.getLogger(driverintialization.class.getName());

    @BeforeTest()
    public void openBrowser() throws IOException {
        driver=initilaizeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }
    @Test
    public void addresschange()
    {
        Homepage homepage=new Homepage(driver);
        LoginTest loginTest=new LoginTest();
        loginTest.signin();
        homepage.getAddressbar().click();
    }

    @AfterTest
    public void teardown()
    {
        driver.close();
        driver=null;
    }
}
