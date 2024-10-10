package stepDefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.font.NumericShaper;

import static org.junit.Assert.assertEquals;

public class LoginSteps {
    static final String Nume="GGggHHg";

    WebDriver driver=null;
    @Given("User navigate to the website homepage")
    public void user_navigate_to_the_website_homepage(){
       System.out.println("User Navigates to ui");
       System.setProperty("webdriver.chrome.driver","C:\\Users\\step.DESKTOP-1MAJMCM\\IdeaProjects\\Corina1\\src\\webdriver\\chromedriver.exe");
       driver=new ChromeDriver();
       driver.navigate().to("https://parabank.parasoft.com/");
       driver.manage().window().maximize();

    }

    @And("User navigates to Register Page")
    public void user_navigates_to_Register_Page(){
        String RegisterText = driver.findElement(By.partialLinkText("Regis")).getText();
        assertEquals(RegisterText,driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")).getText());
        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")).click();
        String signingUpIsEasy=driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/h1")).getText();
        assertEquals(signingUpIsEasy,driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/h1")).getText());
    }

    @When("User give userName")
    public void user_give_userName(){
        driver.findElement(By.id("customer.firstName")).sendKeys("Corina");

    }

    @When("User give lastName")
    public void user_give_lastName() {
        driver.findElement(By.id("customer.lastName")).sendKeys("Simon");
    }
    @When("User give addressCity")
    public void user_give_addressCity(){
        driver.findElement(By.id("customer.address.city")).sendKeys(" Criuleni");

    }

    @When("User click on [Register] button")
    public void user_click_on_Register_button(){
        driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")).click();
    }


    @When("User has error message")
    public void user_has_error_message(){
        String addressIsRequired= driver.findElement (By.id ("customer.address.street.errors")).getText();
        String customerAddressStateErrors= driver.findElement (By.id("customer.address.state.errors")).getText();
        String customerAddressZipCodeErrors= driver.findElement (By.id("customer.address.zipCode.errors")).getText();
        String customerSNNErrors=driver.findElement(By.id("customer.ssn")).getText();
        String customerUsernameErrors= driver.findElement(By.id("customer.username.errors")).getText();
        String customerPasswordErrors= driver.findElement (By.id("customer.password.errors")).getText();
        String repeatedPasswordErrors= driver.findElement (By.id("repeatedPassword.errors")).getText ();
        assertEquals(addressIsRequired, driver.findElement(By.id ("customer.address.street.errors")) .getText ());
        assertEquals(customerAddressStateErrors, driver. findElement (By. id ("customer.address.state.errors")).getText());
        assertEquals(customerAddressZipCodeErrors, driver.findElement (By.id("customer.address.zipCode.errors")).getText());
        assertEquals(customerSNNErrors,driver.findElement(By.id("customer.ssn")).getText());
        assertEquals(customerUsernameErrors, driver.findElement (By. id ("customer.username.errors")).getText ());
        assertEquals(customerPasswordErrors, driver.findElement (By.id ("customer.password.errors")).getText());
        assertEquals(repeatedPasswordErrors, driver.findElement (By. id ("repeatedPassword.errors")).getText());

    }

    @When("User insert empty fields with valid data")
    public void user_insert_empty_fields_with_valid_data(){
        driver. findElement (By.id ("customer.address.street")).sendKeys( "Biruinta 30");
        driver. findElement (By.id ("customer.address.state")) .sendKeys( "Moldova");
        driver. findElement (By.id ("customer.address.state")) .sendKeys( "Moldova");
        driver. findElement(By.id ("customer.address.zipCode")).sendKeys( "b300");
        driver.findElement(By.id("customer.ssn")).sendKeys("87986");
        driver. findElement (By.id ("customer.username")) .sendKeys (Nume);
        driver. findElement(By.id ("customer.password")) .sendKeys ( "12345");
        driver.findElement (By.id ("repeatedPassword")) .sendKeys ( "12345");


    }

    @And("User click on Register")
    public void user_click_on_Register() {
        driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")).click();
    }
    @And("User has account confirmation")
    public void user_has_account_confirmation(){
        assertEquals("Welcome " +Nume,driver.findElement(By.className("title")).getText());
    }


    @And("User click on Open New Account")
    public void user_click_on_Open_New_Account(){
        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a")).click();

    }
    @And("User chose Savings")
    public void user_chose_Savings(){
        driver.findElement(By.xpath("//*[@id=\"type\"]/option[2]")).click();
    }
    @And("User click on [Open new account] button")
    public void user_click_on_Open_new_account_button(){
        driver.findElement(By.xpath("//*[@id=\"openAccountForm\"]/form/div/input")).click();
    }
    @And("User Click on account number")
    public void user_Click_on_account_number(){
       driver.findElement(By.xpath("//*[@id=\"newAccountId\"]")).click();
    }
    @And("User Click the button GO")
    public void user_Click_the_button_GO(){

    }


    @Then("User insert pass")
    public void user_insert_pass() throws InterruptedException{
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
}
