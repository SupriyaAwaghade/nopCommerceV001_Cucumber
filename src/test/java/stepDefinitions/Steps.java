package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class Steps extends BaseClass
{


    @Given("User launch chrome browser")
    public void user_launch_chrome_browser()
    {
     System.setProperty("webDriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
     driver = new ChromeDriver();
        lp = new LoginPage(driver);
        driver.manage().window().maximize();
    }
    @When("User opens URL{string}")
    public void user_opens_url(String url)
    {
     driver.get(url);
    }
    @When("User enters Email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password)
    {
     lp.setUserName(email);
     lp.setPassword(password);
    }
    @When("Click on Login")
    public void click_on_login() throws InterruptedException {
     lp.clickLogin();
       driver.manage().wait(1000);

    }
    @Then("page Title should be {string}")
    public void page_title_should_be(String title)throws InterruptedException
    {
     if(driver.getPageSource().contains("Login was unsuccessful."))
     {
         driver.close();
         Assert.assertTrue(false);
     }
     else {
         Assert.assertEquals(title, driver.getTitle());
     } Thread.sleep(3000);

    }
    @When("User click on Log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        lp.clickLogout();
        Thread.sleep(3000);
    }

    @Then("close browser")
    public void close_browser()
    {
     driver.quit();
    }


//Customers.feature//

    @Then("User can view Dashboard")
    public void user_can_view_Dashboard()
    {
     addcust = new AddCustomerPage(driver);
     Assert.assertEquals("Dashboard / nopCommerce administration",addcust.getPageTitle());
    }

    @When("User click on customers Menu")
    public void user_click_on_customer_Menu() throws InterruptedException {
        Thread.sleep(5000);
        addcust.clickOnCustomerMenu();
    }

    @When("click on customers Menu Item")
    public void user_click_on_customer_Menu_Item() throws InterruptedException {
        Thread.sleep(2000);
     addcust.clickOnCustomerMenuItem();
    }
    @When("click on Add new button")
    public void click_on_Add_new_button() throws InterruptedException {
     addcust.clickOnAddnew();
     Thread.sleep(2000);
    }
    @Then("User can view Add new customers page")
    public void user_can_view_Add_new_customers_page()
    {
     Assert.assertEquals("Add a new customer / nopCommerce administration",addcust.getPageTitle());
    }
    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
     String email = randomestring()+"@gmail.com";
    addcust.setEmail(email);
    addcust.setPassword("test123");
    addcust.setGender("Male");
    addcust.setFirstName("Pavan");
    addcust.setLastName("Kumar");
    addcust.setDob("7/05/1985");
    addcust.setCompanyName("busyQA");
    addcust.setManagerOfVendor("Vendor 2");
    Thread.sleep(3000);
    addcust.setAdminContent("This is for testing____");


    }
    @When("click on Save button")
    public void click_on_save_button() throws InterruptedException {
     addcust.clickOnSave();
     Thread.sleep(2000);
    }

    @Then("User can view confirmation message")
    public void user_can_view_confirmation_message() throws InterruptedException {
        Thread.sleep(2000);
        String msg = "The new customer has been added successfully.";
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
                .contains(msg));
    }

}




