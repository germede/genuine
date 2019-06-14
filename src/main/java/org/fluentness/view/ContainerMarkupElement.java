package org.fluentness.view;

import org.fluentness.base.lambdas.KeyValuePair;

import java.util.Arrays;
import java.util.HashMap;

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

    public ContainerMarkupElement attrs(KeyValuePair<String>... attributes) {
        this.attributes = new HashMap<>();
        Arrays.stream(attributes).forEach(attribute -> this.attributes.put(attribute.key(),attribute.value()));
        return this;
    }
}
