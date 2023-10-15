package stacja.shop.v2.factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import stacja.shop.v2.components.ShopItemComponent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ShopItemComponentLocatingElementListHandler implements InvocationHandler {
    private final ElementLocator locator;

    public ShopItemComponentLocatingElementListHandler(ElementLocator locator) {
        this.locator = locator;
    }

    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        List<WebElement> elements = this.locator.findElements();
        List<ShopItemComponent> objectElements = elements.stream().map(ShopItemComponent::new).toList();
        try {
            return method.invoke(objectElements, objects);
        } catch (InvocationTargetException var6) {
            throw var6.getCause();
        }
    }

}
