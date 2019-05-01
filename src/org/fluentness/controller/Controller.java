package org.fluentness.controller;

import org.fluentness.server.HttpResponse;
import org.fluentness.server.HttpStatusCode;
import org.fluentness.view.View;

public interface Controller {

    default HttpResponse render(View view) {
        return new HttpResponse(HttpStatusCode.Ok).setBody(view.renderWithCache());
    }

    default HttpResponse response(String body) {
        return new HttpResponse(HttpStatusCode.Ok).setBody(body);
    }

    default HttpResponse redirect(String to) {
        return new HttpResponse(HttpStatusCode.MovedPermanently).setHeader("Location", to);
    }

}
