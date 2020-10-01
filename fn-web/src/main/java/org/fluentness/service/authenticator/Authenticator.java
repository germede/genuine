package org.fluentness.service.authenticator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fluentness.service.Service;

public interface Authenticator extends Service {

    boolean authorize(HttpServletRequest request, HttpServletResponse response);

}
