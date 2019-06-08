package org.fluentness.form;

import org.fluentness.common.lambdas.NamedValue;

public interface FieldFunctions {

    default ButtonField button(NamedValue<String>... attributes) {
        return new ButtonField(attributes);
    }

    default CheckboxField checkbox(NamedValue<String>... attributes) {
        return new CheckboxField(attributes);
    }

    default ColorField color(NamedValue<String>... attributes) {
        return new ColorField(attributes);
    }

    default DateField date(NamedValue<String>... attributes) {
        return new DateField(attributes);
    }

    default DatetimeField datetime(NamedValue<String>... attributes) {
        return new DatetimeField(attributes);
    }

    default EmailField email(NamedValue<String>... attributes) {
        return new EmailField(attributes);
    }

    default FileField file(NamedValue<String>... attributes) {
        return new FileField(attributes);
    }

    default HiddenField hidden(NamedValue<String>... attributes) {
        return new HiddenField(attributes);
    }

    default ImageField image(NamedValue<String>... attributes) {
        return new ImageField(attributes);
    }

    default MonthField month(NamedValue<String>... attributes) {
        return new MonthField(attributes);
    }

    default NumberField number(NamedValue<String>... attributes) {
        return new NumberField(attributes);
    }

    default PasswordField password(NamedValue<String>... attributes) {
        return new PasswordField(attributes);
    }

    default RadioField radio(NamedValue<String>... attributes) {
        return new RadioField(attributes);
    }

    default RangeField range(NamedValue<String>... attributes) {
        return new RangeField(attributes);
    }

    default ResetField reset(NamedValue<String>... attributes) {
        return new ResetField(attributes);
    }

    default SearchField search(NamedValue<String>... attributes) {
        return new SearchField(attributes);
    }

    default SubmitField submit(NamedValue<String>... attributes) {
        return new SubmitField(attributes);
    }

    default TelField tel(NamedValue<String>... attributes) {
        return new TelField(attributes);
    }

    default TextField text(NamedValue<String>... attributes) {
        return new TextField(attributes);
    }

    default TimeField time(NamedValue<String>... attributes) {
        return new TimeField(attributes);
    }

    default UrlField url(NamedValue<String>... attributes) {
        return new UrlField(attributes);
    }

    default WeekField week(NamedValue<String>... attributes) {
        return new WeekField(attributes);
    }

    class ButtonField extends Field {
        private ButtonField(NamedValue... attributes) {
            super("button", attributes);
        }
    }

    class CheckboxField extends Field {
        private CheckboxField(NamedValue... attributes) {
            super("checkbox", attributes);
        }
    }

    class ColorField extends Field {
        private ColorField(NamedValue... attributes) {
            super("color", attributes);
        }
    }

    class DateField extends Field {
        private DateField(NamedValue... attributes) {
            super("date", attributes);
        }
    }

    class DatetimeField extends Field {
        private DatetimeField(NamedValue... attributes) {
            super("datetime-local", attributes);
        }
    }

    class EmailField extends Field {
        private EmailField(NamedValue... attributes) {
            super("email", attributes);
        }
    }

    class FileField extends Field {
        private FileField(NamedValue... attributes) {
            super("file", attributes);
        }
    }

    class HiddenField extends Field {
        private HiddenField(NamedValue... attributes) {
            super("hidden", attributes);
        }
    }

    class ImageField extends Field {
        private ImageField(NamedValue... attributes) {
            super("image", attributes);
        }
    }

    class MonthField extends Field {
        private MonthField(NamedValue... attributes) {
            super("month", attributes);
        }
    }

    class NumberField extends Field {
        private NumberField(NamedValue... attributes) {
            super("number", attributes);
        }
    }

    class PasswordField extends Field {
        private PasswordField(NamedValue... attributes) {
            super("password", attributes);
        }
    }

    class RadioField extends Field {
        private RadioField(NamedValue... attributes) {
            super("radio", attributes);
        }
    }

    class RangeField extends Field {
        private RangeField(NamedValue... attributes) {
            super("range", attributes);
        }
    }

    class ResetField extends Field {
        private ResetField(NamedValue... attributes) {
            super("reset", attributes);
        }
    }

    class SearchField extends Field {
        private SearchField(NamedValue... attributes) {
            super("search", attributes);
        }
    }

    class SubmitField extends Field {
        private SubmitField(NamedValue... attributes) {
            super("submit", attributes);
        }
    }

    class TelField extends Field {
        private TelField(NamedValue... attributes) {
            super("tel", attributes);
        }
    }

    class TextField extends Field {
        private TextField(NamedValue... attributes) {
            super("text", attributes);
        }
    }

    class TimeField extends Field {
        private TimeField(NamedValue... attributes) {
            super("time", attributes);
        }
    }

    class UrlField extends Field {
        private UrlField(NamedValue... attributes) {
            super("url", attributes);
        }
    }

    class WeekField extends Field {
        private WeekField(NamedValue... attributes) {
            super("week", attributes);
        }
    }
}
