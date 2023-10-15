package stacja.tabelka.v4pageFactory;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public /*abstract*/ class TemplatePage {

    @Getter
    private final WebDriver driver;

    TemplatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    abstract void open();

}
