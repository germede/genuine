package org.fluentness.prototype.view;

import org.fluentness.view.WebView;
import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.layout.HtmlLinearLayout;
import org.fluentness.view.component.text.HtmlButton;

import static org.fluentness.prototype.service.Localization._notes;
import static org.fluentness.service.localization.BaseLocalization._create;

public class NotesView extends WebView {

    public HtmlButton newButton;
    public HtmlLinearLayout noteList;

    public NotesView() {
        super(_notes);
    }

    @Override
    protected HtmlComponent structure() {
        return linearLayout(
            newButton = button(_create),
            noteList = linearLayout()
        );
    }
}