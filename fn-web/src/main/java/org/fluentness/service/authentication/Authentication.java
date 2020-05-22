package org.fluentness.service.authentication;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fluentness.service.Service;

public interface Authentication extends Service {

    boolean authorize(HttpServletRequest request);

    void demandCredentials(HttpServletResponse response);
}
