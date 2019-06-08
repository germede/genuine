package org.fluentness.view;

import org.fluentness.common.lambdas.NamedValue;

import java.util.ArrayList;
import java.util.Arrays;

public class EmptyMarkupElement extends MarkupElement {

    public EmptyMarkupElement(String tag, NamedValue<String>... attributes) {
        super(false);
        this.tag = tag;
        this.attributes = new ArrayList<>(Arrays.asList(attributes));
    }

}
