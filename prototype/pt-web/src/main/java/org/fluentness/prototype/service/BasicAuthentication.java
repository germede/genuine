package org.fluentness.prototype.service;

import org.fluentness.prototype.model.User;
import org.fluentness.prototype.repository.UserRepository;
import org.fluentness.service.authentication.AbstractBasicAuthentication;

import java.util.List;

public class BasicAuthentication extends AbstractBasicAuthentication {

    private final UserRepository userRepository;

    public BasicAuthentication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected boolean authorize(String username, String password) {
        List<User> users = userRepository.selectByField("username", username);
        // todo check password
        return users.size() > 0;
    }
}
