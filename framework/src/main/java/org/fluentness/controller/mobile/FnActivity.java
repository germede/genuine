package org.fluentness.controller.mobile;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.mobile.template.android.Android;
import org.fluentness.controller.mobile.template.android.AndroidFactory;
import org.fluentness.service.injection.Injection;

public class FnActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Fluentness.launch(((Class<? extends Application>) Class.forName("com.sample.WorkStation")).newInstance());
            AndroidFactory.context = this;
            Android template = (Android) Injection.getInstances(AbstractMobileController.class).get(0).getView().getTemplate();
            setContentView(template.getView());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | FluentnessException e) {
            Log.e(this.getClass().getSimpleName(), "Exception", e);
        }
    }
}
