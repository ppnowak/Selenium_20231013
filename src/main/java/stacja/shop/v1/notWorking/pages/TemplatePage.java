package stacja.shop.v1.notWorking.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import stacja.shop.v1.notWorking.factory.CustomPageFactory;

public class TemplatePage {

    @Getter
    private final WebDriver driver;

    public TemplatePage(WebDriver driver) {
        this.driver = driver;
        CustomPageFactory.init(driver, this);
    }

}
