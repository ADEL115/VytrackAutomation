package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.VehiclesPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.Pages;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Navigation {

    @When("I go to {string} {string}")
    public void i_go_to(String tab, String module) {
        new Pages().dashboardPage().selectMenuOption(tab, module);
        BrowserUtils.waitForUIOverlay();
    }

    @Then("The page title should contain {string}")
    public void thePageTitleShouldBe(String expectedTitle) {
        BrowserUtils.waitFor(1);
        String actualTitle = Driver.get().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

}
