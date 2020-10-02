package org.fluentness.view;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import org.fluentness.application.MobileApplication;
import org.fluentness.application.Application;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static android.content.pm.PackageManager.NameNotFoundException;

public class FluentnessActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            // context is global, only one activity
            MobileApplication.context = this;

            // retrieve application class name from manifest and invoke main method
            ActivityInfo activityInfo = getPackageManager().getActivityInfo(this.getComponentName(), PackageManager.GET_META_DATA);
            String applicationClassName = activityInfo.metaData.getString("applicationClassName");
            Class<? extends Application> applicationClass = (Class<? extends Application>) Class.forName(applicationClassName);
            Method main = applicationClass.getMethod("main", String[].class);
            final Object[] args = new Object[1];
            args[0] = new String[] {};
            main.invoke(null, args);

            // init first controller view
            MobileApplication application = (MobileApplication) MobileApplication.application;
            MobileView view = (MobileView) application.getControllers()[0].getView();
            View androidView = view.getAndroidView();
            setContentView(androidView);
        } catch (ClassNotFoundException | IllegalAccessException | NameNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            Log.e(this.getClass().getSimpleName(), "Exception", e);
        }
    }
}
