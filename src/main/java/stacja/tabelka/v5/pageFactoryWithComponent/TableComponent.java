package stacja.tabelka.v5.pageFactoryWithComponent;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TableComponent {

    @Getter
    @FindBy(css = "table")
    private WebElement table;

    @Getter
    @FindBy(css = "h2")
    private WebElement titleElement;

    @Getter
    @FindBy(css = "thead tr th")
    List<WebElement> columnsList;

    @Getter
    @FindBy(css = "tbody tr")
    List<WebElement> rows;

    private final WebElement container;
    @Getter
    private final WebDriver driver;

    public TableComponent(WebDriver driver, WebElement tableContainer) {
        this.driver = driver;
        this.container = tableContainer;
        PageFactory.initElements(tableContainer, this);
    }

    public void waitForRecords() {
        ExpectedCondition condition = ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElement(getTable(), "Loading...")
        );
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(condition);
    }

    public String getTitle() {
//        driver.findElement(/*@FindBy(css = "h2")*/).getText()
        return getTitleElement().getText();
    }

    public List<String> getColumnsNames() {
        return getColumnsList().stream().map(WebElement::getText).toList();
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
