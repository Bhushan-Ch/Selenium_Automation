package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataProviderUtil;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUtil.class)
    public void verifyLogin(String username, String password, String scenario) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        if (scenario.equalsIgnoreCase("valid")) {
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login failed for valid user");
        } else {
            Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"), "Error message not displayed");
        }
    }
}
