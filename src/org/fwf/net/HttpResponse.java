package org.fwf.net;


public class HttpResponse {
    int httpStatusCode;
    String response;

    public HttpResponse(int httpStatusCode, String response) {
        this.httpStatusCode = httpStatusCode;
        this.response = response;
    }
}
