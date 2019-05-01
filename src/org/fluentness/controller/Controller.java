package org.fluentness.controller;

import org.fluentness.FnConf;
import org.fluentness.http.HttpResponse;
import org.fluentness.http.HttpStatusCode;
import org.fluentness.view.View;

public interface Controller {

    default HttpResponse render(View view, String language) {
        return new HttpResponse(HttpStatusCode.Ok).setBody(view.renderWithCacheAndTemplateAndLocalization(language));
    }

    default HttpResponse render(View view) {
        return new HttpResponse(HttpStatusCode.Ok).setBody(view.renderWithCacheAndTemplateAndLocalization(FnConf.getString(FnConf.APP_DEFAULT_LANGUAGE)));
    }

    default HttpResponse response(String body) {
        return new HttpResponse(HttpStatusCode.Ok).setBody(body);
    }

    default HttpResponse redirect(String to) {
        return new HttpResponse(HttpStatusCode.MovedPermanently).setHeader("Location", to);
    }

}
