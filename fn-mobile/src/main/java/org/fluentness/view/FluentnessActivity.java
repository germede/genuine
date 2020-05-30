package org.fluentness.view;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import org.fluentness.AbstractMobile;
import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.controller.AbstractMobileController;
import org.fluentness.view.component.nav.AndroidNavigation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static android.content.pm.PackageManager.NameNotFoundException;

public class FluentnessActivity extends Activity {


    public static FluentnessActivity context;
    public static AndroidNavigation navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            // context is global, only one activity
            context = this;
            navigation = new AndroidNavigation();

            // retrieve application class name from manifest and invoke main method
            ActivityInfo activityInfo = getPackageManager().getActivityInfo(this.getComponentName(), PackageManager.GET_META_DATA);
            String applicationClassName = activityInfo.metaData.getString("applicationClassName");
            Class<? extends Application> applicationClass = (Class<? extends Application>) Class.forName(applicationClassName);
            Method main = applicationClass.getMethod("main", String[].class);
            final Object[] args = new Object[1];
            args[0] = new String[] {};
            main.invoke(null, args);

            // prepare navigation
            AbstractMobile application = (AbstractMobile) Fluentness.application;
            AbstractMobileController[] controllers = application.getControllers();
            for (AbstractMobileController controller : controllers) {
                navigation.addSectionFor(controller);
            }

            // init first controller view
            AbstractMobileView view = (AbstractMobileView) application.getControllers()[0].getView();
            View androidView = view.getAndroidView();
            setContentView(androidView);
        } catch (ClassNotFoundException | IllegalAccessException | NameNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            Log.e(this.getClass().getSimpleName(), "Exception", e);
        }
    }
}
