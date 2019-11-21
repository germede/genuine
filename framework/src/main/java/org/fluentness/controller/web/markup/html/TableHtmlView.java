package org.fluentness.controller.web.markup.html;

import org.fluentness.controller.web.markup.MarkupView;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static org.fluentness.controller.web.markup.html.HtmlViewFactory.*;

public class TableHtmlView extends ContainerHtmlView {
    public TableHtmlView(List modelList) {
        super("table", renderTable(modelList));
    }

    private static MarkupView[] renderTable(List modelList) {
        if (modelList == null || modelList.isEmpty()) {
            return new MarkupView[0];
        }
        Class<?> aClass = modelList.get(0).getClass();
        Field[] fields = aClass.getDeclaredFields();
        return new MarkupView[]{
            thead(
                tr(
                    Arrays.stream(fields)
                        .map(field -> th(field::getName))
                        .toArray(MarkupView[]::new)
                )
            ),
            tbody(
                (MarkupView[]) modelList.stream()
                    .map(object ->
                        tr(
                            Arrays.stream(object.getClass().getDeclaredFields())
                                .map(field ->
                                    td(() -> {
                                        try {
                                            field.setAccessible(true);
                                            Object fieldValue = field.get(object);
                                            field.setAccessible(false);
                                            return String.valueOf(fieldValue);
                                        } catch (IllegalAccessException e) {
                                            e.printStackTrace();
                                        }
                                        return "";
                                    })
                                )
                                .toArray(MarkupView[]::new)
                        )
                    )
                    .toArray(MarkupView[]::new)
            )
        };
    }
}
