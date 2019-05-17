package org.fluentness.entity;

import org.fluentness.common.NamedValueImpl;
import org.fluentness.common.NamedValue;
import org.fluentness.logging.Logger;
import org.fluentness.model.Model;
import org.fluentness.model.Property;
import org.fluentness.register.ModelRegister;

import java.util.*;

public class Entity<T extends Model> {

    private final Class<T> model;

    public Entity(Class<T> model) {
        this.model = model;
    }

    public Class<T> getModel() {
        return model;
    }

    private Model getModelInstance() {
        return ModelRegister.getModelInstance(model.getCanonicalName());
    }

    private Model.Properties getModelPropertiesInstance() {
        return ModelRegister.getModelPropertiesInstance(model.getCanonicalName());
    }

    private Map<String, Object> properties = new HashMap<>();

    public String getString(String propertyName) {
        return String.valueOf(get(propertyName));
    }

    public boolean getBoolean(String propertyName) {
        return (boolean)get(propertyName);
    }

    public int getInteger(String propertyName) {
        return Integer.parseInt(getString(propertyName));
    }

    public Object get(String propertyName) {
        Property modelProperty = getModelPropertiesInstance().get(propertyName);
        if (modelProperty == null) {
            Logger.error(getModel(), "Property '%s' doesn't exists for model %s", propertyName, getModelInstance().getClass().getName());
            return null;
        }
        Object propertyValue = this.properties.get(propertyName);
        if (!modelProperty.isNullable() && propertyValue == null) {
            Logger.warning(getModel(), "Property '%s' is not nullable, got null", propertyName);
        }
        return propertyValue;
    }

    public void set(NamedValue... properties) {
        Arrays.stream(properties).forEach(property -> set(property.name(), property.value()));
    }

    public void set(String name, Object value) {
        Property modelProperty = getModelPropertiesInstance().get(name);
        if (modelProperty == null) {
            Logger.error(getModel(), "Property '%s' doesn't exists for model %s", name, getModelInstance().getClass().getName());
            return;
        }
        if (!modelProperty.isNullable() && value == null) {
            Logger.error(getModel(), "Property '%s' cannot be set to null", name);
            return;
        }
        if (value != null && !modelProperty.getType().equals(value.getClass())) {
            Logger.error(getModel(), "Property '%s' type mismatch (expected %s, got %s)", name, modelProperty.getType(), value.getClass().getName());
            return;
        }
        this.properties.put(name, value);
    }


    public NamedValue[] getAll() {
        List<NamedValue> result = new ArrayList<>(properties.size());
        properties.forEach((s, o) -> result.add(new NamedValueImpl(s, o)));
        return result.toArray(new NamedValue[0]);
    }

    public String getId() {
        return String.valueOf(properties.get("id"));
    }
}
