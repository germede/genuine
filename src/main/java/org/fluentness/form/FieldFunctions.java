package org.fluentness.form;

public interface FieldFunctions {

    default ButtonField button() {
        return new ButtonField();
    }

    default CheckboxField checkbox() {
        return new CheckboxField();
    }

    default ColorField color() {
        return new ColorField();
    }

    default DateField date() {
        return new DateField();
    }

    default DatetimeField datetime() {
        return new DatetimeField();
    }

    default EmailField email() {
        return new EmailField();
    }

    default FileField file() {
        return new FileField();
    }

    default HiddenField hidden() {
        return new HiddenField();
    }

    default ImageField image() {
        return new ImageField();
    }

    default MonthField month() {
        return new MonthField();
    }

    default NumberField number() {
        return new NumberField();
    }

    default PasswordField password() {
        return new PasswordField();
    }

    default RadioField radio() {
        return new RadioField();
    }

    default RangeField range() {
        return new RangeField();
    }

    default ResetField reset() {
        return new ResetField();
    }

    default SearchField search() {
        return new SearchField();
    }

    default SubmitField submit() {
        return new SubmitField();
    }

    default TelField tel() {
        return new TelField();
    }

    default TextField text() {
        return new TextField();
    }

    default TimeField time() {
        return new TimeField();
    }

    default UrlField url() {
        return new UrlField();
    }

    default WeekField week() {
        return new WeekField();
    }

    class ButtonField extends Field {
        private ButtonField() {
            super("button");
        }
    }

    class CheckboxField extends Field {
        private CheckboxField() {
            super("checkbox");
        }
    }

    class ColorField extends Field {
        private ColorField() {
            super("color");
        }
    }

    class DateField extends Field {
        private DateField() {
            super("date");
        }
    }

    class DatetimeField extends Field {
        private DatetimeField() {
            super("datetime-local");
        }
    }

    class EmailField extends Field {
        private EmailField() {
            super("email");
        }
    }

    class FileField extends Field {
        private FileField() {
            super("file");
        }
    }

    class HiddenField extends Field {
        private HiddenField() {
            super("hidden");
        }
    }

    class ImageField extends Field {
        private ImageField() {
            super("image");
        }
    }

    class MonthField extends Field {
        private MonthField() {
            super("month");
        }
    }

    class NumberField extends Field {
        private NumberField() {
            super("number");
        }
    }

    class PasswordField extends Field {
        private PasswordField() {
            super("password");
        }
    }

    class RadioField extends Field {
        private RadioField() {
            super("radio");
        }
    }

    class RangeField extends Field {
        private RangeField() {
            super("range");
        }
    }

    class ResetField extends Field {
        private ResetField() {
            super("reset");
        }
    }

    class SearchField extends Field {
        private SearchField() {
            super("search");
        }
    }

    class SubmitField extends Field {
        private SubmitField() {
            super("submit");
        }
    }

    class TelField extends Field {
        private TelField() {
            super("tel");
        }
    }

    class TextField extends Field {
        private TextField() {
            super("text");
        }
    }

    class TimeField extends Field {
        private TimeField() {
            super("time");
        }
    }

    class UrlField extends Field {
        private UrlField() {
            super("url");
        }
    }

    class WeekField extends Field {
        private WeekField() {
            super("week");
        }
    }
}
