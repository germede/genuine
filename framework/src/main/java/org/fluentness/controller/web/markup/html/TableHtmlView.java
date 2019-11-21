package org.fluentness.controller.web.markup.html;

import org.fluentness.controller.web.markup.MarkupView;
import org.fluentness.repository.field.FieldExtractor;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fluentness.controller.web.markup.html.HtmlViewFactory.*;

public class TableHtmlView<T> extends ContainerHtmlView {

    private final List<T> list;
    private final List<Field> fields;
    private AppendColumnView<T> appendColumnView;

    public TableHtmlView(List<T> list) {
        super("table");
        this.list = list;
        this.fields = (list == null || list.isEmpty()) ?
            new LinkedList<>() :
            FieldExtractor.INSTANCE.getModelFields(list.get(0));
    }

    public TableHtmlView<T> appendColumn(AppendColumnView<T> appendColumnView) {
        this.appendColumnView = appendColumnView;
        return this;
    }

    @Override
    public String render() {
        this.innerViews = Arrays.asList(renderTable());
        return super.render();
    }

    private MarkupView[] renderTable() {
        return new MarkupView[]{
            thead(tr(renderHeader())),
            tbody(renderRows())
        };
    }

    private MarkupView[] renderHeader() {
        return fields.stream().map(field -> th(field::getName)).toArray(MarkupView[]::new);
    }

    private MarkupView[] renderRows() {
        return list.stream().map(object -> tr(renderRow(object))).toArray(MarkupView[]::new);
    }

    private MarkupView[] renderRow(T object) {
        List<MarkupView> collect = fields.stream()
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
            .collect(Collectors.toList());
        if (appendColumnView != null) {
            collect.add(appendColumnView.toAppend(object));
        }
        return collect.toArray(new MarkupView[0]);
    }

    @FunctionalInterface
    public interface AppendColumnView<T> {
        MarkupView toAppend(T t);
    }
}
