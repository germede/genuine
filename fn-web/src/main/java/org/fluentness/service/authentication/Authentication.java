package org.fluentness.service.authentication;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public interface Authentication {

    boolean authorize(HttpServletRequest request);

    void demandCredentials(HttpServletResponse response);
}
