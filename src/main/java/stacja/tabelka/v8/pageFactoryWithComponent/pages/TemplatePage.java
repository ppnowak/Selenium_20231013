package stacja.tabelka.v8.pageFactoryWithComponent.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import stacja.tabelka.v8.pageFactoryWithComponent.factory.CustomFieldDecorator;
import stacja.tabelka.v8.pageFactoryWithComponent.factory.CustomPageFactory;

public /*abstract*/ class TemplatePage {

    @Getter
    private final WebDriver driver;

    TemplatePage(WebDriver driver) {
        this.driver = driver;

//        var elementLocatorFactory = new DefaultElementLocatorFactory(driver);
//        var fieldDecorator = new CustomFieldDecorator(elementLocatorFactory);
//        PageFactory.initElements(fieldDecorator, this);

        CustomPageFactory.init(driver, this);
    }

//    abstract void open();

}
