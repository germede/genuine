package org.fluentness.service.authentication;

import org.fluentness.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthenticationService extends Service {

    boolean authenticate(HttpServletRequest request, HttpServletResponse response);

}
