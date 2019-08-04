package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehiclesPage extends NavigationBar{

    public VehiclesPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (css = "tr th input")
    public WebElement checkboxAll;

    @FindBy (css = "div[class='page-size pull-right form-horizontal'] button[data-toggle='dropdown']")
    public WebElement viewsPerPage;

    @FindBy (css = "a[title='Filters']")
    public WebElement filters;

    @FindBy (css = "a[title='Refresh']")
    public WebElement refresh;

    @FindBy (css = "a[title='Reset']")
    public WebElement reset;

    @FindBy (css = "a[title='Grid Settings']")
    public WebElement grid;

    @FindBy (css = "table.table-bordered th")
    public List<WebElement> gridHeaders;


    public WebElement getGridSettingsCheckbox(String header) {
        String xpath = "//label[.='" + header + "']/../../td[last()]/input";
        return Driver.get().findElement(By.xpath(xpath));
    }

    public List<WebElement> getCellsInColumn(String colName) {
        int idx = -1;
        for (int i = 0; i < gridHeaders.size(); i++) {
            if (gridHeaders.get(i).getText().equalsIgnoreCase(colName)) {
                idx = i + 1;
                break;
            }
        }
        List<WebElement> cellsInColumn = Driver.get().findElements(By.xpath("//tr/td[" + idx + "]"));
        return cellsInColumn;
    }

    public WebElement header(String colName) {
        for (int i = 0; i < gridHeaders.size(); i++) {
            if (gridHeaders.get(i).getText().equalsIgnoreCase(colName)) {
                return gridHeaders.get(i);
            }
        }
        return null;
    }

    public List<WebElement> checkboxes() {
        return Driver.get().findElements(By.xpath("//tbody/tr//input"));
    }
}

