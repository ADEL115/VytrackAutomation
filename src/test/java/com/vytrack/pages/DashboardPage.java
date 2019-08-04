package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends NavigationBar{

    public DashboardPage() {
        PageFactory.initElements(Driver.get(), this);
    }
}
