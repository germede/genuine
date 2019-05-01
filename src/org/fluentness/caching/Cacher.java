package org.fluentness.caching;

import org.fluentness.Configuration;
import org.fluentness.logging.Logger;
import org.fluentness.view.View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Cacher {

    private Cacher() {
    }

    public static String cacheView(View view) {

        // check if cache is enabled
        if (Configuration.getBoolean(Configuration.CACHE_ENABLE)) {
            try {
                String dirPath = "tmp/cache/";
                new File(dirPath).mkdirs();

                String path = dirPath + view.getClass().getCanonicalName();
                File file = new File(path);

                if (file.createNewFile()) {
                    // missed! -> create new cache record
                    String content = view.render().toString();
                    FileWriter writer = new FileWriter(file);
                    writer.write(content);
                    writer.close();
                    Logger.debug(Cacher.class, "Create cache record %s", path);
                    return content;
                } else {
                    // cached! -> retrieve cache record
                    Logger.debug(Cacher.class, "Retrieve cache record %s", path);
                    return new String(Files.readAllBytes(Paths.get(path)));
                }

            } catch (IOException e) {
                Logger.error(Cacher.class, e, "Error caching %s", view.getClass().getName());
            }
        }
        return view.render().toString();
    }

}
