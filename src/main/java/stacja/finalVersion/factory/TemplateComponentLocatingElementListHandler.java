package stacja.finalVersion.factory;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import stacja.finalVersion.components.ShopItemComponent;
import stacja.finalVersion.components.TemplateComponent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@AllArgsConstructor
public class TemplateComponentLocatingElementListHandler<GenericType extends TemplateComponent> implements InvocationHandler {
    private final ElementLocator locator;

    private final Class<GenericType> objectType;

    private GenericType toComponentElement(WebElement element) {
        try {
            var constructor = objectType.getConstructor(WebElement.class);
            return constructor.newInstance(element);
        } catch (Exception ex) {
            return null;
        }
    }

    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        List<WebElement> elements = this.locator.findElements();
        List<GenericType> objectElements = elements.stream().map(this::toComponentElement).toList();
        try {
            return method.invoke(objectElements, objects);
        } catch (InvocationTargetException var6) {
            throw var6.getCause();
        }
    }

}
