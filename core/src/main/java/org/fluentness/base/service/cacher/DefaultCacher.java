package org.fluentness.base.service.cacher;

import org.fluentness.Fluentness;
import org.fluentness.base.common.constant.PrivateDirectories;
import org.fluentness.base.service.server.HttpRequestRegister;
import org.fluentness.flow.provider.view.View;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static org.fluentness.base.service.config.BooleanKey.ENABLE_CACHE;

public class DefaultCacher implements Cacher {

    @Override
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

    @Override
    public String cache(View view) {
        boolean cacheable = isCacheable(view);
        if (base(Config.class).get(ENABLE_CACHE) && doesCacheFileExists(view) && cacheable) {
            return retrieve(view);
        }

        String content = view.toString();
        if (base(Config.class).get(ENABLE_CACHE) && cacheable) {
            store(view, content);
        }
        return content;
    }

    @Override
    public boolean doesCacheFileExists(View view) {
        return new File(getIdentifyingCacheFilePath(view)).exists();
    }

    @Override
    public void store(View view, String content) {
        try {
            base(Logger.class).fine("Create cache record %s", getIdentifyingCacheFilePath(view));
            new File(getIdentifyingCacheFilePath(view)).getParentFile().mkdirs();
            Files.write(Paths.get(getIdentifyingCacheFilePath(view)), content.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            base(Logger.class).severe(e);
        }
    }

    @Override
    public String retrieve(View t) {
        try {
            base(Logger.class).fine("Retrieve cache record %s", getIdentifyingCacheFilePath(t));
            return new String(Files.readAllBytes(Paths.get(getIdentifyingCacheFilePath(t))));
        } catch (IOException e) {
            base(Logger.class).severe(e);
            return "";
        }
    }
}
