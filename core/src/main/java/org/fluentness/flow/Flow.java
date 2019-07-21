package org.fluentness.flow;

import org.fluentness.Fluentness;
import org.fluentness.base.constants.OnionLayers;
import org.fluentness.base.exceptions.OnionLayerComplianceException;
import org.fluentness.base.generics.Provider;
import org.fluentness.flow.controller.ControllerProvider;
import org.fluentness.flow.form.FormProvider;
import org.fluentness.flow.locale.LocaleProvider;
import org.fluentness.flow.repository.RepositoryProvider;
import org.fluentness.flow.style.StyleProvider;
import org.fluentness.flow.task.TaskProvider;
import org.fluentness.flow.view.ViewProvider;

import java.util.HashMap;
import java.util.Map;

public class Flow implements OnionLayers {

    private Map<Class<? extends Provider>, Provider> providers = new HashMap<>();

    public void initialize() throws
        IllegalAccessException,
        ClassNotFoundException,
        InstantiationException,
        OnionLayerComplianceException {

        setProvider(RepositoryProvider.class, Fluentness.appPackage + ".flow.Repositories");
        setProvider(LocaleProvider.class, Fluentness.appPackage + ".flow.Locales");
        setProvider(StyleProvider.class, Fluentness.appPackage + ".flow.Styles");
        setProvider(FormProvider.class, Fluentness.appPackage + ".flow.Forms");
        setProvider(ViewProvider.class, Fluentness.appPackage + ".flow.Views");
        setProvider(TaskProvider.class, Fluentness.appPackage + ".flow.Tasks");
        setProvider(ControllerProvider.class, Fluentness.appPackage + ".flow.Controllers");
    }

    public void reset() {
        providers.clear();
    }

    public <T extends Provider> T getProvider(Class<T> providerClass) {
        return (T) providers.get(providerClass);
    }

    public void setProvider(Class<? extends Provider> providerClass, String providerClassName) throws
        IllegalAccessException,
        InstantiationException,
        ClassNotFoundException,
        OnionLayerComplianceException {

        Provider provider = instantiateProvider(providerClass, providerClassName);
        checkOnionLayerCompliance(provider);
        providers.put(providerClass, provider);
    }

    public <T extends Provider> T instantiateProvider(Class<T> clazz, String implementation) throws
        ClassNotFoundException,
        IllegalAccessException,
        InstantiationException {

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



}
