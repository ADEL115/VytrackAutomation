package com.vytrack.tests.components.activites;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.CreateCalendarEventPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DateAndTimeTest extends TestBase {

    @BeforeMethod
    public void setUpMethod2() {

        String userName = ConfigurationReader.get("store_manager");
        String password = ConfigurationReader.get("password");

        new LoginPage().login(userName, password);
        new DashboardPage().selectMenuOption("Activities", "Calendar Events");
        BrowserUtils.waitForUIOverlay();

        CalendarEventsPage calendarEventsPage =  new CalendarEventsPage();
        calendarEventsPage.createCalendarEvent.click();
        BrowserUtils.waitForUIOverlay();

    }

    @Test (description = "End date auto adjust", invocationCount = 1, enabled = true)
    public void test1() {

        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();
        createCalendarEventPage.dateStart.clear();

        String futureStart = BrowserUtils.dateTime(driver, "date", 1);
        createCalendarEventPage.dateStart.sendKeys(futureStart + Keys.TAB);
        BrowserUtils.waitFor(1);

        String futureEnd = createCalendarEventPage.dateEnd.getAttribute("value");

        assertEquals(futureStart, futureEnd, "<< End date is not the same as start date >>");

        createCalendarEventPage.dateStart.clear();
        String dateNow = BrowserUtils.dateTime(driver, "date", 0);
        createCalendarEventPage.dateStart.sendKeys(dateNow + Keys.TAB);

        futureEnd = createCalendarEventPage.dateEnd.getAttribute("value");
        assertEquals(dateNow, futureEnd, "<< End date did not change to todays date >>");

    }

    @Test (description = "End time auto adjust", invocationCount = 1, enabled = true)
    public void test2() {

        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();
        actions.moveToElement(createCalendarEventPage.timeStart).click().pause(200)
                                            .sendKeys(Keys.ARROW_DOWN).pause(200)
                                            .sendKeys(Keys.ARROW_DOWN).pause(200)
                                            .sendKeys(Keys.ENTER).build().perform();

        String endTimeActual = createCalendarEventPage.timeEnd.getAttribute("value");

        actions.moveToElement(createCalendarEventPage.timeStart).click().pause(200)
                                            .sendKeys(Keys.ARROW_DOWN).pause(200)
                                            .sendKeys(Keys.ARROW_DOWN).pause(200)
                                            .sendKeys(Keys.ENTER).build().perform();

        String endTimeExpected = createCalendarEventPage.timeStart.getAttribute("value");

        BrowserUtils.waitFor(1);
        assertEquals(endTimeActual, endTimeExpected, "<< End time is not 1 hr ahead >>");

    }

    @Test (description = "Date Time, End date/time auto adjust", invocationCount = 1, enabled = true)
    public void test3() {

        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();
        createCalendarEventPage.timeStart.click();

        createCalendarEventPage.selectStartTime("11:30 PM").click();
        BrowserUtils.waitFor(1);

        String dateExpected = BrowserUtils.dateTime(driver,"date",1);
        String timeExpected = "12:30 AM";

        String dateActual = createCalendarEventPage.dateEnd.getAttribute("value");
        String timeActual = createCalendarEventPage.timeEnd.getAttribute("value");

        assertEquals(timeActual, timeExpected, "<< Time is not 12:30 AM >>");
        assertEquals(dateActual, dateExpected, "<< It is not tomorrow's date >>");

    }
}
