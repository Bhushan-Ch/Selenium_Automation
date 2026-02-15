package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;

public class CheckoutTest {
	private WebDriver driver;

	
	@Test
	    public void verifyCheckoutProcess() {
	        
			LoginPage loginPage = new LoginPage(driver);
	        HomePage homePage = new HomePage(driver);
	        CartPage cartPage = new CartPage(driver);
	        CheckoutPage checkoutPage = new CheckoutPage(driver);
	 
	 // Login
     loginPage.login("standard_user", "secret_sauce");

     // Add item
     homePage.addFirstItemToCart();
     homePage.clickCartIcon();

     // Checkout
     cartPage.clickCheckout();
     checkoutPage.fillCheckoutDetails("Bhushan", "Chougule", "411057");
     checkoutPage.clickContinue();
     checkoutPage.clickOnFinish();

     Assert.assertTrue(checkoutPage.isOrderSuccessMessageDisplayed(), "Order success message not displayed!");
 }


}