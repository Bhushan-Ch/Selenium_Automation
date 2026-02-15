package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
	
	private WebDriver driver;
	
	 private By menuButton = By.id("react-burger-menu-btn");
	    private By logoutLink = By.id("logout_sidebar_link");

	    public LogoutPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void logout() {
	        driver.findElement(menuButton).click();
	        driver.findElement(logoutLink).click();
	    }
	}

