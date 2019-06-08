package org.fluentness.view;

import org.fluentness.FnConf;
import org.fluentness.common.constants.Settings;
import org.fluentness.common.logging.Logger;
import org.fluentness.common.networking.RequestRegister;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class ViewCache implements Settings {

    public static String cache(View view) {
        String language = RequestRegister.getCurrent().getPreferredLocale().getLanguage();

        // check if cache is enabled
        if (isCacheEnabled() && isCacheable(view, language)) {
            try {
                new File(getCacheDirectory()).mkdirs();
                String path = getCacheDirectory() + getCacheIdentifier(view, language);
                File file = new File(path);

                if (file.createNewFile()) {
                    // missed! -> create new cache record
                    String content = view.render();
                    FileWriter writer = new FileWriter(file);
                    writer.write(content);
                    writer.close();
                    Logger.debug("Create cache record %s", path);
                    return content;
                } else {
                    // cached! -> retrieve cache record
                    Logger.debug("Retrieve cache record %s", path);
                    return new String(Files.readAllBytes(Paths.get(path)));
                }

            } catch (IOException e) {
                Logger.error(e);
            }
        }
        return view.render();
    }

    private static boolean isCacheable(View view, String language) {
        return new File(getCacheDirectory() + getCacheIdentifier(view, language)).exists();
    }

    private static String getCacheIdentifier(View view, String language) {
        return getCacheDirectory() + view.getClass().getCanonicalName() + language;
    }

    private static String getCacheDirectory() {
        return "tmp/cache/";
    }

    private static boolean isCacheEnabled() {
        return FnConf.getBoolean(CACHE_ENABLE);
    }
}
