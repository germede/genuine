package com.sample;

import org.fluentness.Fluentness;

class Boot {

    static Fluentness<Configurations, Controllers, Forms, Localizations, Models, Styles, Tasks, Views> F;

    public static void main(String[] args) {
        F = new Fluentness()
            .setConfigurations(new Configurations())
            .

        F = new Fluentness<>(
            Configurations.class,
            Controllers.class,
            Forms.class,
            Localizations.class,
            Models.class,
            Styles.class,
            Tasks.class,
            Views.class
        );
        F.init();
        F.configurations.dev.apply();
        F.executeCommand(args);
    }
}
