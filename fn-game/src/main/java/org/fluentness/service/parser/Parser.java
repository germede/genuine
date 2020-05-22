package org.fluentness.service.parser;

public interface Parser<R> {

    R parse(String path);

}
