package org.fluentness.controller;

import org.fluentness.caching.Cacher;
import org.fluentness.server.HttpResponse;
import org.fluentness.server.HttpStatusCode;
import org.fluentness.view.View;

public interface Controller {

    default HttpResponse render(View view) {
        // caching and templating
        String body = Cacher.cacheView(view.renderTakingTemplateIntoAccount());
        return new HttpResponse(HttpStatusCode.Ok).setBody(body);
    }

    default HttpResponse response(String body) {
        return new HttpResponse(HttpStatusCode.Ok).setBody(body);
    }

    default HttpResponse redirect(String to) {
        return new HttpResponse(HttpStatusCode.MovedPermanently).setHeader("Location", to);
    }

}
