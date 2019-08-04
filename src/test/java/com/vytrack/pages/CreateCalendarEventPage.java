package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCalendarEventPage extends NavigationBar{

    public CreateCalendarEventPage() {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy (css = "input[id^=date_selector_oro_calendar_event_form_start-uid]")
    public WebElement dateStart;

    @FindBy (css = "input[id^=date_selector_oro_calendar_event_form_end-uid]")
    public WebElement dateEnd;

    @FindBy (css = "input[id^=time_selector_oro_calendar_event_form_start-uid]")
    public WebElement timeStart;

    @FindBy (css = "input[id^=time_selector_oro_calendar_event_form_end-uid]")
    public WebElement timeEnd;

    public WebElement selectStartTime(String startTime) {
        String timeXpath = "//li[contains(text(), '"+startTime+"')]";
        return Driver.get().findElement(By.xpath(timeXpath));
    }

    @FindBy (css = "input[id^=recurrence-repeat]")
    public WebElement repeatCheckbox;

    @FindBy (css = "select[id^=recurrence-repeats]")
    public WebElement repeatOptions;

    public Select repeatsDropdown() {
        return new Select(repeatOptions);
    }

    @FindBy (xpath = "//input[@type='radio']")
    public WebElement repeatEvery;

    @FindBy (css = "input.recurrence-subview-control__number")
    public WebElement repeatEveryDaysWindow;

    @FindBy (css = "div[class='controls recurrence-subview-control__items validation-error']>div.recurrence-subview-control__item>span.validation-failed")
    public WebElement repeatDaysError;

    @FindBy (xpath = "(//input[@type='radio'])[2]")
    public WebElement weekday;

    @FindBy (xpath = "(//input[starts-with(@class, 'recurrence-subview-control__number')])[7]")
    public WebElement occurrencesWindow;

    @FindBy (css = "div[class='controls recurrence-subview-control recurrence-subview-control__items validation-error']>div.recurrence-subview-control__item>span.validation-failed")
    public WebElement occurrencesError;

    @FindBy (xpath = "//div[@class='control-group recurrence-summary alert-info']")
    public WebElement summary;





}

