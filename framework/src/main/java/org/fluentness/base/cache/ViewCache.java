package org.fluentness.base.cache;

import org.fluentness.base.Service;

public enum ViewCache implements Service {
    instance;

//    private String getIdentifyingCacheFilePath(View view) {
//        return PrivateDirectories.VIEW_CACHE + "/" +
//            view.getName() + ".html";
//    }
//
//    private boolean isCacheable(View view) {
//        return !view.hasParameters();
//    }
//
//    public String cache(View view) {
//        boolean cacheable = isCacheable(view);
//        if (service(Configuration.class).get(ENABLE_CACHE) && doesCacheFileExists(view) && cacheable) {
//            return retrieve(view);
//        }
//
//        String content = view.toString();
//        if (service(Configuration.class).get(ENABLE_CACHE) && cacheable) {
//            store(view, content);
//        }
//        return content;
//    }
//
//    public boolean doesCacheFileExists(View view) {
//        return new File(getIdentifyingCacheFilePath(view)).exists();
//    }
//
//    public void store(View view, String content) {
//        try {
//            service(Logger.class).debug("Create cache record %s", getIdentifyingCacheFilePath(view));
//            new File(getIdentifyingCacheFilePath(view)).getParentFile().mkdirs();
//            Files.write(Paths.get(getIdentifyingCacheFilePath(view)), content.getBytes(), StandardOpenOption.CREATE);
//        } catch (IOException e) {
//            service(Logger.class).error(e);
//        }
//    }
//
//    public String retrieve(View t) {
//        try {
//            service(Logger.class).debug("Retrieve cache record %s", getIdentifyingCacheFilePath(t));
//            return new String(Files.readAllBytes(Paths.get(getIdentifyingCacheFilePath(t))));
//        } catch (IOException e) {
//            service(Logger.class).error(e);
//            return "";
//        }
//    }
}
