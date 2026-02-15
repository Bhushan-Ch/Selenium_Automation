package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	private WebDriver driver;
	
	private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By successMsg = By.cssSelector(".complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void fillCheckoutDetails(String fname, String lname, String zip) {
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(postalCode).sendKeys(zip);
    }
    public void clickContinue()
    {
    	driver.findElement(continueButton).click();
    }
    public void clickOnFinish()
    {
    	driver.findElement(finishButton).click();
    }
    
    public boolean isOrderSuccessMessageDisplayed()
    {
    	return driver.findElement(successMsg).isDisplayed();
    }
    

}
