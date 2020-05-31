package org.fluentness.view.component.text;

public class HtmlHeading extends AbstractHtmlText implements Heading {

    private final Level level;

    public HtmlHeading(Heading.Level level, CharSequence text) {
        super(level.name().toLowerCase(), text);
        this.level = level;
    }

    @Override
    public Level getLevel() {
        return level;
    }
}
