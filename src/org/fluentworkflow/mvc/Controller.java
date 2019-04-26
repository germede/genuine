package org.fluentworkflow.mvc;

import org.fluentworkflow.net.HttpResponse;
import org.fluentworkflow.net.HttpStatusCode;

public interface Controller {

    default HttpResponse render(View view) {
        return new HttpResponse(HttpStatusCode.Ok).setBody(view.render());
    }

    default HttpResponse response(String body) {
        return new HttpResponse(HttpStatusCode.Ok).setBody(body);
    }

    default HttpResponse redirect(String to) {
        return new HttpResponse(HttpStatusCode.MovedPermanently).setHeader("Location", to);
    }

}
