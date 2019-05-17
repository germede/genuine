package org.fluentness.model;

public interface ColumnFunctions {

    default IntegerProperty id() {
        return (IntegerProperty) new IntegerProperty().primaryKey().autoincrement();
    }

    default StringProperty string() {
        return new StringProperty();
    }

    default IntegerProperty integer() {
        return new IntegerProperty();
    }

    default BooleanProperty bool() {
        return new BooleanProperty();
    }

    default CustomProperty custom(Class type) {
        return new CustomProperty(type);
    }

    class StringProperty extends Column {
        private StringProperty() {
        }

        public Class getType() {
            return String.class;
        }
    }

    class IntegerProperty extends Column {
        private IntegerProperty() {
        }

        public Class getType() {
            return Integer.class;
        }
    }

    class BooleanProperty extends Column {
        private BooleanProperty() {
        }

        public Class getType() {
            return Boolean.class;
        }

    }

    class CustomProperty extends Column {
        private final Class type;

        private CustomProperty(Class type) {
            this.type = type;
        }

        public Class getType() {
            return type;
        }
    }
}
