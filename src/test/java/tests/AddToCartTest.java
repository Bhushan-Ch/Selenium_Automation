package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

public class AddToCartTest extends BaseTest{
	
	@Test
	public void verifyAddToCart()
	{
		LoginPage loginPage= new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		
		
		//Login first
		loginPage.login("standard_user", "secret_sauce");
		Assert.assertTrue(homePage.isProductsPageDisplayed(),"Login faileed");
		
		//Add to cart
		homePage.addFirstItemToCart();
		homePage.clickCartIcon();
		
		CartPage cartPage=new CartPage(driver);
		Assert.assertTrue(cartPage.isCartItemDisplayed(),"Item not added to the cart");
		
		
		
		
	}
	
	

}
