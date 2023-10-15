package stacja.tabelka.v5.pageFactoryWithComponent;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stacja.Global;

import java.time.Duration;
import java.util.List;

public class MarketSharePage extends TemplatePage {

    @Getter
    @FindBy(css = ".container")
    private WebElement tableContainer;

    MarketSharePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        getDriver().get(Global.PAGE_URL + "/table/");
    }

    public TableComponent getTable() {
        return new TableComponent(getDriver(), getTableContainer());
    }

}
