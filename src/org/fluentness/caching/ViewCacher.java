package org.fluentness.caching;

import org.fluentness.logging.Log;
import org.fluentness.view.View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ViewCacher implements Cacher {

    private View view;
    private String language;

    public ViewCacher(View view, String language) {
        this.view = view;
        this.language = language;
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
                    String content = view.render().toString();
                    FileWriter writer = new FileWriter(file);
                    writer.write(content);
                    writer.close();
                    Log.info(ViewCacher.class, "Create cache record %s", path);
                    return content;
                } else {
                    // cached! -> retrieve cache record
                    Log.info(ViewCacher.class, "Retrieve cache record %s", path);
                    return new String(Files.readAllBytes(Paths.get(path)));
                }

            } catch (IOException e) {
                Log.severe(ViewCacher.class, e, "Error caching %s", view.getClass().getName());
            }
        }
        return view.render().toString();
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
