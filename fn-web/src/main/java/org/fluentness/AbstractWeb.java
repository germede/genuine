package org.fluentness;

import org.fluentness.controller.AbstractWebController;
import org.fluentness.repository.AbstractCrudRepository;
import org.fluentness.service.WebService;
import org.fluentness.service.configuration.Configurator;
import org.fluentness.service.injection.Provider;
import org.fluentness.service.mail.SocketMail;
import org.fluentness.service.router.DefaultRouter;
import org.fluentness.service.server.Server;
import org.fluentness.service.server.SunServer;

public abstract class AbstractWeb extends AbstractApplication<WebService, AbstractCrudRepository, AbstractWebController> {


    public AbstractWeb(Provider<WebService> services,
                       Provider<AbstractCrudRepository> repositories,
                       Provider<AbstractWebController> controllers,
                       Configurator configurator) {
        super(
            services.add(DefaultRouter.class).add(SunServer.class).add(SocketMail.class),
            repositories,
            controllers,
            configurator
        );
    }

    @Override
    public void run(String[] args) throws Exception {
        Fluentness.getInstance(Server.class).start();
    }

    @FunctionalInterface
    public  interface ProviderLambda<A extends ApplicationComponent> {
        Provider<A> provide(Provider<A> provider);

    }
}
