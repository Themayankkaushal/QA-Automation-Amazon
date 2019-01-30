package Begin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Homepage;

import java.io.IOException;
/*import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;*/
import java.util.List;

public class brokenlinkTest extends driverintialization {
    public static Logger log = LogManager.getLogger(driverintialization.class.getName());

    @BeforeTest()
    public void openBrowser() throws IOException {
        driver=initilaizeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();

    }
    @Test
    public void brokenlinkfooter(){
        driver.manage().window().maximize();
        Homepage homepage = new Homepage(driver);
        List<WebElement> links = homepage.getBrkncheck();
        log.info("Number of links count is "+homepage.getBrkncheck().size());
        for (int i=0;i<homepage.getBrkncheck().size();i++) {

            WebElement elementlink= links.get(i);
            String url=elementlink.getAttribute("href");
            if (url!=null) {
              //  System.out.println("Counter is " +url);
                log.info(url);
            }
            else {
                //System.out.println("Counter------------ " +url);
                log.error("Invalid URL spotted");
            }
            }
    }
    /*public static void verifyLinkActive(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);

            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();

            httpURLConnect.setConnectTimeout(3000);

            httpURLConnect.connect();

            if(httpURLConnect.getResponseCode()==200)
            {
                log.info(linkUrl+httpURLConnect.getResponseMessage());
            }
            if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
            {
                log.error(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {

        }
    }*/

    @AfterTest
    public void teardown()
    {
        driver.close();
        driver=null;
    }
}





