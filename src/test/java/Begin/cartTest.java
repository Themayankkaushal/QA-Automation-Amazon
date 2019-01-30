package Begin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.Login;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class cartTest extends driverintialization {
    public static Logger log = LogManager.getLogger(driverintialization.class.getName());

    @BeforeTest
    public void openBrowser() throws IOException {
        driver = initilaizeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 30);

    }

    @Test()
    public void addtoCartTest() {
        Homepage homepage = new Homepage(driver);
        Login login = new Login(driver);
        homepage.getSigninbutton().click();
        login.getLogininput().sendKeys(prop.getProperty("username1"));
        login.getContinuebtn().click();
        login.getPasswrd().sendKeys(prop.getProperty("password1"));
        login.getLoginbtn().click();
        Actions actions = new Actions(driver);
        actions.moveToElement(homepage.getSearchbar());
        actions.click();
        actions.sendKeys("Firestick");
        actions.build().perform();
        homepage.getSearchbtn().click();
        homepage.getFirstchoice().click();
        Set<String> ids =driver.getWindowHandles();
        Iterator<String> id= ids.iterator();
        String parent_id=id.next();
        String child_id=id.next();
        driver.switchTo().window(child_id);
        homepage.getCartButton().click();
        Assert.assertTrue(homepage.getConfirmationtext().isDisplayed());
        log.info("Product Successfully Added");




    }
    @AfterTest
    public void teardown()
    {
        driver.close();
        driver = null;
    }
}


