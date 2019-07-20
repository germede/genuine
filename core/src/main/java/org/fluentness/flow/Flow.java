package org.fluentness.flow;

import org.fluentness.Fluentness;
import org.fluentness.base.exceptions.FluentnessInitializationException;
import org.fluentness.base.generics.Component;
import org.fluentness.base.generics.Consumer;
import org.fluentness.base.generics.Provider;
import org.fluentness.flow.controller.Controller;
import org.fluentness.flow.controller.ControllerProvider;
import org.fluentness.flow.form.Form;
import org.fluentness.flow.form.FormProvider;
import org.fluentness.flow.locale.Locale;
import org.fluentness.flow.locale.LocaleProvider;
import org.fluentness.flow.repository.Repository;
import org.fluentness.flow.repository.RepositoryProvider;
import org.fluentness.flow.style.Style;
import org.fluentness.flow.style.StyleProvider;
import org.fluentness.flow.task.Task;
import org.fluentness.flow.task.TaskProvider;
import org.fluentness.flow.view.View;
import org.fluentness.flow.view.ViewProvider;

import java.util.*;

import static org.fluentness.base.constants.AnsiColors.*;

public class Flow {

    private List<Class<? extends Component>> onionLayers = new ArrayList<>();
    private Map<Class<? extends Provider>, Provider> providers = new HashMap<>();

    public void initialize() throws FluentnessInitializationException {
        onionLayers.add(Repository.class);
        onionLayers.add(Locale.class);
        onionLayers.add(Style.class);
        onionLayers.add(Form.class);
        onionLayers.add(View.class);
        onionLayers.add(Task.class);
        onionLayers.add(Controller.class);

        String appPackage = Fluentness.appPackage;

        try {
            setProvider(RepositoryProvider.class, appPackage + ".flow.Repositories");
            setProvider(LocaleProvider.class, appPackage + ".flow.Locales");
            setProvider(StyleProvider.class, appPackage + ".flow.Styles");
            setProvider(FormProvider.class, appPackage + ".flow.Forms");
            setProvider(ViewProvider.class, appPackage + ".flow.Views");
            setProvider(TaskProvider.class, appPackage + ".flow.Tasks");
            setProvider(ControllerProvider.class, appPackage + ".flow.Controllers");
        } catch (InstantiationException | NullPointerException | IllegalAccessException | ClassNotFoundException e) {
            throw new FluentnessInitializationException("Exception while initializing onion layers", e);
        }
    }

    public <T extends Provider> T getProvider(Class<T> providerClass) {
        return (T) providers.get(providerClass);
    }

    public void setProvider(Class<? extends Provider> providerClass, String providerClassName) throws
        IllegalAccessException,
        InstantiationException,
        ClassNotFoundException,
        FluentnessInitializationException {

        Provider provider = instantiate(providerClass, providerClassName);
        checkOnionLayerCompliance(provider);
        providers.put(providerClass, provider);
    }

    public <T> T instantiate(Class<T> clazz, String implementation)
        throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object object = Class.forName(implementation).newInstance();
        if (clazz.isAssignableFrom(object.getClass())) {
            return (T) object;
        } else {
            throw new ClassCastException(
                String.format(
                    "Given class %s must be the same type as %s's type",
                    clazz.getSimpleName(),
                    object.getClass().getSimpleName()
                )
            );
        }
    }

    public void checkOnionLayerCompliance(Provider provider) throws FluentnessInitializationException {

        Class producedComponent = provider.getProducedComponentType();
        try {
            Class[] consumerClasses = Arrays.stream(provider.getClass().getInterfaces())
                .filter(Consumer.class::isAssignableFrom)
                .toArray(Class[]::new);

            for (Class consumer : consumerClasses) {
                Class consumerComponent = Class.forName(consumer.getCanonicalName().replace("Consumer", ""));

                if (new ComponentComparator().compare(producedComponent, consumerComponent) < 0) {
                    throw new FluentnessInitializationException(
                        "%s should not consume %s components due to the onion layer priority",
                        provider.getClass().getSimpleName(),
                        consumerComponent.getSimpleName()
                    );
                }
            }

        } catch (ClassNotFoundException e) {
            throw new FluentnessInitializationException(e);
        }
    }

    public void printOnionLayers() {
        for (int i = 0; i < onionLayers.size(); i++) {
            String component = onionLayers.get(i).getSimpleName();
            if (i == 0) {
                System.out.println("\n" + ANSI_GREEN + "               ↑ ");
                System.out.println("LESS DEPENDANT | " + component + ANSI_RESET);
                continue;
            }
            if (i == onionLayers.size() - 1) {
                System.out.println(ANSI_BLUE + "MORE DEPENDANT | " + component);
                System.out.println("               ↓ " + ANSI_RESET);
                continue;
            }
            System.out.println("               | " + component);
        }
        System.out.println();
    }

    public class ComponentComparator implements Comparator<Class<? extends Component>> {

        @Override
        public int compare(Class<? extends Component> componentType1, Class<? extends Component> componentType2) {
            return Integer.compare(onionLayers.indexOf(componentType1), onionLayers.indexOf(componentType2));
        }
    }
}
