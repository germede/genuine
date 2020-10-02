package org.fluentness.view;

import org.fluentness.view.component.Component;
import org.fluentness.view.component.dialog.Dialog;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.layout.TabLayout;
import org.fluentness.view.component.misc.Separator;
import org.fluentness.view.component.navigation.Navigation;
import org.fluentness.view.component.table.Table;
import org.fluentness.view.component.text.Heading;
import org.fluentness.view.component.text.Text;
import org.fluentness.view.component.text.form.Button;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public abstract class BaseView<
    B extends Button,
    C extends Component,
    D extends Dialog,
    H extends Heading,
    LL extends LinearLayout,
    N extends Navigation,
    S extends Separator,
    TL extends TabLayout,
    Ta extends Table,
    T extends Text
    > implements View {

    protected final CharSequence title;

    public BaseView(CharSequence title) {
        this.title = title;
    }

    @Override
    public final CharSequence getTitle() {
        return title;
    }

    protected final B button(CharSequence text) {
        return button(Button.Type.PRIMARY, text);
    }

    protected abstract B button(Button.Type type, CharSequence text);

    protected abstract D dialog(C... components);

    public static <T, C extends Component> C[] forEach(Iterable<T> iterable, Function<T, C> function) {
        List<C> result = new LinkedList<>();
        for (T t : iterable) {
            result.add(function.apply(t));
        }
        return (C[]) result.toArray(new Component[0]);
    }

    protected final CharSequence[] header(CharSequence... columns) {
        return columns;
    }

    protected final H heading(CharSequence text) {
        return heading(Heading.Level.H1, text);
    }

    protected abstract H heading(H.Level level, CharSequence text);

    protected abstract LL linearLayout(C... components);

    protected abstract N navigation();

    protected final Object[] row(Object... cells) {
        return cells;
    }

    protected abstract S separator();

    protected abstract C structure();

    protected static <C> TabLayout.Tab<C> tab(CharSequence name, C content) {
        return new TabLayout.Tab<>(name, content);
    }

    protected abstract TL tabLayout(TL.Tab... tabs);

    protected abstract Ta table(CharSequence[] header, Object[]... rows);

    protected abstract T text(CharSequence text);

}
