package org.fluentness.prototype.controller;

import org.fluentness.controller.AbstractDesktopController;
import org.fluentness.prototype.model.User;
import org.fluentness.prototype.repository.UserRepository;
import org.fluentness.prototype.view.DesktopView;

public class DesktopController extends AbstractDesktopController<DesktopView> {

    private final UserRepository userRepository;

    public DesktopController(DesktopView desktopView, UserRepository userRepository) {
        super(desktopView);
        this.userRepository = userRepository;
        onClick(desktopView.button1, this::onButtonClick);
    }

    private void onButtonClick() {
        User model = new User();
        model.setUsername("test");
        userRepository.insert(model);
        for (User user : userRepository.selectAll()) {
            System.out.println(user.getUsername());
        }
    }


}
