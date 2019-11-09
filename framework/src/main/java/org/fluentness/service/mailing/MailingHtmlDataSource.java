package org.fluentness.service.mailing;

import javax.activation.DataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class MailingHtmlDataSource implements DataSource {

    private String html;

    MailingHtmlDataSource(String htmlString) {
        html = htmlString;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        if (html == null) {
            throw new IOException("HTML message is null!");
        }
        return new ByteArrayInputStream(html.getBytes());
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        throw new IOException("This DataHandler cannot write HTML");
    }

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public String getName() {
        return "MailingHtmlDataSource";
    }
}
