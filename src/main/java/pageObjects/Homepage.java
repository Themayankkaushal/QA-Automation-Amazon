package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.util.ArrayList;
import java.util.List;

public class Homepage {
    public WebDriver driver;
    public Homepage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath ="//a[@id='nav-link-yourAccount']")
            WebElement signinbutton;
    //By signinbutton=By.xpath("//a[@id='nav-link-yourAccount']");
    @FindBy(xpath = "//div[@class='nav-search-field ']")
    WebElement searchbar;
    @FindBy(xpath = "//input[@value='Go']")
    WebElement searchbtn;
    /*@FindBy(xpath = "//div[@class='a-cardui-body']")
    List<WebElement> banner;*/
    @FindBy(xpath = "//img[@alt='profile image']")
    WebElement profileimg;
    @FindAll(@FindBy(xpath = "//*[text()='Hello, Aishwarya']"))
    List<WebElement> displayuser;
    @FindBy(tagName = "a")
    List<WebElement> brkncheck;
    @FindBy(xpath ="//a[@title='Amazon Fire TV Stick with 1st Gen Alexa Voice Remote | Streaming Media Player']")
    WebElement firstchoice;
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement cartButton;
    @FindBy(xpath = "//span[@id='confirm-text']")
    WebElement confirmationtext;
    @FindBy(xpath = "//span[@class='nav-sprite nav-logo-base']")
    WebElement logo;
    @FindBy(xpath = "//select[@aria-describedby='searchDropdownDescription']")
    WebElement dropdown;
    @FindBy(xpath = "//a[@class='nav-a nav-a-2 a-popover-trigger a-declarative']")
    WebElement addressbar;

    public WebElement getSigninbutton()
    {
        return signinbutton;
    }
    public WebElement getSearchbar()
    {
        return searchbar;
    }
    public WebElement getSearchbtn()
    {
        return searchbtn;
    }
    public WebElement getProfileimg() { return profileimg;}
    public List<WebElement> getBrkncheck() { return brkncheck;}
    public List<WebElement> getDisplayuser(){return displayuser;}
    public WebElement getFirstchoice(){ return  firstchoice;}
    public WebElement getCartButton(){return cartButton;}
    public WebElement getConfirmationtext(){return confirmationtext;}
    public  WebElement getLogo(){return  logo;}
    public  WebElement getDropdown(){return dropdown;}
    public WebElement getAddressbar(){return addressbar;}











}
