package org.fluentness.base.service.viewCache;

import org.fluentness.base.common.constant.PrivateDirectories;
import org.fluentness.base.service.config.ConfigService;
import org.fluentness.base.service.logger.LoggerService;
import org.fluentness.base.service.server.HttpRequestRegister;
import org.fluentness.flow.component.view.View;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static org.fluentness.base.service.config.BooleanKey.ENABLE_CACHE;

public class DefaultViewCacheService implements ViewCacheService {

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
        if (consumeService(ConfigService.class).get(ENABLE_CACHE) && doesCacheFileExists(view) && cacheable) {
            return retrieve(view);
        }

        String content = view.toString();
        if (consumeService(ConfigService.class).get(ENABLE_CACHE) && cacheable) {
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
            consumeService(LoggerService.class).fine("Create cache record %s", getIdentifyingCacheFilePath(view));
            new File(getIdentifyingCacheFilePath(view)).getParentFile().mkdirs();
            Files.write(Paths.get(getIdentifyingCacheFilePath(view)), content.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            consumeService(LoggerService.class).severe(e);
        }
    }

    @Override
    public String retrieve(View t) {
        try {
            consumeService(LoggerService.class).fine("Retrieve cache record %s", getIdentifyingCacheFilePath(t));
            return new String(Files.readAllBytes(Paths.get(getIdentifyingCacheFilePath(t))));
        } catch (IOException e) {
            consumeService(LoggerService.class).severe(e);
            return "";
        }
    }
}
