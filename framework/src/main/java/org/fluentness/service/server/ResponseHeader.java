package org.fluentness.service.server;

public final class ResponseHeader {

    // Standard response headers
    public static final String
        ACCEPT_RANGES = "Accept-Ranges",
        AGE = "Age",
        ALLOW = "Allow",
        CACHE_CONTROL = "Cache-Control",
        CONNECTION = "Connection",
        CONTENT_ENCODING = "Content-Encoding",
        CONTENT_LANGUAGE = "Content-Language",
        CONTENT_LENGTH = "Content-Length",
        CONTENT_LOCATION = "Content-Location",
        CONTENT_MD5 = "Content-MD5",
        CONTENT_DISPOSITION = "Content-Disposition",
        CONTENT_RANGE = "Content-Range",
        CONTENT_SECURITY_POLICY = "Content-Security-Policy",
        CONTENT_TYPE = "Content-Type",
        DATE = "Date",
        ETAG = "ETag",
        EXPIRES = "Expires",
        LAST_MODIFIED = "Last-Modified",
        LINK = "Link",
        LOCATION = "Location",
        P3P = "P3P",
        PRAGMA = "Pragma",
        PROXY_AUTHENTICATE = "Proxy-Authenticate",
        REFRESH = "Refresh",
        RETRY_AFTER = "Retry-After",
        SERVER = "Server",
        SET_COOKIE = "Set-Cookie",
        TRAILER = "Trailer",
        TRANSFER_ENCODING = "Transfer-Encoding",
        VARY = "Vary",
        VIA = "Via",
        WARNING = "Warning",
        WWW_AUTHENTICATE = "WWW-Authenticate",

    // Non-standard response headers
    X_FRAME_OPTIONS = "X-Frame-Options",
        X_XSS_PROTECTION = "X-XSS-Protection",
        X_CONTENT_TYPE_OPTIONS = "X-Content-Type-Options",
        X_POWERED_BY = "X-Powered-By",
        X_UA_COMPATIBLE = "X-UA-Compatible",
        X_ROBOTS_TAG = "X-Robots-Tag";

    private ResponseHeader() {
    }
}
