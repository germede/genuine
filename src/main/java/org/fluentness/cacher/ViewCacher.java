package org.fluentness.cacher;

import org.fluentness.logging.Logger;
import org.fluentness.register.RequestRegister;
import org.fluentness.view.View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ViewCacher implements Cacher {

    private View view;
    private String language;

    public ViewCacher(View view) {
        this.view = view;
        this.language = RequestRegister.getCurrent().getPreferredLocale().getLanguage();
    }

    public String cache() {

        // check if cache is enabled
        if (isCacheEnabled()) {
            try {
                new File(getCacheDirectory()).mkdirs();
                String path = getCacheDirectory() + getCacheIdentifier();
                File file = new File(path);

                if (file.createNewFile()) {
                    // missed! -> create new cache record
                    String content = view.getRenderable().render();
                    FileWriter writer = new FileWriter(file);
                    writer.write(content);
                    writer.close();
                    Logger.debug(ViewCacher.class, "Create cache record %s", path);
                    return content;
                } else {
                    // cached! -> retrieve cache record
                    Logger.debug(ViewCacher.class, "Retrieve cache record %s", path);
                    return new String(Files.readAllBytes(Paths.get(path)));
                }

            } catch (IOException e) {
                Logger.error(ViewCacher.class, e);
            }
        }
        return view.getRenderable().render();
    }

    public boolean isCacheable() {
        return new File(getCacheDirectory() + getCacheIdentifier()).exists();
    }

    public String getCacheIdentifier() {
        return getCacheDirectory() + view.getClass().getCanonicalName() + language;
    }

    public String getCacheDirectory() {
        return "tmp/cache/";
    }
}
