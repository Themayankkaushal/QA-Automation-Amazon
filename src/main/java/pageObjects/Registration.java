package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;

public class Registration {
    public WebDriver driver;

    public Registration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='customerName']")
    WebElement usrname;
    @FindBy(xpath = "//input[@type='tel']")
    WebElement num;
    @FindBy(xpath = "//input[@name='secondaryLoginClaim']")
    WebElement mailid;
    @FindBy(xpath = "//input[@type='password']")
    WebElement paswrd;
    @FindBy(xpath = "//input[@id='continue']")
    WebElement continuebtn;
    @FindBy(xpath = "//a[@class='a-link-emphasis']")
    WebElement alreadyuserbtn;
    @FindAll(@FindBy(xpath = "//div[@id='auth-warning-message-box']"))
    List<WebElement> useralreadyexist;


    public WebElement getUsrname() {
        return usrname;
    }

    public WebElement getNum() {
        return num;
    }

    public WebElement getMailid() {
        return mailid;
    }

    public WebElement getPaswrd() {
        return paswrd;
    }

    public WebElement getContinuebtn() {
        return continuebtn;
    }

    public List<WebElement> getUseralreadyexist() { return useralreadyexist; }


}


