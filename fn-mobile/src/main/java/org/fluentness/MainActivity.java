package org.fluentness;

import android.os.Bundle;
import android.view.View;
import org.fluentness.view.AbstractMobileView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static android.content.pm.PackageManager.NameNotFoundException;

public class MainActivity extends android.app.Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            AbstractMobileView.context = this;

            String applicationClassName = getPackageManager().getActivityInfo(getComponentName(), 0).nonLocalizedLabel.toString();
            Class<? extends Application> applicationClass = (Class<? extends Application>) Class.forName(applicationClassName);
            Method main = applicationClass.getMethod("main", String[].class);
            main.invoke(null, new String[]{});

            View androidView = ((AbstractMobile) Fluentness.application).getController().getMobileView().getAndroidView();
            setContentView(androidView);
        } catch (ClassNotFoundException | IllegalAccessException | NameNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            android.util.Log.e(this.getClass().getSimpleName(), "Exception", e);
        }
    }
}
