package com.vytrack.utilities;

import com.vytrack.pages.*;

public class Pages {
    private LoginPage loginPage;
    private CalendarEventsPage calendarEventsPage;
    private CreateCalendarEventPage createCalendarEventPage;
    private DashboardPage dashboardPage;
    private VehiclesPage vehiclesPage;

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public CalendarEventsPage calendarEventsPage() {
        if (calendarEventsPage == null) {
            calendarEventsPage = new CalendarEventsPage();
        }
        return calendarEventsPage;
    }

    public DashboardPage dashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public CreateCalendarEventPage createCalendarEventPage() {
        if (createCalendarEventPage == null) {
            createCalendarEventPage = new CreateCalendarEventPage();
        }
        return createCalendarEventPage;
    }

    public VehiclesPage vehiclesPage() {
        if (vehiclesPage == null) {
            vehiclesPage = new VehiclesPage();
        }
        return vehiclesPage;
    }
}
