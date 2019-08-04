package com.vytrack.tests.components.login_navigation;

import com.github.javafaker.Faker;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import static org.testng.Assert.*;
import org.testng.annotations.*;

import java.util.Random;

public class LoginTest extends TestBase {

    @Test (description = "Login test (positive)", invocationCount = 5)
    public void test1() {
        // store manager
        String userName = ConfigurationReader.get("store_manager");
        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);
        DashboardPage dashboardPage = new DashboardPage();

        String nameOfUser = dashboardPage.userDropdown.getText();
        assertTrue(nameOfUser.length()!=0, "Name is empty");

        String expectedPage = "Dashboard";
        assertEquals(dashboardPage.pageName.getText(), expectedPage, "Page name is not 'Dashboard'");

        BrowserUtils.waitForUIOverlay();
        dashboardPage.userDropdown.click();
        dashboardPage.logout.click();


        // sales manager
        userName = ConfigurationReader.get("sales_manager");
        password = ConfigurationReader.get("password");
        loginPage.login(userName, password);

        assertEquals(dashboardPage.pageName.getText(), expectedPage, "Page name is not 'Dashboard'");
        assertNotEquals(dashboardPage.userDropdown.getText(), nameOfUser, "Name of the user is same");
        nameOfUser = dashboardPage.userDropdown.getText();

        BrowserUtils.waitForUIOverlay();
        dashboardPage.userDropdown.click();
        dashboardPage.logout.click();

        // truck driver
        userName = ConfigurationReader.get("truck_driver");
        password = ConfigurationReader.get("password");
        loginPage.login(userName, password);

        expectedPage = "Quick Launchpad";

        assertEquals(dashboardPage.pageName.getText(), expectedPage, "Page name is not 'Quick Launchpad'");
        assertNotEquals(dashboardPage.userDropdown.getText(), nameOfUser, "Name of the user is same");

        BrowserUtils.waitForUIOverlay();
        dashboardPage.userDropdown.click();
        dashboardPage.logout.click();
    }

    @Test (description = "Login test (negative)", invocationCount = 1)
    public void test2() {

        Faker faker = new Faker();
        String wrongPassword = faker.book().title();
        String userName = ConfigurationReader.get("store_manager");

        String title = driver.getTitle();
        String url = driver.getCurrentUrl();

        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys(userName);
        loginPage.password.sendKeys(wrongPassword);
        loginPage.submit.click();

        String expected = "Invalid user name or password.";
        String actual = loginPage.errorMessage.getText();

        assertEquals(actual, expected);
        assertEquals(driver.getTitle(), title);
        assertEquals(driver.getCurrentUrl(), url);
    }
}
