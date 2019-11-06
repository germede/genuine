package com.sample.service;

import org.fluentness.service.Service;

public class ConfService extends AbstractConfigurationService {

    public static final Setting
        WELCOME_MESSAGE = "",
        test_message1 = translation("this is a test message").en("test").de(""),
        test_message2 = "this is another message";

}
