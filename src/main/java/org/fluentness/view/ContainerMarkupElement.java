package org.fluentness.view;

import org.fluentness.common.lambdas.NamedValue;

import java.util.ArrayList;
import java.util.Arrays;

public class ContainerMarkupElement extends MarkupElement {

    public ContainerMarkupElement(String tag, MarkupElement... innerMarkupElements) {
        super(true);
        this.tag = tag;
        this.innerMarkupElements = innerMarkupElements;
    }

    public ContainerMarkupElement(String tag, String innerText) {
        super(true);
        this.tag = tag;
        this.innerText = innerText;
    }

    public ContainerMarkupElement with(NamedValue<String>... attributes) {
        this.attributes = new ArrayList<>(Arrays.asList(attributes));
        return this;
    }
}
