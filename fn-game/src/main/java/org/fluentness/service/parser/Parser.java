package org.fluentness.service.parser;

import org.fluentness.service.Service;

@Service.MultiService
public interface Parser<R> extends Service {

    R parse(String path);

}
