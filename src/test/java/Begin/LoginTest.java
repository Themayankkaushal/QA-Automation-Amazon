package Begin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Homepage;
import pageObjects.Login;

import java.io.IOException;

public class LoginTest extends driverintialization {
    public static Logger log = LogManager.getLogger(driverintialization.class.getName());
    @BeforeTest
    public void openBrowser() throws IOException {
    driver=initilaizeDriver();
    driver.get(prop.getProperty("url"));
}
    @Test()
    public void signin() {
        Homepage homepage = new Homepage(driver);
        Login login = new Login(driver);
        homepage.getSigninbutton().click();
        login.getLogininput().sendKeys(prop.getProperty("username1"));
        login.getContinuebtn().click();
        if (login.getError_message().size()!= 0) {
            System.out.println("Not in DB");
        } else {
            login.getPasswrd().sendKeys(prop.getProperty("password1"));
            login.getLoginbtn().click();
            Assert.assertTrue(homepage.getDisplayuser().size()!=0);
            log.info("Successfully logged in");
        }
    }
    /* @DataProvider
    public Object[][] getData() throws Exception {
        initilaizeDriver();
        Object[][] obj = new Object[1][2];
        //user with Valid password
        *//*obj[0][0] = "mmayankkaushal@gmail.com";
        obj[0][1] = "Mayank@270594";*//*
        obj[0][0]=prop.getProperty("username1");
        obj[0][1]=prop.getProperty("password1");
        //User with invalid password
        *//*obj[1][0] = "memayankkaushal@gmail.com";
        obj[1][1] = "Mayank@270194";*//*
        return obj;
    }*/

   @AfterTest
    public void teardown()
    {
        driver.close();
        driver=null;
    }
}
