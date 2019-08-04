package com.vytrack.tests.components.fleet;

import com.vytrack.pages.*;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

public class Vehicles extends TestBase {

    @BeforeMethod
    public void setUpMethod2() {

        String userName = ConfigurationReader.get("store_manager");
        String password = ConfigurationReader.get("password");

        new LoginPage().login(userName, password);
        new DashboardPage().selectMenuOption("Fleet", "Vehicles");
        BrowserUtils.waitForUIOverlay();

    }

    @Test(description = "Verify default order", invocationCount = 1, enabled = true)
    public void test1() {

        VehiclesPage vehiclesPage = new VehiclesPage();
        vehiclesPage.header("LICENSE PLATE").click();

        BrowserUtils.waitFor(1);
        List<WebElement> licensePlates = vehiclesPage.getCellsInColumn("LICENSE PLATE");

        for (int i = 0; i < licensePlates.size()-1; i++) {
            String plate1 = licensePlates.get(i).getText();
            String plate2 = licensePlates.get(i+1).getText();
            assertTrue(plate1.compareTo(plate2)<=0, "Elements are not sorted in ascending order");
        }

        vehiclesPage.header("LICENSE PLATE").click();
        BrowserUtils.waitFor(1);
        licensePlates = vehiclesPage.getCellsInColumn("LICENSE PLATE");

        for (int i = 0; i < licensePlates.size()-1; i++) {
            String plate1 = licensePlates.get(i).getText();
            String plate2 = licensePlates.get(i+1).getText();
            assertTrue(plate1.compareTo(plate2)>=0, "Elements are not sorted in descending order");
        }
    }

    @Test(description = "Verify that all records that are displayed can be sorted by DRIVER column", invocationCount = 1, enabled = true)
    public void test2() {

        VehiclesPage vehiclesPage = new VehiclesPage();
        vehiclesPage.header("DRIVER").click();

        BrowserUtils.waitFor(1);
        List<WebElement> drivers = vehiclesPage.getCellsInColumn("DRIVER");

        for (int i = 0; i < drivers.size()-1; i++) {
            String plate1 = drivers.get(i).getText();
            String plate2 = drivers.get(i+1).getText();
            assertTrue(plate1.compareTo(plate2)<=0, "Elements are not sorted in ascending order");
        }

        vehiclesPage.header("DRIVER").click();
        BrowserUtils.waitFor(1);
        drivers = vehiclesPage.getCellsInColumn("DRIVER");

        for (int i = 0; i < drivers.size()-1; i++) {
            String plate1 = drivers.get(i).getText();
            String plate2 = drivers.get(i+1).getText();
            assertTrue(plate1.compareTo(plate2)>=0, "Elements are not sorted in descending order");
        }
    }

    @Test(description = "Select All checkbox", invocationCount = 1, enabled = true)
    public void test3() {

        VehiclesPage vehiclesPage = new VehiclesPage();
        List<WebElement> checkboxes = vehiclesPage.checkboxes();

        for (WebElement checkbox : checkboxes) {
            assertFalse(checkbox.isSelected());
        }

        vehiclesPage.checkboxAll.click();
        for (WebElement checkbox : checkboxes) {
            assertTrue(checkbox.isSelected());
        }
    }


}
