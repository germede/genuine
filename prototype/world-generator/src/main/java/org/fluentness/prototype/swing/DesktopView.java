package org.fluentness.prototype.swing;

import org.fluentness.view.AbstractDesktopView;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.navigation.Navigation;
import org.fluentness.view.component.table.Table;
import org.fluentness.view.component.text.Heading;
import org.fluentness.view.component.text.Text;
import org.fluentness.view.component.text.form.Button;

import java.util.Date;

public class DesktopView extends AbstractDesktopView {


    private LinearLayout root;
    public Button button1;
    public Table table;

    public DesktopView() {
        super("My Desktop View");
        root.setPadding(50, 50, 50, 50);
    }

    @Override
    protected Component structure() {
        return root = linearLayout(
//            button1 = button(_accept),
//            button(_cancel),
//            button(_welcome_message),
            table = table(
                header("this", "is", "a", "header"),
                row("this", "is", "a", "row"),
                row(123, false, new Date(0))
            ),
            tabLayout(
                tab("First tab", button("button in tab 1")),
                tab("Second tab", button("button in tab 2")),
                tab("Third tab", button("button in tab 3"))
            )
        );
    }

    @Override
    protected Navigation navigation() {
        return null;
    }

    @Override
    protected Button button(Button.Type type, CharSequence text) {
        return null;
    }

    @Override
    protected Heading heading(Heading.Level level, CharSequence text) {
        return null;
    }

    @Override
    protected Text text(CharSequence text) {
        return null;
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
