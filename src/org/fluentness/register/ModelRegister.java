package org.fluentness.register;

import org.fluentness.logging.Logger;
import org.fluentness.model.Model;

import java.util.HashMap;
import java.util.Map;

public final class ModelRegister {
    public static final String MODEL = "model";

    private static final Map<String, Model> modelInstances;
    private static final Map<String, Model.Properties> modelPropertiesInstances;
    static {
        modelInstances = new HashMap<>();
        modelPropertiesInstances = new HashMap<>();
        for (Class modelClass : ClassLoader.getExternalClasses(MODEL, Model.class)) {
            try {
                Model model = (Model) modelClass.newInstance();
                modelInstances.put(model.getClass().getCanonicalName(),model);
                modelPropertiesInstances.put(model.getClass().getCanonicalName(),model.getProperties());
            } catch (InstantiationException | IllegalAccessException e) {
                Logger.error(ClassLoader.class, e);
            }
        }
    }
    public static Model getModelInstance(String className) {
        return modelInstances.get(className);
    }
    public static Model.Properties getModelPropertiesInstance(String className) {
        return modelPropertiesInstances.get(className);
    }

}
