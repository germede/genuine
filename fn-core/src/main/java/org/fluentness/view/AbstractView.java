package org.fluentness.view;

import org.fluentness.view.View;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.layout.TabLayout;
import org.fluentness.view.component.misc.Separator;
import org.fluentness.view.component.navigation.Navigation;
import org.fluentness.view.component.table.Table;
import org.fluentness.view.component.text.form.Button;
import org.fluentness.view.component.text.Heading;
import org.fluentness.view.component.text.Text;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public abstract class AbstractView implements View {

    protected final CharSequence title;

    public AbstractView(CharSequence title) {
        this.title = title;
    }

    @Override
    public final CharSequence getTitle() {
        return title;
    }

    protected abstract void structure(Component component);

    protected abstract LinearLayout linearLayout(Component... components);

    protected abstract TabLayout tabLayout(TabLayout.Tab... tabs);

    protected final <C> TabLayout.Tab<C> tab(CharSequence name, C content) {
        return new TabLayout.Tab<>(name, content);
    }


    protected abstract Separator separator();


    protected abstract Navigation navigation();

    protected abstract Table table(CharSequence[] header, Object[]... rows);

    protected final CharSequence[] header(CharSequence... columns) {
        return columns;
    }

    protected final Object[] row(Object... cells) {
        return cells;
    }

    protected Button button(CharSequence text) {
        return button(Button.Type.PRIMARY, text);
    }

    protected abstract Button button(Button.Type type, CharSequence text);

    protected Heading heading(CharSequence text) {
        return heading(Heading.Level.H1, text);
    }

    protected abstract Heading heading(Heading.Level level, CharSequence text);

    protected abstract Text text(CharSequence text);


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
