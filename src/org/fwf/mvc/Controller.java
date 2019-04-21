package org.fwf.mvc;

import com.sun.net.httpserver.HttpExchange;
import org.fwf.log.Logger;

import java.io.IOException;
import java.io.OutputStream;

public abstract class Controller {

    protected HttpExchange httpExchange;

    public void setHttpExchange(HttpExchange httpExchange) {
        this.httpExchange = httpExchange;
    }

    protected void render(View view, int responseCode) {
        String response = view.render();
        try {
            httpExchange.sendResponseHeaders(responseCode, response.getBytes().length);
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } catch (IOException e) {
            Logger.e(e);
        }
    }

    protected void redirect(String path) {
        try {
            httpExchange.getResponseHeaders().add("Location", path);
            httpExchange.sendResponseHeaders(301, 0);
        } catch (IOException e) {
            Logger.e(e);
        }
    }
}
