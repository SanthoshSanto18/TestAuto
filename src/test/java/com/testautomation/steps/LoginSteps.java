package com.testautomation.steps;

import com.testautomation.pages.LoginPage;
import com.testautomation.utils.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps extends BaseClass {
    private LoginPage loginPage;

    @Given("the login page is opened")
    public void the_login_page_is_opened() {
        // Browser is started in Hooks before hook; driver is ready and navigated to base.url
        loginPage = new LoginPage(driver);
    }

    @When("the user attempts to login with username {string} and password {string}")
    public void the_user_attempts_to_login_with_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("the login should be {string}")
    public void the_login_should_be(String result) {
        String flash = loginPage.getFlashMessage();
        if (result.equalsIgnoreCase("success")) {
            Assert.assertTrue("Expected success message", flash.contains("You logged into a secure area!"));
        } else {
            Assert.assertTrue("Expected failure message", flash.toLowerCase().contains("your username is invalid") || flash.toLowerCase().contains("your password is invalid"));
        }
        // Browser is closed in Hooks after hook
    }
}
