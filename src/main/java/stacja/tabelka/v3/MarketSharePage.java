package stacja.tabelka.v3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stacja.Global;

import java.time.Duration;
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

    public void open() {
        driver.get(Global.PAGE_URL + "/table/");
    }

    public WebElement getTable() {
        return driver.findElement(tableSelector);
    }

    public String getTitle() {
        return driver.findElement(titleSeletor).getText();
    }

    public List<String> getColumnsNames() {
        var columns = driver.findElements(columnSelector);
        return columns.stream().map(WebElement::getText).toList();
    }

    public List<WebElement> getRows() {
        return driver.findElements(rowsSelector);
    }

    public void waitForRecords() {
        ExpectedCondition condition = ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElement(getTable(), "Loading...")
        );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(condition);
    }

    public List<WebElement> findRowByColumnValue(String columnName, String cellValue) {
        int columnPos = getColumnsNames().indexOf(columnName);
        for (WebElement row : getRows()) {
            List<WebElement> cell = row.findElements(By.cssSelector("th, td"));
            WebElement columnValue = cell.get(columnPos);
            if (cellValue.equals(columnValue.getText())) {
                return cell;
            }
        }
        return null;
    }

}
