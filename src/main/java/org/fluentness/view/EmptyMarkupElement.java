package org.fluentness.view;

import org.fluentness.base.lambdas.KeyValuePair;

import java.util.Arrays;
import java.util.HashMap;

public class EmptyMarkupElement extends MarkupElement {

    public EmptyMarkupElement(String tag, KeyValuePair<String>... attributes) {
        super(false);
        this.tag = tag;
        this.attributes = new HashMap<>();
        Arrays.stream(attributes).forEach(attribute -> this.attributes.put(attribute.key(),attribute.value()));
    }

}
