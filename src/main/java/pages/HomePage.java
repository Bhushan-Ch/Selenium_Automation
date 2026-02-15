package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	 private WebDriver driver;

	    private By productsTitle = By.cssSelector("span.title");
	    private By firstItemAddToCart = By.id("add-to-cart-sauce-labs-backpack");
	    private By cartIcon = By.className("shopping_cart_link");
	 

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public boolean isProductsPageDisplayed() {
	        return driver.findElement(productsTitle).isDisplayed();
	    }
	    public void addFirstItemToCart() {
	        driver.findElement(firstItemAddToCart).click();
	    }

	    public void clickCartIcon() {
	        driver.findElement(cartIcon).click();
	    }
	}
	


