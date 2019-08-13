package com.vytrack.tests.components.activites;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.CreateCalendarEventPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import static org.testng.Assert.*;

public class DailyRepeatTests extends TestBase {

    Random ran = new Random();

    @BeforeMethod
    public void setUpMethod2() {

        String userName = ConfigurationReader.get("sales_manager");
        String password = ConfigurationReader.get("password");

        new LoginPage().login(userName, password);
        new DashboardPage().selectMenuOption("Activities", "Calendar Events");
        BrowserUtils.waitForUIOverlay();

        CalendarEventsPage calendarEventsPage =  new CalendarEventsPage();
        calendarEventsPage.createCalendarEvent.click();
        BrowserUtils.waitForUIOverlay();

    }

    @Test(description = "Daily repeat option, Repeat every, summary", invocationCount = 1, enabled = true)
    public void test1() {

        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();
        createCalendarEventPage.repeatCheckbox.click();
        BrowserUtils.waitFor(1);

        String firstSelectedOption = createCalendarEventPage.repeatsDropdown().getFirstSelectedOption().getText();

        assertEquals(firstSelectedOption, "Daily");
        assertTrue(createCalendarEventPage.repeatEvery.isSelected());
        assertEquals(createCalendarEventPage.repeatEveryDaysWindow.getAttribute("value"), "1");

        String summaryText = createCalendarEventPage.summary.getText();
        assertTrue(summaryText.contains("Daily every 1 day"));

        createCalendarEventPage.weekday.click();

        summaryText = createCalendarEventPage.summary.getText();
        assertFalse(createCalendarEventPage.repeatEveryDaysWindow.isEnabled());
        assertTrue(summaryText.contains("Daily, every weekday"));

    }

    @Test(description = "Daily repeat option, Repeat every, default values", invocationCount = 1, enabled = true)
    public void test2() {

        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();
        BrowserUtils.waitForClickablility(createCalendarEventPage.repeatCheckbox, 3);
        createCalendarEventPage.repeatCheckbox.click();
        BrowserUtils.waitFor(1);

        String firstSelectedOption = createCalendarEventPage.repeatsDropdown().getFirstSelectedOption().getText();

        assertEquals(firstSelectedOption, "Daily");
        assertTrue(createCalendarEventPage.repeatEvery.isSelected());
        assertEquals(createCalendarEventPage.repeatEveryDaysWindow.getAttribute("value"), "1");

        String summaryText = createCalendarEventPage.summary.getText();
        assertTrue(summaryText.contains("Daily every 1 day"));
    }

    @Test(description = "Daily repeat option, Repeat every day(s), error messages", invocationCount = 1, enabled = true)
    public void test3() {

        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();
        BrowserUtils.waitForClickablility(createCalendarEventPage.repeatCheckbox, 3);
        createCalendarEventPage.repeatCheckbox.click();
        BrowserUtils.waitFor(1);

        createCalendarEventPage.repeatEveryDaysWindow.clear();
        createCalendarEventPage.repeatEveryDaysWindow.sendKeys("0");
        BrowserUtils.verifyElementDisplayed(createCalendarEventPage.repeatDaysError);

        createCalendarEventPage.repeatEveryDaysWindow.clear();
        createCalendarEventPage.repeatEveryDaysWindow.sendKeys("1");
        BrowserUtils.verifyElementNotDisplayed(createCalendarEventPage.repeatDaysError);

        createCalendarEventPage.repeatEveryDaysWindow.clear();
        createCalendarEventPage.repeatEveryDaysWindow.sendKeys("99");
        BrowserUtils.verifyElementNotDisplayed(createCalendarEventPage.repeatDaysError);

        createCalendarEventPage.repeatEveryDaysWindow.clear();
        createCalendarEventPage.repeatEveryDaysWindow.sendKeys("100");
        BrowserUtils.verifyElementDisplayed(createCalendarEventPage.repeatDaysError);

    }

