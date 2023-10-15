package stacja.tabelka.v2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MarketSharePage {

    private final WebDriver driver;
    private By tableSelector = By.cssSelector("table");
    private By titleSeletor = By.cssSelector("h2");
    private By columnSelector = By.cssSelector("thead tr th");
    private By rowsSelector = By.cssSelector("tbody tr");

    public MarketSharePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTable() {
        return driver.findElement(tableSelector);
    }

    public WebElement getTitle() {
        return driver.findElement(titleSeletor);
    }

    public List<WebElement> getColumns() {
        return driver.findElements(columnSelector);
    }

    public List<WebElement> getRows() {
        return driver.findElements(rowsSelector);
    }

}
