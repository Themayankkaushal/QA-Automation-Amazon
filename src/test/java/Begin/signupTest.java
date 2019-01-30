package Begin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.Login;
import pageObjects.Registration;

import java.io.IOException;

public class signupTest extends driverintialization {
    public static Logger log = LogManager.getLogger(driverintialization.class.getName());
@BeforeTest()
public void openBrowser() throws IOException {
    driver=initilaizeDriver();
    driver.get(prop.getProperty("url"));
}

    @Test
    public void signup() throws IOException {

        Homepage homepage=new Homepage(driver);
        homepage.getSigninbutton().click();
        Login login=new Login(driver);
        login.getCreateaccnt().click();
        Registration registration=new Registration(driver);
        registration.getUsrname().sendKeys(prop.getProperty("name"));
        registration.getNum().sendKeys(prop.getProperty("number"));
        registration.getPaswrd().sendKeys(prop.getProperty("password"));
        registration.getContinuebtn().click();
        Assert.assertTrue(registration.getUseralreadyexist().size()!=0);
        log.error("User already exist");

}
@AfterTest
    public void teardown()
{
    driver.close();
    driver=null;
}
}
