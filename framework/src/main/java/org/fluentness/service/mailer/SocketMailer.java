package org.fluentness.service.mailer;

import org.fluentness.service.configurator.Configurator;
import org.fluentness.service.logger.Logger;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketMailer implements Mailer {


    private final Logger logger;

    private final InetAddress server;
    private final int port;

    public SocketMailer(Configurator configurator, Logger logger) throws UnknownHostException {
        this.logger = logger;

        this.server = InetAddress.getByName(configurator.get(Mailer.SERVER));
        this.port = configurator.get(Mailer.PORT);
    }

    @Override
    public void send(String from, String to, String message) {
        try {
            Socket smtpPipe = new Socket(server, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(smtpPipe.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(smtpPipe.getOutputStream()), true);

            logger.debug("Sending email from %s to %s with message \"%s\"", from, to, message);
            logger.debug("Server: %s", in.readLine());

            logger.debug("Client: HELO %s", server.getHostName());
            out.println("HELO " + server.getHostName());
            logger.debug("Server: %s", in.readLine());

            logger.debug("Client: MAIL From:<%s>", from);
            out.println("MAIL From:<" + from + ">");
            logger.debug("Server: %s", in.readLine());

            logger.debug("Client: RCPT TO:<%s>", to);
            out.println("RCPT TO:<" + to + ">");
            logger.debug("Server: %s", in.readLine());

            logger.debug("Client: DATA");
            out.println("DATA");
            logger.debug("Client: %s", message);
            out.println(message);
            logger.debug("Client: %s", ".");
            out.println(".");
            logger.debug("Server: %s", in.readLine());

            logger.debug("Client: QUIT");
            out.println("QUIT");

        } catch (IOException e) {
            logger.error(e);
        }
    }
}
