package stacja.tabelka.v7.pageFactoryWithComponent.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import stacja.Global;
import stacja.tabelka.v7.pageFactoryWithComponent.components.TableComponent;

public class MarketSharePage extends TemplatePage {

    @Getter
    @FindBy(css = ".container")
    private WebElement tableContainer;

//    @Getter
//    @FindBy(css = ".otherContainer")
//    private WebElement anotherTableContainer;

    public MarketSharePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        getDriver().get(Global.PAGE_URL + "/table/");
    }

    public TableComponent getTable() {
        return new TableComponent(getTableContainer());
    }

}
