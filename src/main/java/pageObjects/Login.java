package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Login {
    public WebDriver driver;
    public  Login (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@type='email']")
    WebElement logininput;
    @FindBy(xpath = "//input[@id='continue']")
    WebElement continuebtn;
    @FindBy(xpath = "//input[@id='ap_password']")
    WebElement passwrd;
    @FindBy(xpath = "//input[@id='signInSubmit']")
    WebElement loginbtn;
    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    WebElement createaccnt;
    @FindAll(@FindBy(xpath = "//*[text()='There was a problem']"))
    List<WebElement> error_message;

    public WebElement getLogininput()
    {
        return logininput;
    }
    public WebElement getContinuebtn()
    {
        return continuebtn;
    }
    public  WebElement getPasswrd()
    {
        return passwrd;
    }
    public WebElement getLoginbtn()
    {
        return loginbtn;
    }
    public WebElement getCreateaccnt()
    {
        return createaccnt;
    }
    public List<WebElement> getError_message() {
        return error_message;
    }
}
