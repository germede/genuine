package org.fluentness.entity;

import org.fluentness.common.ClassicNamedValue;
import org.fluentness.common.NamedValue;
import org.fluentness.logging.Logger;
import org.fluentness.model.Model;
import org.fluentness.model.Property;
import org.fluentness.register.ClassRegister;

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
        return ClassRegister.getModelInstance(model.getCanonicalName());
    }

    private Model.Properties getModelPropertiesInstance() {
        return ClassRegister.getModelPropertiesInstance(model.getCanonicalName());
    }

    private Map<String, Object> properties = new HashMap<>();

    public String get(String propertyName) {
        Property modelProperty = getModelPropertiesInstance().get(propertyName);
        if (modelProperty == null) {
            Logger.error(getModel(), "Property %s doesn't exists for model %s", propertyName, getModelInstance().getClass().getName());
            return null;
        }
        if (!modelProperty.isReadable()) {
            Logger.error(getModel(), "Property %s is not readable", propertyName);
            return null;
        }
        if (!modelProperty.isNullable() && this.properties.get(propertyName) == null) {
            Logger.error(getModel(), "Property %s is null", propertyName);
            return null;
        }
        return String.valueOf(this.properties.get(propertyName));
    }

    public void set(NamedValue... properties) {
        Arrays.stream(properties).forEach(property -> set(property.name(), property.value()));
    }

    public void set(String name, Object value) {
        Property modelProperty = getModelPropertiesInstance().get(name);
        if (modelProperty == null) {
            Logger.error(getModel(), "Property %s doesn't exists for model %s", name, getModelInstance().getClass().getName());
            return;
        }
        if (!modelProperty.isWritable()) {
            Logger.error(getModel(), "Property %s is not writable", name);
            return;
        }
        if (!modelProperty.isNullable() && value == null) {
            Logger.error(getModel(), "Property %s cannot be set to null", name);
            return;
        }
        if (value != null && !modelProperty.getType().equals(value.getClass())) {
            Logger.error(getModel(), "Property %s type mismatch (expected %s, got %s)", name, modelProperty.getType(), value.getClass().getName());
            return;
        }
        this.properties.put(name, value);
    }


    public NamedValue[] getAll() {
        List<NamedValue> result = new ArrayList<>(properties.size());
        properties.forEach((s, o) -> result.add(new ClassicNamedValue(s, o)));
        return result.toArray(new NamedValue[0]);
    }

    public String getPrimaryKey() {
        return String.valueOf(properties.get("id"));
    }
}
