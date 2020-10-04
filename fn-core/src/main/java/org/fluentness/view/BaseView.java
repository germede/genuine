package org.fluentness.view;

import org.fluentness.view.component.Component;
import org.fluentness.view.component.form.Field;
import org.fluentness.view.component.form.Form;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.layout.TabLayout;
import org.fluentness.view.component.misc.Separator;
import org.fluentness.view.component.modal.Modal;
import org.fluentness.view.component.navigation.Navigation;
import org.fluentness.view.component.table.Table;
import org.fluentness.view.component.text.Button;
import org.fluentness.view.component.text.Heading;
import org.fluentness.view.component.text.Text;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public abstract class BaseView<
    B extends Button,
    C extends Component,
    Fi extends Field,
    Fo extends Form,
    H extends Heading,
    LL extends LinearLayout,
    M extends Modal,
    N extends Navigation,
    S extends Separator,
    TL extends TabLayout,
    Ta extends Table,
    T extends Text
    > implements View {

    protected CharSequence title;

    @Override
    public final CharSequence getTitle() {
        return title;
    }

    protected final B button(CharSequence text) {
        return button(Button.Type.PRIMARY, text);
    }

    protected abstract B button(Button.Type type, CharSequence text);

    public static <T, C extends Component> C[] forEach(Iterable<T> iterable, Function<T, C> function) {
        List<C> result = new LinkedList<>();
        for (T t : iterable) {
            result.add(function.apply(t));
        }
        return (C[]) result.toArray(new Component[0]);
    }

    protected final Fi field(String name) {
        return field(name, Field.Type.TEXT);
    }

    protected final Fi field(String name, Field.Type type) {
        return field(name, type, name);
    }

    protected final Fi field(String name, CharSequence placeholder) {
        return field(name, Field.Type.TEXT, placeholder);
    }

    protected final Fi field(String name, Field.Type type, CharSequence placeholder) {
        return field(name, type, placeholder, true);
    }

    protected abstract Fi field(String name, Field.Type type, CharSequence placeholder, boolean required);

    protected abstract Fo form(C... components);

    protected final CharSequence[] header(CharSequence... columns) {
        return columns;
    }

    protected final H heading(CharSequence text) {
        return heading(Heading.Level.H1, text);
    }

    protected abstract H heading(H.Level level, CharSequence text);

    protected abstract LL linearLayout(C... components);

    protected abstract M modal(C... components);

    protected abstract N navigation();

    protected final Object[] row(Object... cells) {
        return cells;
    }

    protected abstract S separator();

    protected abstract C structure();

    protected final Fi submit() {
        return field(null, Field.Type.SUBMIT, null);
    }

    protected static <C> TabLayout.Tab<C> tab(CharSequence name, C content) {
        return new TabLayout.Tab<>(name, content);
    }

    protected abstract TL tabLayout(TL.Tab... tabs);

    protected abstract Ta table(CharSequence[] header, Object[]... rows);

    protected abstract T text(CharSequence text);

}
