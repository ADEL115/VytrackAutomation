package com.vytrack.tests.components.login_navigation;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class PageAccessTest extends TestBase {

    @Test(description = "Vehicle contracts test store manager", invocationCount = 1)
    public void test1() {
        String userName = ConfigurationReader.get("store_manager");
        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.selectMenuOption("Fleet", "Vehicle Contracts");

        BrowserUtils.waitFor(1);
        String expectedPage = "All Vehicle Contract";
        assertEquals(dashboardPage.pageName.getText(), expectedPage);
    }

    @Test(description = "Vehicle contracts test sales manager", invocationCount = 1)
    public void test2() {
        String userName = ConfigurationReader.get("sales_manager");
        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.selectMenuOption("Fleet", "Vehicle Contracts");

        BrowserUtils.waitFor(1);
        String expectedPage = "All Vehicle Contract";
        assertEquals(dashboardPage.pageName.getText(), expectedPage);
    }

    @Test(description = "Vehicle contracts test truck driver", invocationCount = 1)
    public void test3() {
        String userName = ConfigurationReader.get("truck_driver");
        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);

        DashboardPage dashboardPage = new DashboardPage();
        driver.findElement(By.linkText("Fleet")).click();
        driver.findElement(By.linkText("Vehicle Contracts")).click();

        String expectedPage = "All Vehicle Contract";
        assertNotEquals(dashboardPage.pageName.getText(), expectedPage);

        String expectedMessage = "You do not have permission to perform this action.";
        String actualMessage = dashboardPage.errorMessage.getText();
        assertEquals(actualMessage, expectedMessage);
    }
}
