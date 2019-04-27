package org.fluentness.view;

import org.fluentness.Configuration;
import org.fluentness.logging.Logger;
import org.fluentness.templating.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;

public interface View {

    Template getTemplate();

    default String renderTemplate() {

        // check if cache is enabled and if view is cacheable
        if (Configuration.getBoolean(Configuration.CACHE_ENABLE) &&
                this.getClass().isAnnotationPresent(Cacheable.class)) {
            try {
                String dirPath = "tmp/cache/";
                new File(dirPath).mkdirs();

                String path = dirPath + getClass().getCanonicalName();
                File file = new File(path);

                if (file.createNewFile()) {
                    // missed! -> create new cache record
                    String content = getTemplate().render();
                    FileWriter writer = new FileWriter(file);
                    writer.write(content);
                    writer.close();
                    Logger.debug(getClass(), "Create cache record %s", path);
                    return content;
                } else {
                    // cached! -> retrieve cache record
                    Logger.debug(getClass(), "Retrieve cache record %s", path);
                    return new String(Files.readAllBytes(Paths.get(path)));
                }

            } catch (IOException e) {
                Logger.error(getClass(), e, "Error caching view %s", getClass().getName());
            }
        }
        return getTemplate().render();
    }

    default View set(String attribute, Object value) {
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getName().equals(attribute) && field.isAnnotationPresent(Attribute.class)) {
                    field.set(this, value);
                }
            }
        } catch (IllegalAccessException e) {
            Logger.error(this.getClass(), e);
        }
        return this;
    }
}
