package org.fluentness.controller.web.markup.html;

import org.fluentness.controller.web.markup.MarkupView;
import org.fluentness.repository.Model;

import java.util.Arrays;
import java.util.List;

import static org.fluentness.controller.web.markup.html.HtmlViewFactory.*;

public class TableHtmlView extends ContainerHtmlView {
    public TableHtmlView(List<? extends Model> modelList, String[] headers) {
        super("table", renderTable(modelList, headers));
    }

    private static MarkupView[] renderTable(List<? extends Model> modelList, String[] headers) {
        return new MarkupView[]{
            thead(
                tr(
                    Arrays.stream(headers).map(header -> th(() -> header)).toArray(MarkupView[]::new)
                )
            ),
            tbody(forEach(modelList, model -> tr(
                model.getFields().stream()
                    .map(field ->
                        td(() -> {
                            try {
                                field.setAccessible(true);
                                Object o = field.get(model);
                                field.setAccessible(false);
                                return String.valueOf(o);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                            return "";
                        })
                    )
                    .toArray(MarkupView[]::new)
            )))
        };
    }
}
