package com.vytrack.tests.smoke_tests;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehiclesPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;

public class MenuOptionsTest extends TestBase {

    @Test (description = "Menu options, driver", invocationCount = 1)
    public void test1() {

        String userName = ConfigurationReader.get("truck_driver");
        String password = ConfigurationReader.get("password");

        new LoginPage().login(userName, password);
        VehiclesPage vehiclesPage = new VehiclesPage();

        vehiclesPage.selectMenuOption("Fleet", "Vehicles");

        String expectedTitle = "Car - Entities - System - Car - Entities - System";
        String expectedPage = "Cars";

        Assert.assertEquals(expectedTitle, driver.getTitle());
        Assert.assertEquals(expectedPage, vehiclesPage.pageName.getText());

        vehiclesPage.selectMenuOption("Customers", "Accounts");

        expectedTitle = "Accounts - Customers";
        expectedPage = "Accounts";

        Assert.assertEquals(expectedTitle, driver.getTitle());
        Assert.assertEquals(expectedPage, vehiclesPage.pageName.getText());

        driver.navigate().refresh();
        vehiclesPage.selectMenuOption("Customers", "Contacts");

        expectedTitle = "Contacts - Customers";
        expectedPage = "Contacts";

        Assert.assertEquals(expectedTitle, driver.getTitle());
        Assert.assertEquals(expectedPage, vehiclesPage.pageName.getText());

        vehiclesPage.selectMenuOption("Activities", "Calendar Events");

        expectedTitle = "Calendar Events - Activities";
        expectedPage = "Calendar Events";

        Assert.assertEquals(expectedTitle, driver.getTitle());
        Assert.assertEquals(expectedPage, vehiclesPage.pageName.getText());
    }

    @Test (description = "Menu options, store manager", invocationCount = 1)
    public void test2() {

        String userName = ConfigurationReader.get("store_manager");
        String password = ConfigurationReader.get("password");

        new LoginPage().login(userName, password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.selectMenuOption("Dashboards", "Dashboard");

        String expectedTitle = "Dashboard - Dashboards";
        String expectedPage = "Dashboard";

        BrowserUtils.waitFor(1);
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertEquals(dashboardPage.pageName.getText(), expectedPage);

        dashboardPage.selectMenuOption("Fleet", "Vehicles");

        expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        expectedPage = "All Cars";

        BrowserUtils.waitFor(1);
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertEquals(dashboardPage.pageName.getText(), expectedPage);

        dashboardPage.selectMenuOption("Customers", "Accounts");

        expectedTitle = "All - Accounts - Customers";
        expectedPage = "All Accounts";

        BrowserUtils.waitFor(1);
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertEquals(dashboardPage.pageName.getText(), expectedPage);

        driver.navigate().refresh();
        dashboardPage.selectMenuOption("Customers", "Contacts");

        expectedTitle = "All - Contacts - Customers";
        expectedPage = "All Contacts";

        BrowserUtils.waitFor(1);
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertEquals(dashboardPage.pageName.getText(), expectedPage);

        dashboardPage.selectMenuOption("Sales", "Opportunities");

        expectedTitle = "Open Opportunities - Opportunities - Sales";
        expectedPage = "Open Opportunities";

        BrowserUtils.waitFor(1);
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertEquals(dashboardPage.pageName.getText(), expectedPage);

        dashboardPage.selectMenuOption("Activities", "Calls");

        expectedTitle = "All - Calls - Activities";
        expectedPage = "All Calls";

        BrowserUtils.waitFor(1);
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertEquals(dashboardPage.pageName.getText(), expectedPage);

        driver.navigate().refresh();
        dashboardPage.selectMenuOption("Activities", "Calendar Events");

        expectedTitle = "All - Calendar Events - Activities";
        expectedPage = "All Calendar Events";

        BrowserUtils.waitFor(1);
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertEquals(dashboardPage.pageName.getText(), expectedPage);

    }
}
