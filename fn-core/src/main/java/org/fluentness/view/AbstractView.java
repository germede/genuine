package org.fluentness.view;

import org.fluentness.view.component.layout.TabLayout;
import org.fluentness.view.component.text.Button;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.table.Table;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public abstract class AbstractView

    implements View {

    protected abstract Component structure();

    protected abstract LinearLayout linearLayout(int orientation, Component... components);

    protected abstract Button button(CharSequence text);

    protected abstract Table table(CharSequence[] header, Object[]... rows);

    protected final CharSequence[] header(CharSequence... columns) {
        return columns;
    }

    protected final Object[] row(Object... cells) {
        return cells;
    }

    protected abstract TabLayout tabLayout(TabLayout.Tab... tabs);

    protected final <C> TabLayout.Tab<C> tab(CharSequence name, C content) {
        return new TabLayout.Tab<>(name, content);
    }

    public <T, V extends CharSequence> CharSequence forEach(Iterable<T> iterable, Function<T, V> function) {
        List<String> result = new LinkedList<>();
        for (T t : iterable) {
            result.add(function.apply(t).toString());
        }
        return String.join("", result);
    }

    public <T, V extends CharSequence> CharSequence forEach(T[] iterable, Function<T, V> function) {
        List<String> result = new LinkedList<>();
        for (T t : iterable) {
            result.add(function.apply(t).toString());
        }
        return String.join("", result);
    }

}
