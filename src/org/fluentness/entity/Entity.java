package org.fluentness.entity;

import org.fluentness.common.NamedValue;
import org.fluentness.common.ClassicNamedValue;
import org.fluentness.logging.Logger;
import org.fluentness.model.Model;
import org.fluentness.model.Property;
import org.fluentness.register.ClassRegister;

import java.util.*;

public class Entity<T extends Model> {

    private Model getModel() {
        return ClassRegister.getModelInstance(this.getClass().getGenericSuperclass().getClass().getCanonicalName());
    }

    private Model.Properties getModelProperties() {
        return ClassRegister.getModelPropertiesInstance(this.getClass().getGenericSuperclass().getClass().getCanonicalName());
    }

    private Map<String, Object> properties = new HashMap<>();

    public <V> V get(Class<V> propertyType, String propertyName) {
        Model.Properties modelProperties = getModelProperties();

        if (modelProperties.contains(propertyName)) {
            Property modelProperty = modelProperties.get(propertyName);
            if (modelProperty.getType().equals(propertyType)) {
                if (modelProperty.isReadable()) {
                    if (modelProperty.isNullable() || this.properties.get(propertyName) != null) {
                        return (V) this.properties.get(propertyName);
                    } else {
                        Logger.error(this.getClass(), "Property %s is null", propertyName);
                    }
                } else {
                    Logger.error(this.getClass(), "Property %s is not readable", propertyName);
                }
            } else {
                Logger.error(this.getClass(), "Property %s type mismatch (expected %s, got %s)", propertyName, propertyType.getName(), modelProperty.getType());
            }
        } else {
            Logger.error(this.getClass(), "Property %s doesn't exists for model %s", propertyName, getModel().getClass().getName());
        }
        return null;
    }

    public void set(NamedValue... properties) {
        Arrays.stream(properties).forEach(property -> set(property.name(), property.value()));
    }

    public void set(String name, Object value) {
        Model.Properties modelProperties = getModelProperties();
        if (modelProperties.contains(name)) {
            Property modelProperty = modelProperties.get(name);
            if (modelProperty.getType().equals(value.getClass())) {
                if (modelProperty.isWritable()) {
                    if (modelProperty.isNullable() || value != null) {
                        this.properties.put(name,value);
                    } else {
                        Logger.error(this.getClass(), "Property %s cannot be set to null", name);
                    }
                } else {
                    Logger.error(this.getClass(), "Property %s is not readable", name);
                }
            } else {
                Logger.error(this.getClass(), "Property %s type mismatch (expected %s, got %s)", name, modelProperty.getType(), value.getClass().getName());
            }
        } else {
            Logger.error(this.getClass(), "Property %s doesn't exists for model %s", name, getModel().getClass().getName());
        }
    }

    public NamedValue[] getAll() {
        List<NamedValue> result = new ArrayList<>(properties.size());
        properties.forEach((s, o) -> result.add(new ClassicNamedValue(s,o)));
        return result.toArray(new NamedValue[0]);
    }

}
