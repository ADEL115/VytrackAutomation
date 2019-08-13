package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    Pages pages = new Pages();

    @Given("I am on a login page")
    public void i_am_on_a_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("I enter {string} and {string}")
    public void i_enter_and(String user, String userPassword) {
        String password = "";
        String userName = "";

        if (userPassword.equalsIgnoreCase("password"))
            password = ConfigurationReader.get("password");

        if (user.equalsIgnoreCase("driver")) {
            userName = ConfigurationReader.get("truck_driver");
        } else if (user.equalsIgnoreCase("sales manager")) {
            userName = ConfigurationReader.get("sales_manager");
        } else if (user.equalsIgnoreCase("store manager")) {
            userName = ConfigurationReader.get("store_manager");
        }

        pages.loginPage().username.sendKeys(userName);
        pages.loginPage().password.sendKeys(password);
        pages.loginPage().submit.click();
        BrowserUtils.waitForUIOverlay();
    }

    @Then("I should be able to see the dashboard page")
    public void i_should_be_able_to_see_the_dashboard_page() {

        Assert.assertTrue(Driver.get().getTitle().contains("Dashboard"));
    }

    @Given("I login as a {string}")
    public void i_login_as_a(String user) {
        String password = ConfigurationReader.get("password");
        String userName = "";
        if (user.equalsIgnoreCase("driver")) {
            userName = ConfigurationReader.get("truck_driver");
        } else if (user.equalsIgnoreCase("sales manager")) {
            userName = ConfigurationReader.get("sales_manager");
        } else if (user.equalsIgnoreCase("store manager")) {
            userName = ConfigurationReader.get("store_manager");
        } else {
            throw new RuntimeException("<<< Invalid user! >>>");
        }

        pages.loginPage().login(userName, password);
    }

    @Then("I shouldn't be able to see the dashboard page")
    public void iShouldnTBeAbleToSeeTheDashboardPage() {

        Assert.assertEquals(Driver.get().getCurrentUrl(), ConfigurationReader.get("url"));

    }
}
