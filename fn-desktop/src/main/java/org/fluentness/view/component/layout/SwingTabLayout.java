package org.fluentness.view.component.layout;

import javax.swing.*;
import java.awt.*;

public class SwingTabLayout extends JTabbedPane implements TabLayout {

    public SwingTabLayout(Tab[] tabs) {
        super();
        for (Tab tab : tabs) {
            addTab(tab.getName().toString(), null, (Container)tab.getContent(), "Does nothing");
        }
    }

    @Override
    public void setActive(Tab tab) {

    }
}
