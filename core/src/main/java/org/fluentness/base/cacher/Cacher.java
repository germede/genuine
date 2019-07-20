package org.fluentness.base.cacher;

import org.fluentness.Fluentness;
import org.fluentness.base.constants.PrivateDirectories;
import org.fluentness.base.server.HttpRequestRegister;
import org.fluentness.flow.view.View;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static org.fluentness.base.config.BooleanKey.ENABLE_CACHE;

public class Cacher {

    public void initialize() {

    }

    private String getIdentifyingCacheFilePath(View view) {
        return PrivateDirectories.VIEW_CACHE + "/" +
            view.getName() + "." +
            HttpRequestRegister.instance.getCurrentLocale().toString() + ".html";
    }

    private boolean isCacheable(View view) {
        return !view.hasParameters();
    }

    public String cache(View view) {
        boolean cacheable = isCacheable(view);
        if (Fluentness.base.getConfig().get(ENABLE_CACHE) && doesCacheFileExists(view) && cacheable) {
            return retrieve(view);
        }

        String content = view.toString();
        if (Fluentness.base.getConfig().get(ENABLE_CACHE) && cacheable) {
            store(view, content);
        }
        return content;
    }

    public boolean doesCacheFileExists(View view) {
        return new File(getIdentifyingCacheFilePath(view)).exists();
    }

    public void store(View view, String content) {
        try {
            Fluentness.base.getLogger().fine("Create cache record %s", getIdentifyingCacheFilePath(view));
            new File(getIdentifyingCacheFilePath(view)).getParentFile().mkdirs();
            Files.write(Paths.get(getIdentifyingCacheFilePath(view)), content.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            Fluentness.base.getLogger().severe(e);
        }
    }

    public String retrieve(View t) {
        try {
            Fluentness.base.getLogger().fine("Retrieve cache record %s", getIdentifyingCacheFilePath(t));
            return new String(Files.readAllBytes(Paths.get(getIdentifyingCacheFilePath(t))));
        } catch (IOException e) {
            Fluentness.base.getLogger().severe(e);
            return "";
        }
    }
}
