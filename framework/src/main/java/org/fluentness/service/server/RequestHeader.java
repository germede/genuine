package org.fluentness.service.server;

public final class RequestHeader {

    // Standard request headers
    public static final String
        ACCEPT = "Accept",
        ACCEPT_CHARSET = "Accept-Charset",
        ACCEPT_ENCODING = "Accept-Encoding",
        ACCEPT_LANGUAGE = "Accept-Language",
        AUTHORIZATION = "Authorization",
        CACHE_CONTROL = "Cache-Control",
        CONNECTION = "Connection",
        COOKIE = "Cookie",
        CONTENT_LENGTH = "Content-Length",
        CONTENT_MD5 = "Content-MD5",
        CONTENT_TYPE = "Content-Type",
        DATE = "Date",
        EXPECT = "Expect",
        FORWARDED = "Forwarded",
        FROM = "From",
        HOST = "Host",
        IF_MATCH = "If-Match",
        IF_MODIFIED_SINCE = "If-Modified-Since",
        IF_NONE_MATCH = "If-None-Match",
        IF_RANGE = "If-Range",
        IF_UNMODIFIED_SINCE = "If-Unmodified-Since",
        MAX_FORWARDS = "Max-Forwards",
        PRAGMA = "Pragma",
        PROXY_AUTHORIZATION = "Proxy-Authorization",
        RANGE = "Range",
        REFERER = "Referer",
        TE = "TE",
        TRANSFER_ENCODING = "Transfer-Encoding",
        UPGRADE = "Upgrade",
        USER_AGENT = "User-Agent",
        VIA = "Via",
        WARNING = "Warning",

    // Non-standard request headers
    X_REQUESTED_WITH = "X-Requested-With",
        X_DO_NOT_TRACK = "X-Do-Not-Track",
        X_FORWARDED_FOR = "X-Forwarded-For",
        X_FORWARDED_PROTO = "X-Forwarded-Proto";

    private RequestHeader() {

    }
}
