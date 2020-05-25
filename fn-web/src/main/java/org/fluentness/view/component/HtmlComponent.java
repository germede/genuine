package org.fluentness.view.component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.view.component.HtmlComponent.Attribute.SEPARATOR;

public class HtmlComponent implements CharSequence, Component {

    static int HTML_ID = 0;
    protected final int id = HTML_ID++;
    protected final String tag;

    protected final Map<String, String> attributes = new HashMap<>();

    public HtmlComponent(String tag) {
        this.tag = tag;
    }

    public HtmlComponent(String tag, String[] attributes) {
        this(tag);
        Arrays.stream(attributes).forEach(this::addAttribute);
    }

    {
        addAttribute(Attribute.ID + String.valueOf(id));
    }

    public int getId() {
        return id;
    }

    public void addAttribute(String attribute) {
        String[] split = attribute.substring(SEPARATOR.length()).split(SEPARATOR);
        if (split.length == 1) {
            attributes.put(split[0], null);
        } else {
            if (attributes.containsKey(split[0])) {
                attributes.put(split[0], attributes.get(split[0]) + split[1]);
            } else {
                attributes.put(split[0], split[1]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder attributes = new StringBuilder();
        for (Map.Entry<String, String> attribute : this.attributes.entrySet()) {
            attributes.append(' ').append(attribute.getKey())
                .append(attribute.getValue() == null ? "" : "=\"" + attribute.getValue() + "\"");
        }
        return "<" + tag + attributes + ">";
    }

    @Override
    public final int length() {
        return 0;
    }

    @Override
    public final char charAt(int i) {
        return 0;
    }

    @Override
    public final CharSequence subSequence(int i, int i1) {
        return null;
    }

    public enum Attribute {
        ACCEPT,
        ACCEPT_CHARSET,
        ACCESSKEY,
        ACTION,
        ALIGN,
        ALT,
        ASYNC,
        AUTOCOMPLETE,
        AUTOFOCUS,
        AUTOPLAY,
        AUTOSAVE,
        BGCOLOR,
        BORDER,
        BUFFERED,
        CHALLENGE,
        CHARSET,
        CHECKED,
        CITE,
        CLASS,
        CODE,
        CODEBASE,
        COLOR,
        COLS,
        COLSPAN,
        CONTENT,
        CONTENTEDITABLE,
        CONTEXTMENU,
        CONTROLS,
        COORDS,
        CROSSORIGIN,
        DATA,
        DATETIME,
        DEFAULT,
        DIR,
        DIRNAME,
        DISABLED,
        DOWNLOAD,
        DRAGGABLE,
        DROPZONE,
        ENCTYPE,
        FOR,
        FORM,
        FORMACTION,
        HEADERS,
        HEIGHT,
        HIDDEN,
        HIGH,
        HREF,
        HREFLANG,
        HTTP_EQUIV,
        ICON,
        ID,
        INTEGRITY,
        ISMAP,
        ITEMPROP,
        KEYTYPE,
        KIND,
        LABEL,
        LANG,
        LANGUAGE,
        LIST,
        LOOP,
        LOW,
        MANIFEST,
        MAX,
        MAXLENGTH,
        MEDIA,
        METHOD,
        MIN,
        MULTIPLE,
        MUTED,
        NAME,
        NOVALIDATE,
        OPEN,
        OPTIMUM,
        PATTERN,
        PING,
        PLACEHOLDER,
        POSTER,
        PRELOAD,
        RADIOGROUP,
        READONLY,
        REL,
        REQUIRED,
        REVERSED,
        ROWS,
        ROWSPAN,
        SANDBOX,
        SCOPE,
        SCOPED,
        SEAMLESS,
        SELECTED,
        SHAPE,
        SIZE,
        SIZES,
        SLOT,
        SPAN,
        SPELLCHECK,
        SRC,
        SRCDOC,
        SRCLANG,
        SRCSET,
        START,
        STEP,
        STYLE,
        SUMMARY,
        TABINDEX,
        TARGET,
        TITLE,
        TYPE,
        USEMAP,
        VALUE,
        WIDTH;

        public static final String SEPARATOR = "#ATTR#";

        @Override
        public String toString() {
            return SEPARATOR + name().toLowerCase().replace('_','-') + SEPARATOR;
        }


    }
}
