package stacja.shop.v1.notWorking.factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import stacja.shop.v1.notWorking.components.ShopItemComponent;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class CustomFieldDecorator extends DefaultFieldDecorator {
    public CustomFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    public Object decorate(ClassLoader loader, Field field) {
        if (List.class.isAssignableFrom(field.getType())) {
            Class<?> wrappedClass = (Class) (((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0]);
            if (wrappedClass != null && ShopItemComponent.class.isAssignableFrom(wrappedClass)) {
                ElementLocator locator = this.factory.createLocator(field);
                List<WebElement> elements = List.class.isAssignableFrom(field.getType()) ? this.proxyForListLocator(loader, locator) : null;
                return elements.stream().map(ShopItemComponent::new).toList();
            }
        }
        return super.decorate(loader, field);
    }

}
