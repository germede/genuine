package org.fluentness.controller;

import org.fluentness.common.NamedValue;
import org.fluentness.logging.Logger;
import org.fluentness.networking.HttpStatusCode;
import org.fluentness.networking.Response;
import org.fluentness.view.View;

import java.util.Arrays;

public interface Controller {

//    default HttpResponse render(View view, String language) {
//        return new HttpResponse(HttpStatusCode.Ok).setBody(view.renderWithCacheAndTemplateAndLocalization(language));
//    }

    default Response render(Class<? extends View> view, NamedValue<Object>... attributes) {
        try {
            // instantiate view and set its attributes
            View instance = view.newInstance();
            Arrays.stream(attributes).forEach(attribute -> instance.setAttribute(attribute.name(), attribute.value()));
            return new Response(HttpStatusCode.Ok)
                    .setBody(instance.renderWithCacheAndTemplateAndLocalization("EN"));
        } catch (InstantiationException | IllegalAccessException e) {
            Logger.error(this.getClass(), e);
            return new Response(HttpStatusCode.InternalServerError);
        }
    }

    default Response response(String body) {
        return new Response(HttpStatusCode.Ok).setBody(body);
    }

    default Response redirect(String to) {
        return new Response(HttpStatusCode.MovedPermanently).setHeader("Location", to);
    }

}
