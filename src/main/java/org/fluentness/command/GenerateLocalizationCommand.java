package org.fluentness.command;

import org.fluentness.common.PackageNames;
import org.fluentness.common.Utils;
import org.fluentness.configuration.Configuration;
import org.fluentness.generator.ClassGenerator;
import org.fluentness.generator.MethodGenerator;
import org.fluentness.localization.Localization;

import java.lang.reflect.Modifier;
import java.util.Locale;

public class GenerateLocalizationCommand implements Command {

    @Override
    public String getName() {
        return "generate:localization";
    }

    @Override
    public String getDescription() {
        return "Creates a new localization class within the localization package";
    }

    @Override
    public String[] getParameters() {
        return new String[]{"name"};
    }

    @Override
    public void execute(String... parameters) {
        String name = parameters[0];

        new ClassGenerator(Utils.toTitelCase(name) + Utils.toTitelCase(PackageNames.LOCALIZATION))
                .setPackage(Configuration.getString(Configuration.APP_PACKAGE) + "." + PackageNames.LOCALIZATION)
                .addModifier(Modifier.PUBLIC)
                .addInterface(Localization.class)
                .addMethod(
                        new MethodGenerator(Locale.class, "getLocale")
                                .addAnnotation(Override.class)
                                .addModifier(Modifier.PUBLIC)
                                .setImplementationLines(
                                        "return Locale.getDefault();"
                                )
                                .generate()
                )
                .addMethod(
                        new MethodGenerator(Localization.Translations.class, "getTranslations")
                                .addAnnotation(Override.class)
                                .addModifier(Modifier.PUBLIC)
                                .setImplementationLines(
                                        "return translations(\n" +
                                                "                welcome_message -> \"Welcome to the site\",\n" +
                                                "                test_message -> \"This is a test message\"\n" +
                                                "        );"
                                )
                                .generate()
                )
                .removeImport(Localization.Translations.class)
                .generate()
                .writeToFile()
        ;
    }
}