    @Test(description = "Daily repeat option, Repeat every day(s), functionality", invocationCount = 1, enabled = true)
    public void test4() {

        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();
        BrowserUtils.waitForClickablility(createCalendarEventPage.repeatCheckbox, 3);
        createCalendarEventPage.repeatCheckbox.click();
        BrowserUtils.waitFor(1);

        String days = "" + (ran.nextInt(98) + 1);
        String expected = "Daily every "+days+" days";

        createCalendarEventPage.repeatEveryDaysWindow.clear();
        createCalendarEventPage.repeatEveryDaysWindow.sendKeys(days + Keys.ENTER);

        String summaryText = createCalendarEventPage.summary.getText();
        assertTrue(summaryText.contains(expected));
    }

    @Test(description = "Daily repeat option, blank fields", invocationCount = 1, enabled = true)
    public void test5() {

        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();
        BrowserUtils.waitForClickablility(createCalendarEventPage.repeatCheckbox, 3);
        createCalendarEventPage.repeatCheckbox.click();
        BrowserUtils.waitFor(1);

        createCalendarEventPage.repeatEveryDaysWindow.clear();

        String expectedMessage = "This value should not be blank.";
        String actualMessage = createCalendarEventPage.repeatDaysError.getText();

        BrowserUtils.verifyElementDisplayed(createCalendarEventPage.repeatDaysError);
        assertEquals(actualMessage, expectedMessage);

        String days = "" + (ran.nextInt(98) + 1);
        createCalendarEventPage.repeatEveryDaysWindow.sendKeys(days);
        BrowserUtils.verifyElementNotDisplayed(createCalendarEventPage.repeatDaysError);

        createCalendarEventPage.occurrencesWindow.click();
        createCalendarEventPage.occurrencesWindow.sendKeys(Keys.TAB);
        BrowserUtils.verifyElementDisplayed(createCalendarEventPage.occurrencesError);

        createCalendarEventPage.occurrencesWindow.sendKeys(days);
        BrowserUtils.verifyElementNotDisplayed(createCalendarEventPage.occurrencesError);

    }

    @Test(description = "Daily repeat option, Ends, error messages", invocationCount = 1, enabled = true)
    public void test6() {

        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();
        BrowserUtils.waitForClickablility(createCalendarEventPage.repeatCheckbox, 3);
        createCalendarEventPage.repeatCheckbox.click();
        BrowserUtils.waitFor(1);

        createCalendarEventPage.occurrencesWindow.click();
        createCalendarEventPage.occurrencesWindow.sendKeys("0" + Keys.TAB);
        BrowserUtils.verifyElementDisplayed(createCalendarEventPage.occurrencesError);

        createCalendarEventPage.occurrencesWindow.clear();
        createCalendarEventPage.occurrencesWindow.sendKeys("1"+ Keys.TAB);
        BrowserUtils.verifyElementNotDisplayed(createCalendarEventPage.occurrencesError);

        createCalendarEventPage.occurrencesWindow.clear();
        createCalendarEventPage.occurrencesWindow.sendKeys("999"+ Keys.TAB);
        BrowserUtils.verifyElementNotDisplayed(createCalendarEventPage.occurrencesError);

        createCalendarEventPage.occurrencesWindow.clear();
        createCalendarEventPage.occurrencesWindow.sendKeys("1000"+ Keys.TAB);
        BrowserUtils.verifyElementDisplayed(createCalendarEventPage.occurrencesError);

    }

    @Test(description = "Daily repeat option, Ends, functionality", invocationCount = 1, enabled = true)
    public void test7() {

        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();
        BrowserUtils.waitForClickablility(createCalendarEventPage.repeatCheckbox, 3);
        createCalendarEventPage.repeatCheckbox.click();
        BrowserUtils.waitFor(1);

        String occur = "" + (ran.nextInt(998) + 1);
        String expected = "Daily every 1 day, end after "+occur+" occurrences";

        createCalendarEventPage.occurrencesWindow.click();
        createCalendarEventPage.occurrencesWindow.sendKeys(occur + Keys.TAB);

        assertTrue(createCalendarEventPage.summary.getText().contains(expected));

        occur = "" + (ran.nextInt(998) + 1);
        expected = "Daily every 1 day, end after "+occur+" occurrences";

        createCalendarEventPage.occurrencesWindow.clear();
        createCalendarEventPage.occurrencesWindow.sendKeys(occur + Keys.TAB);

        assertTrue(createCalendarEventPage.summary.getText().contains(expected));

    }
}
