package stacja.tabelka.v8.pageFactoryWithComponent.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import stacja.Global;
import stacja.tabelka.v8.pageFactoryWithComponent.components.TableComponent;

public class MarketSharePage extends TemplatePage {

    @Getter
    @FindBy(css = ".container")
    private TableComponent table;

    public MarketSharePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        getDriver().get(Global.PAGE_URL + "/table/");
    }


}
