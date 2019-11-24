package org.fluentness.service.authenticator;

import org.fluentness.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.fluentness.service.Service.ServiceType;
import static org.fluentness.service.Service.Type.MULTIPLE;

@ServiceType(MULTIPLE)
public interface Authenticator extends Service {

    boolean authenticate(HttpServletRequest request, HttpServletResponse response);

}
