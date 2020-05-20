package org.fluentness;

import org.fluentness.service.mail.SocketMail;
import org.fluentness.service.router.RouterImpl;
import org.fluentness.service.server.Server;
import org.fluentness.service.server.SunServer;

@Src(services = {RouterImpl.class, SunServer.class, SocketMail.class})
public abstract class AbstractWebApplication implements Application {

    @Override
    public final void run(String[] args) throws Exception {
        Fluentness.getInstance(Server.class).start();
    }

}
