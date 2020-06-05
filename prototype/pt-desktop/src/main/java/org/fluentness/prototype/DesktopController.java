package org.fluentness.prototype;

import org.fluentness.controller.AbstractDesktopController;
import org.fluentness.prototype.user.User;
import org.fluentness.prototype.user.UserRepository;

public class DesktopController extends AbstractDesktopController<DesktopView> {

    private final UserRepository userRepository;

    public DesktopController(DesktopView view, UserRepository userRepository) {
        super(view);
        this.userRepository = userRepository;

        onClick(view.button1, this::onButtonClick);
    }

    private void onButtonClick() {
        view.button1.setText("text");
        User model = new User();
        model.setUsername("test");
        userRepository.insert(model);
        for (User user : userRepository.selectAll()) {
            System.out.println(user.getUsername());
        }
        view.table.addRow(2, "asdf", "asdfasdf");
    }


}
