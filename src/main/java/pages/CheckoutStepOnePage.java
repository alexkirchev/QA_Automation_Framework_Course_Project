package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutStepOnePage {
    protected WebDriver driver;

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueSubmit;

    public CheckoutStepOnePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CheckoutStepTwoPage nameAndPostalCodeInput(){
        firstNameInput.clear();
        firstNameInput.sendKeys("Alex");

        lastNameInput.clear();
        lastNameInput.sendKeys("Kirchev");

        postalCodeInput.clear();
        postalCodeInput.sendKeys("1172");

        continueSubmit.click();

        return new CheckoutStepTwoPage(driver);
    }
}
