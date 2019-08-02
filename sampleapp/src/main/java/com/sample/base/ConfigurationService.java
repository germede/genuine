package com.sample.base;

import org.fluentness.base.service.configuration.AbstractConfigurationService;

public class ConfigurationService extends AbstractConfigurationService {

    @Environment()
    public final String test = set(AbstractConfigurationService.LOG_TO_CONSOLE, true);

    test = "test";

}
