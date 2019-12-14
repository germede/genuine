package org.fluentness.view.web;

import org.fluentness.model.Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.fluentness.view.web.HtmlFactory.*;

public class HtmlTable<M extends Model> extends HtmlContainer {

    private final List<M> list;
    private final Method[] getters;
    private AppendColumnView<M> appendColumnView;

    public HtmlTable(List<M> list) {
        super("table");
        this.list = list;
        this.getters = (list == null || list.isEmpty()) ?
            new Method[0] :
            Model.getGetters(list.get(0).getClass());
    }

    public HtmlTable<M> appendColumn(AppendColumnView<M> appendColumnView) {
        this.appendColumnView = appendColumnView;
        return this;
    }

    @Override
    public String render() {
        this.innerViews = Arrays.asList(renderTable());
        return super.render();
    }

    private WebView[] renderTable() {
        return new WebView[]{
            thead(tr(renderHeader())),
            tbody(renderRows())
        };
    }

    private WebView[] renderHeader() {
        return Arrays.stream(getters).map(field ->
            th(() ->
                field.getName().replace("get", "")
            )
        ).toArray(WebView[]::new);
    }

    private WebView[] renderRows() {
        return list.stream().map(object -> tr(renderRow(object))).toArray(WebView[]::new);
    }

    private WebView[] renderRow(M object) {
        List<WebView> collect = Arrays.stream(getters)
            .map(method ->
                td(() -> {
                    try {
                        return String.valueOf(method.invoke(object));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    return "";
                })
            )
            .collect(Collectors.toList());
        if (appendColumnView != null) {
            collect.add(appendColumnView.toAppend(object));
        }
        return collect.toArray(new WebView[0]);
    }

    @FunctionalInterface
    public interface AppendColumnView<T> {
        WebView toAppend(T t);
    }
}
