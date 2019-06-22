package org.fluentness.data;

interface PropertyFunctions {

    default IntegerAttribute id() {
        return (IntegerAttribute) new IntegerAttribute().primaryKey().autoincrement();
    }

    default StringAttribute string() {
        return new StringAttribute();
    }

    default IntegerAttribute integer() {
        return new IntegerAttribute();
    }

    default BooleanAttribute bool() {
        return new BooleanAttribute();
    }

    default CustomAttribute custom(Class type) {
        return new CustomAttribute(type);
    }

    class StringAttribute extends Property {
        private StringAttribute() {
        }

        public Class getType() {
            return String.class;
        }
    }

    class IntegerAttribute extends Property {
        private IntegerAttribute() {
        }

        public Class getType() {
            return Integer.class;
        }
    }

    class BooleanAttribute extends Property {
        private BooleanAttribute() {
        }

        public Class getType() {
            return Boolean.class;
        }

    }

    class CustomAttribute extends Property {
        private final Class type;

        private CustomAttribute(Class type) {
            this.type = type;
        }

        public Class getType() {
            return type;
        }
    }
}
