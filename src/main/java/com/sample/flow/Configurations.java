package com.sample.flow;

import org.fluentness.flow.configuration.Configuration;
import org.fluentness.flow.configuration.ConfigurationProvider;

public class Configurations extends ConfigurationProvider {

    Configuration dev = settings(
        set(HIBERNATE_DATABASE, "party"),
        set(HIBERNATE_USERNAME, "party"),
        set(HIBERNATE_PASSWORD, "party"),
        set(HIBERNATE_PARAMS, "?serverTimezone=UTC"),
        set(HIBERNATE_OPTIONS, "show_sql:true")
    );

}
