package org.fluentness.service.mail;

import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.log.Log;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketMail implements Mail {


    private final Log log;

    private final InetAddress server;
    private final int port;

    public SocketMail(Configuration configuration, Log log) throws UnknownHostException {
        this.log = log;

        this.server = InetAddress.getByName(configuration.get(Mail.SERVER));
        this.port = configuration.get(Mail.PORT);
    }

    @Override
    public void send(String from, String to, String message) {
        try {
            Socket smtpPipe = new Socket(server, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(smtpPipe.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(smtpPipe.getOutputStream()), true);

            log.debug("Sending email from %s to %s with message \"%s\"", from, to, message);
            log.debug("Server: %s", in.readLine());

            log.debug("Client: HELO %s", server.getHostName());
            out.println("HELO " + server.getHostName());
            log.debug("Server: %s", in.readLine());

            log.debug("Client: MAIL From:<%s>", from);
            out.println("MAIL From:<" + from + ">");
            log.debug("Server: %s", in.readLine());

            log.debug("Client: RCPT TO:<%s>", to);
            out.println("RCPT TO:<" + to + ">");
            log.debug("Server: %s", in.readLine());

            log.debug("Client: DATA");
            out.println("DATA");
            log.debug("Client: %s", message);
            out.println(message);
            log.debug("Client: %s", ".");
            out.println(".");
            log.debug("Server: %s", in.readLine());

            log.debug("Client: QUIT");
            out.println("QUIT");

        } catch (IOException e) {
            log.error(e);
        }
    }
}
