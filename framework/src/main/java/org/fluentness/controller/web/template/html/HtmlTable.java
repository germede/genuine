package org.fluentness.controller.web.template.html;

import org.fluentness.repository.Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.fluentness.controller.web.View.html.HtmlFactory.*;

public class HtmlTable<M extends Model> extends HtmlElement {

    private final List<M> list;
    private final Method[] getters;
    private AppendColumnView<M> appendColumnView;

    public HtmlTable(List<M> list) {
        super("table");
        this.list = list;
        this.getters = (list == null || list.isEmpty()) ?
            new Method[0] :
            list.get(0).getGetters();
    }

    public HtmlTable<M> appendColumn(AppendColumnView<M> appendColumnView) {
        this.appendColumnView = appendColumnView;
        return this;
    }

    @Override
    public String render() {
        this.html = Arrays.asList(renderTable());
        return super.render();
    }

    private Html[] renderTable() {
        return new Html[]{
            thead(tr(renderHeader())),
            tbody(renderRows())
        };
    }

    private Html[] renderHeader() {
        return Arrays.stream(getters).map(field -> th(field.getName().replace("get", ""))).toArray(Html[]::new);
    }

    private Html[] renderRows() {
        return list.stream().map(object -> tr(renderRow(object))).toArray(Html[]::new);
    }

    private Html[] renderRow(M object) {
        List<Html> collect = new LinkedList<>();
        try {
            for (Method method : getters) {
                collect.add(td(String.valueOf(method.invoke(object))));
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        if (appendColumnView != null) {
            collect.add(appendColumnView.toAppend(object));
        }
        return collect.toArray(new Html[0]);
    }

    @FunctionalInterface
    public interface AppendColumnView<T> {
        Html toAppend(T t);
    }
}
