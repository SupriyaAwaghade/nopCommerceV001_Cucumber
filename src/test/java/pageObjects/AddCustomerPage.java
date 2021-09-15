package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage
{

    public WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver)
    {
        ldriver =rdriver;
        PageFactory.initElements(rdriver,this);

    }
    By lnkCustomers_menu=By.xpath("//i[@class='nav-icon far fa-user']");

    By lnkCustomers_menuitem=By.xpath("//a[@href='/Admin/Customer/List' ]");
    By btnAddnew = By.xpath("//a[@class='btn btn-primary']");
    By txtEmail = By.id("Email");
    By txtPassword = By.id("Password");

    By txtFirstName=By.xpath("//input[@id='FirstName']");
    By txtLastName=By.id("LastName");
    By txtDob=By.id("DateOfBirth");
    By txtCompanyName=By.id("Company");
    By txtAdminContent=By.id("AdminComment");
    By btnSave=By.xpath("//button[@type='submit' and @name='save' ]");
    By drpmgrOfVendor=By.id("VendorId");
    By rdMaleGender=By.id("Gender_Male");
    By rdFemaleGender=By.id("Gender_Female");



    //Action Method//

    public String getPageTitle()
    {
        return ldriver.getTitle();
    }

    public void clickOnCustomerMenu()
    {
        ldriver.findElement(lnkCustomers_menu).click();
    }
    public void clickOnCustomerMenuItem()
    {
        ldriver.findElement(lnkCustomers_menuitem).click();
    }
    public void clickOnAddnew()
    {
        ldriver.findElement(btnAddnew).click();
    }
    public void setEmail(String email)
    {
        ldriver.findElement(txtEmail).sendKeys(email);
    }
    public void setPassword(String password)
    {
        ldriver.findElement(txtPassword).sendKeys(password);
    }


     public void setFirstName(String fname)
     {
         ldriver.findElement(txtFirstName).sendKeys(fname);
     }
    public void setLastName(String lname)
    {
        ldriver.findElement(txtLastName).sendKeys(lname);
    }
    public void setGender(String gender)
    {
        if (gender.equals("Male"))
        {
            ldriver.findElement(rdMaleGender).click();
        }
        else if (gender.equals("Female"))
        {
            ldriver.findElement(rdFemaleGender).click();
        }
        else {
            ldriver.findElement(rdMaleGender).click();
        }
    }

    public void setDob(String dob)
    {
        ldriver.findElement(txtDob).sendKeys(dob);
    }
    public void setCompanyName(String comname)
    {
        ldriver.findElement(txtCompanyName).sendKeys(comname);
    }

    public void setManagerOfVendor(String value)
    {
        Select drp = new Select(ldriver.findElement(drpmgrOfVendor));
        drp.selectByVisibleText(value);
    }
    public void setAdminContent(String content)
    {
        ldriver.findElement(txtAdminContent).sendKeys(content);
    }
    public void clickOnSave()
    {
        ldriver.findElement(btnSave).click();
    }










}
