package org.fluentness.prototype.controller;

import org.fluentness.controller.AbstractDesktopController;
import org.fluentness.prototype.model.User;
import org.fluentness.prototype.repository.UserRepository;
import org.fluentness.prototype.view.DesktopView;
import org.fluentness.view.component.Button;

public class DesktopController extends AbstractDesktopController<DesktopView> {

    private final UserRepository userRepository;

    public DesktopController(DesktopView desktopView, UserRepository userRepository) {
        super(desktopView);
        this.userRepository = userRepository;
        desktopView.button1.onClick(this::onButtonClick);
    }

    private void onButtonClick(Button button) {
        for (User user : userRepository.selectAll()) {
            System.out.println(user.getUsername());
        }
        System.out.println("TEST");
    }


}
