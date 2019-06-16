package org.fluentness.form;

import org.fluentness.common.lambdas.KeyValuePair;

interface FieldFunctions {

    default ButtonField button(KeyValuePair<String>... attributes) {
        return new ButtonField(attributes);
    }

    default CheckboxField checkbox(KeyValuePair<String>... attributes) {
        return new CheckboxField(attributes);
    }

    default ColorField color(KeyValuePair<String>... attributes) {
        return new ColorField(attributes);
    }

    default DateField date(KeyValuePair<String>... attributes) {
        return new DateField(attributes);
    }

    default DatetimeField datetime(KeyValuePair<String>... attributes) {
        return new DatetimeField(attributes);
    }

    default EmailField email(KeyValuePair<String>... attributes) {
        return new EmailField(attributes);
    }

    default FileField file(KeyValuePair<String>... attributes) {
        return new FileField(attributes);
    }

    default HiddenField hidden(KeyValuePair<String>... attributes) {
        return new HiddenField(attributes);
    }

    default ImageField image(KeyValuePair<String>... attributes) {
        return new ImageField(attributes);
    }

    default MonthField month(KeyValuePair<String>... attributes) {
        return new MonthField(attributes);
    }

    default NumberField number(KeyValuePair<String>... attributes) {
        return new NumberField(attributes);
    }

    default PasswordField password(KeyValuePair<String>... attributes) {
        return new PasswordField(attributes);
    }

    default RadioField radio(KeyValuePair<String>... attributes) {
        return new RadioField(attributes);
    }

    default RangeField range(KeyValuePair<String>... attributes) {
        return new RangeField(attributes);
    }

    default ResetField reset(KeyValuePair<String>... attributes) {
        return new ResetField(attributes);
    }

    default SearchField search(KeyValuePair<String>... attributes) {
        return new SearchField(attributes);
    }

    default SubmitField submit(KeyValuePair<String>... attributes) {
        return new SubmitField(attributes);
    }

    default TelField tel(KeyValuePair<String>... attributes) {
        return new TelField(attributes);
    }

    default TextField text(KeyValuePair<String>... attributes) {
        return new TextField(attributes);
    }

    default TimeField time(KeyValuePair<String>... attributes) {
        return new TimeField(attributes);
    }

    default UrlField url(KeyValuePair<String>... attributes) {
        return new UrlField(attributes);
    }

    default WeekField week(KeyValuePair<String>... attributes) {
        return new WeekField(attributes);
    }

    class ButtonField extends Field {
        private ButtonField(KeyValuePair... attributes) {
            super("button", attributes);
        }
    }

    class CheckboxField extends Field {
        private CheckboxField(KeyValuePair... attributes) {
            super("checkbox", attributes);
        }
    }

    class ColorField extends Field {
        private ColorField(KeyValuePair... attributes) {
            super("color", attributes);
        }
    }

    class DateField extends Field {
        private DateField(KeyValuePair... attributes) {
            super("date", attributes);
        }
    }

    class DatetimeField extends Field {
        private DatetimeField(KeyValuePair... attributes) {
            super("datetime-local", attributes);
        }
    }

    class EmailField extends Field {
        private EmailField(KeyValuePair... attributes) {
            super("email", attributes);
        }
    }

    class FileField extends Field {
        private FileField(KeyValuePair... attributes) {
            super("file", attributes);
        }
    }

    class HiddenField extends Field {
        private HiddenField(KeyValuePair... attributes) {
            super("hidden", attributes);
        }
    }

    class ImageField extends Field {
        private ImageField(KeyValuePair... attributes) {
            super("image", attributes);
        }
    }

    class MonthField extends Field {
        private MonthField(KeyValuePair... attributes) {
            super("month", attributes);
        }
    }

    class NumberField extends Field {
        private NumberField(KeyValuePair... attributes) {
            super("number", attributes);
        }
    }

    class PasswordField extends Field {
        private PasswordField(KeyValuePair... attributes) {
            super("password", attributes);
        }
    }

    class RadioField extends Field {
        private RadioField(KeyValuePair... attributes) {
            super("radio", attributes);
        }
    }

    class RangeField extends Field {
        private RangeField(KeyValuePair... attributes) {
            super("range", attributes);
        }
    }

    class ResetField extends Field {
        private ResetField(KeyValuePair... attributes) {
            super("reset", attributes);
        }
    }

    class SearchField extends Field {
        private SearchField(KeyValuePair... attributes) {
            super("search", attributes);
        }
    }

    class SubmitField extends Field {
        private SubmitField(KeyValuePair... attributes) {
            super("submit", attributes);
        }
    }

    class TelField extends Field {
        private TelField(KeyValuePair... attributes) {
            super("tel", attributes);
        }
    }

    class TextField extends Field {
        private TextField(KeyValuePair... attributes) {
            super("text", attributes);
        }
    }

    class TimeField extends Field {
        private TimeField(KeyValuePair... attributes) {
            super("time", attributes);
        }
    }

    class UrlField extends Field {
        private UrlField(KeyValuePair... attributes) {
            super("url", attributes);
        }
    }

    class WeekField extends Field {
        private WeekField(KeyValuePair... attributes) {
            super("week", attributes);
        }
    }
}
