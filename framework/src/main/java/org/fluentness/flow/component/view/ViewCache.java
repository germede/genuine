package org.fluentness.flow.component.view;

import org.fluentness.base.BaseConsumer;
import org.fluentness.base.common.constant.PrivateDirectories;
import org.fluentness.base.service.config.Config;
import org.fluentness.base.service.logger.Logger;
import org.fluentness.base.service.server.HttpRequestRegister;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static org.fluentness.base.service.config.BooleanKey.ENABLE_CACHE;

public enum ViewCache implements BaseConsumer {
    instance;

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
        if (service(Config.class).get(ENABLE_CACHE) && doesCacheFileExists(view) && cacheable) {
            return retrieve(view);
        }

        String content = view.toString();
        if (service(Config.class).get(ENABLE_CACHE) && cacheable) {
            store(view, content);
        }
        return content;
    }

    public boolean doesCacheFileExists(View view) {
        return new File(getIdentifyingCacheFilePath(view)).exists();
    }

    public void store(View view, String content) {
        try {
            service(Logger.class).debug("Create cache record %s", getIdentifyingCacheFilePath(view));
            new File(getIdentifyingCacheFilePath(view)).getParentFile().mkdirs();
            Files.write(Paths.get(getIdentifyingCacheFilePath(view)), content.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            service(Logger.class).fatal(e);
        }
    }

    public String retrieve(View t) {
        try {
            service(Logger.class).debug("Retrieve cache record %s", getIdentifyingCacheFilePath(t));
            return new String(Files.readAllBytes(Paths.get(getIdentifyingCacheFilePath(t))));
        } catch (IOException e) {
            service(Logger.class).fatal(e);
            return "";
        }
    }
}
