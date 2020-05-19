package org.fluentness;

import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.injection.Provider;
import org.fluentness.service.mail.SocketMail;
import org.fluentness.service.router.RouterImpl;
import org.fluentness.service.server.Server;
import org.fluentness.service.server.ServerImpl;

public abstract class AbstractWebApplication implements Application {

    @Override
    public void provide(Provider provider) {
        provider
            .service(RouterImpl.class)
            .service(ServerImpl.class)
            .service(SocketMail.class);
    }

    @Override
    public void configure(Configuration configuration) {

    }

    @Override
    public void run(String[] args) throws Exception {
        Fluentness.getInstance(Server.class).start();
    }

}
