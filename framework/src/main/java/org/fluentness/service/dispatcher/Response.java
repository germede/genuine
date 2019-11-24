package org.fluentness.service.dispatcher;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@FunctionalInterface
public interface Response {

    void response(HttpServletResponse response) throws IOException;

}
