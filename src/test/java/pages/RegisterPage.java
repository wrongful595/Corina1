package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

@Getter
public class RegisterPage extends PageObjects{

    @FindBy(xpath = "//h1[contains(text(), 'Signing up is easy!']")
    WebElement signUpIsEasyPhraseOnRegisterPage;

    @FindBy(xpath = "//input[@id='customer.firstName']")
    WebElement firstName;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }
}
