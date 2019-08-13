package com.vytrack.step_definitions;

import com.vytrack.pages.VehiclesPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Pages;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class VehiclesStepDefs {

    Pages pages = new Pages();
    @Then("All records are displayed by {string} in {string} order")
    public void all_records_are_displayed_by_in(String header, String order) {

        List<WebElement> licensePlates = pages.vehiclesPage().getCellsInColumn(header);

        for (int i = 0; i < licensePlates.size()-1; i++) {
            String plate1 = licensePlates.get(i).getText();
            String plate2 = licensePlates.get(i+1).getText();
            if (order.equalsIgnoreCase("ascending"))
                assertTrue(plate1.compareTo(plate2)<=0, "Elements are not sorted in ascending order");
            else if (order.equalsIgnoreCase("descending"))
                assertTrue(plate1.compareTo(plate2)>=0, "Elements are not sorted in descending order");
            else throw new RuntimeException("<<<Wrong input>>>");
        }
    }

    @When("I click on header {string}")
    public void i_click_on_header(String header) {
        pages.vehiclesPage().header(header).click();
        BrowserUtils.waitFor(1);
    }

    @Then("None of the checkboxes are selected")
    public void none_of_the_checkboxes_are_selected() {

        List<WebElement> checkboxes = pages.vehiclesPage().checkboxes();

        for (WebElement checkbox : checkboxes) {
            assertFalse(checkbox.isSelected());
        }
    }

    @When("I click on the checkbox in the headers row")
    public void i_click_on_the_checkbox_in_the_headers_row() {
        pages.vehiclesPage().checkboxAll.click();
    }

    @Then("All of the checkboxes are selected")
    public void all_of_the_checkboxes_are_now_selected() {
        List<WebElement> checkboxes = pages.vehiclesPage().checkboxes();

        for (WebElement checkbox : checkboxes) {
            assertTrue(checkbox.isSelected());
        }
    }
}
