package org.fluentness.controller.mobile;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.mobile.template.android.Android;

public class FnActivity extends Activity {

    public static Application application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Class.forName("com.sample.WorkStation");
            Fluentness.launch(application);
            Android template = (Android) Fluentness.getInstances(AbstractMobileController.class).get(0).getView().getTemplate();
            setContentView(template.getView());
        } catch (FluentnessException e) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                Log.e(Fluentness.class.getSimpleName(), stackTraceElement.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
