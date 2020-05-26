package org.fluentness.service.parser;

import org.fluentness.service.MultiService;
import org.fluentness.service.Service;

@MultiService
public interface Parser<R> extends Service {

    R parse(String path);

}
