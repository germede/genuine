package org.fluentness.controller.web.view;

import org.fluentness.repository.Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.fluentness.controller.web.view.HtmlFactory.*;

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

    private HtmlView[] renderTable() {
        return new HtmlView[]{
            thead(tr(renderHeader())),
            tbody(renderRows())
        };
    }

    private HtmlView[] renderHeader() {
        return Arrays.stream(getters).map(field -> th(field.getName().replace("get", ""))).toArray(HtmlView[]::new);
    }

    private HtmlView[] renderRows() {
        return list.stream().map(object -> tr(renderRow(object))).toArray(HtmlView[]::new);
    }

    private HtmlView[] renderRow(M object) {
        List<HtmlView> collect = new LinkedList<>();
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
        return collect.toArray(new HtmlView[0]);
    }

    @FunctionalInterface
    public interface AppendColumnView<T> {
        HtmlView toAppend(T t);
    }
}
