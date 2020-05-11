package com.sample.controller;

import android.widget.TextView;
import com.sample.view.MobileView;
import org.fluentness.controller.AbstractMobileController;
import org.fluentness.service.log.Log;
import org.fluentness.service.persistence.Persistence;

public class MobileController extends AbstractMobileController<MobileView> {

    public MobileController(MobileView mobileView, Log log, Persistence persistence) {
        super(mobileView);

//        persistence.persist(new User("test", "test"));
//        persistence.persist(new User("test2", "test2"));
//        persistence.persist(new User("test3", "test3"));
//
//        for (User user : persistence.retrieve(User.class)) {
//            log.error("TEST", user.getId() + " " + user.getUsername());
//        }
    }

    private static  final TextView reference = null;

    @Action(selector = "")
    public void test(TextView textView) {
        if (textView == reference) {

        }
    }
}
