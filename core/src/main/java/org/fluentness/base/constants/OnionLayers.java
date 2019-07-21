package org.fluentness.base.constants;

import org.fluentness.base.exceptions.OnionLayerComplianceException;
import org.fluentness.base.generics.Component;
import org.fluentness.base.generics.Consumer;
import org.fluentness.base.generics.Provider;
import org.fluentness.flow.controller.Controller;
import org.fluentness.flow.form.Form;
import org.fluentness.flow.locale.Locale;
import org.fluentness.flow.repository.Repository;
import org.fluentness.flow.style.Style;
import org.fluentness.flow.task.Task;
import org.fluentness.flow.view.View;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.fluentness.base.constants.AnsiColors.*;
import static org.fluentness.base.constants.AnsiColors.ANSI_RESET;

public interface OnionLayers extends Comparator<Class<? extends Component>> {

    List<Class<? extends Component>> onionLayers = Arrays.asList(
        Repository.class,
        Locale.class,
        Style.class,
        Form.class,
        View.class,
        Task.class,
        Controller.class
    );

    @Override
    default int compare(Class<? extends Component> componentType1, Class<? extends Component> componentType2) {
        return Integer.compare(OnionLayers.onionLayers.indexOf(componentType1), OnionLayers.onionLayers.indexOf(componentType2));
    }

    default void checkOnionLayerCompliance(Provider provider) throws OnionLayerComplianceException {

        Class producedComponent = provider.getProvidedComponentType();
        Class[] consumerClasses = Arrays.stream(provider.getClass().getInterfaces())
            .filter(Consumer.class::isAssignableFrom)
            .toArray(Class[]::new);

        for (Class consumer : consumerClasses) {
            String componentCanonicalName = consumer.getCanonicalName().replace("Consumer", "");
            try {
                Class consumerComponent = Class.forName(componentCanonicalName);
                if (compare(producedComponent, consumerComponent) < 0) {
                    throw new OnionLayerComplianceException(
                        "%s should not consume %s components due to the onion layer priority",
                        provider.getClass().getSimpleName(),
                        consumerComponent.getSimpleName()
                    );
                }
            } catch (ClassNotFoundException e) {
                throw new OnionLayerComplianceException("Component %s not found", componentCanonicalName);
            }
        }
    }

    default void printOnionLayers() {
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
}
