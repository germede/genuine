package com.sample.view;

import org.fluentness.view.AbstractDesktopView;
import org.fluentness.view.component.Button;
import org.fluentness.view.container.LinearLayout;
import org.fluentness.view.template.Template;

public class DesktopView extends AbstractDesktopView {

    public Button button1;
    private LinearLayout root;

    @Override
    protected Template template() {
        return template("My new template",
            root = linearLayout(
                button1 = button("one"),
                button("two"),
                button("three")
            )
        );
    }

    @Override
    protected void style() {
        root.addBorder(50, 50, 50, 50);
    }

//
//
//    public JPanel panel1;
//    public JPanel panel2;
//    public JButton button;
//
//    @Override
//    public DesktopTemplate getTemplate() {
//        return frame("My frame",
//            panel1 = panel(
//                panel2 = panel(
//                    button = button("Test button"),
//                    colorChooser(),
//                    table(
//                        header("Spalte1", "Spalte2", "Spalte3", "Spalte4"),
//                        row(1, "John", 40.0, false),
//                        row(2, "Rambo", 70.0, false),
//                        row(2, "Rambo", 70.0, false),
//                        row(2, "Rambo", 70.0, false),
//                        row(2, "Rambo", 70.0, false),
//                        row(2, "Rambo", 70.0, false),
//                        row(2, "Rambo", 70.0, false),
//                        row(3, "Zorro", 60.0, true)
//                    )
//                )//.flowLayout()
//            )//.borderLayout(BorderLayout.NORTH, BorderLayout.SOUTH)
//        );
//    }
//
//    private JMenuBar menuBar() {
//        return menuBar(
//            menu("File",
//                menuItem("Load"),//.accelerator(KeyStroke.getKeyStroke('C')),
//                menuItem("Save"),
//                menuItem("Close")
//            ),
//            menu("Edit",
//                menuItem("Cut"),//.actionListener(controller::cutPressed),
//                menuItem("Copy"),
//                menuItem("Paste")
//            ),
//            menu("RadioButtons"
////                buttonGroup(
////                    radioButtonMenuItem("Radio 1"),
////                    radioButtonMenuItem("Radio 2")
////                )
//            ),
//            menu("CheckBoxes",
//                checkBoxMenuItem("CheckBox 1"),
//                checkBoxMenuItem("CheckBox 2")
//            ),
//            menu("Help",
//                menuItem("Manual"),
//                menuItem("About")
//            )
//        );
//    }
}
