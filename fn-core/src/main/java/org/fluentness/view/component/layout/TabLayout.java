package org.fluentness.view.component.layout;

import org.fluentness.view.component.Component;

public interface TabLayout extends Component {

    void setActive(int tabIndex);

    class Tab<C> {

        private final CharSequence name;
        private final C content;

        public Tab(CharSequence name, C content) {
            this.name = name;
            this.content = content;
        }

        public CharSequence getName() {
            return name;
        }

        public C getContent() {
            return content;
        }
    }
}
