package org.fluentness.service.authenticator;

import org.fluentness.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Authenticator extends Service {

    boolean authenticate(HttpServletRequest request, HttpServletResponse response);

}
