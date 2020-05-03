package org.fluentness.controller.mobile.android;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.mobile.AbstractMobileController;
import org.fluentness.service.injection.Injection;
import org.fluentness.service.log.Log;

public class AndroidActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            String applicationClassName = getPackageManager().getActivityInfo(getComponentName(), 0).nonLocalizedLabel.toString();
            Class<? extends Application> applicationClass = (Class<? extends Application>) Class.forName(applicationClassName);
            Application application = applicationClass.newInstance();
            Fluentness.launch(application);

            AndroidFactory.context = this;
            Android template = (Android) Injection.getInstances(AbstractMobileController.class).get(0).getView().getTemplate();

            // todo manage more controllers and views

            setContentView(template.getView());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | FluentnessException | PackageManager.NameNotFoundException e) {
            Log log = Injection.getInstance(Log.class);
            if (log != null) {
                log.error(e);
            } else {
                android.util.Log.e(this.getClass().getSimpleName(), "Exception", e);
            }
        }
    }
}
