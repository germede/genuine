package org.fluentness.view;

import org.fluentness.view.component.text.Button;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.container.Container;
import org.fluentness.view.component.container.LinearLayout;
import org.fluentness.view.component.table.Table;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public abstract class AbstractView<
    C extends Component,
    Co extends Container,
    B extends Button,
    T extends Table,
    LL extends LinearLayout
    >

    implements View {

    protected abstract Co structure();

    protected abstract LL linearLayout(int orientation, C... components);

    protected abstract B button(CharSequence text);

    protected abstract T table(CharSequence[] header, Object[]... rows);

    protected final CharSequence[] header(CharSequence... columns) {
        return columns;
    }

    protected final Object[] row(Object... cells) {
        return cells;
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
