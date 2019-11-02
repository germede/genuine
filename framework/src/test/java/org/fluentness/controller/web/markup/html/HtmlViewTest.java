package org.fluentness.controller.web.markup.html;

import org.fluentness.controller.web.WebViewFactory;
import org.fluentness.controller.web.markup.MarkupView;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class HtmlViewTest {

    @Test
    public void htmlView_allMethodsAreCalled_allHtmlAttributes() throws InvocationTargetException, IllegalAccessException {
        MarkupView test = WebViewFactory.p("test");
        int i = 0;
        for (Method method : HtmlView.class.getDeclaredMethods()) {
            test = (MarkupView) method.invoke(test, "testValue");
            String name = method.getName();
            String methodName = name.charAt(name.length() - 1) == '_' ?
                name.replace("_", "") :
                name.replace("_", "-");
            assertEquals("testValue", test.getAttributes().get(methodName));
            i++;
        }
        assertEquals(115, i);
    }

}
