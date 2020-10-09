package org.fluentness.view;

import android.view.View;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.layout.*;
import org.fluentness.view.component.nav.AndroidNavigation;
import org.fluentness.view.component.navigation.Navigation;
import org.fluentness.view.component.table.Table;
import org.fluentness.view.component.text.AndroidButton;
import org.fluentness.view.component.text.Button;

public abstract class MobileView extends BaseView {

    public static final Navigation navigation = new AndroidNavigation();
    private final View androidView;

    public MobileView(String title) {
        androidView = (View) structure();
    }

    public View getAndroidView() {
        return androidView;
    }

    @Override
    protected LinearLayout linearLayout(Component... components) {
        return new AndroidLinearLayout(components);
    }

    @Override
    protected Button button(Button.Type type, CharSequence text) {
        return new AndroidButton(text);
    }

    @Override
    protected Table table(CharSequence[] header, Object[]... rows) {
        return null;
    }

    @Override
    protected TabLayout tabLayout(TabLayout.Tab... tabs) {
        return new AndroidTabLayout(tabs);
    }

}
