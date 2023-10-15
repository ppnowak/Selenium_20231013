package stacja.finalVersionNotWorking.finalVersion.factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import stacja.finalVersionNotWorking.finalVersion.components.TemplateComponent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class TemplateComponentLocatingElementListHandler implements InvocationHandler {
    private final ElementLocator locator;

    public TemplateComponentLocatingElementListHandler(ElementLocator locator) {
        this.locator = locator;
    }

    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        List<WebElement> elements = this.locator.findElements();
        List<TemplateComponent> objectElements = elements.stream().map(TemplateComponent::new).toList();
        try {
            return method.invoke(objectElements, objects);
        } catch (InvocationTargetException var6) {
            throw var6.getCause();
        }
    }

}
