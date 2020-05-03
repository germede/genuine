package com.sample.controller;

import org.fluentness.controller.AbstractMobileController;
import org.fluentness.service.log.Log;
import org.fluentness.service.persistence.Persistence;

public class MobileController extends AbstractMobileController {

    public MobileController(Persistence persistence, Log log) {
        super(Mobile.class);

//        persistence.persist(new User("test", "test"));
//        persistence.persist(new User("test2", "test2"));
//        persistence.persist(new User("test3", "test3"));
//
//        for (User user : persistence.retrieve(User.class)) {
//            log.error("TEST", user.getId() + " " + user.getUsername());
//        }
    }

}
