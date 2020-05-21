package org.fluentness.view.android;

import android.content.pm.PackageManager;
import android.os.Bundle;
import org.fluentness.Application;
import org.fluentness.controller.AbstractMobileController;
import org.fluentness.view.AbstractMobileView;

import java.util.List;

public class MainActivity extends android.app.Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            String applicationClassName = getPackageManager().getActivityInfo(getComponentName(), 0).nonLocalizedLabel.toString();
            Class<? extends Application> applicationClass = (Class<? extends Application>) Class.forName(applicationClassName);
            Application application = applicationClass.newInstance();
            AbstractMobileView.context = this;
//            Fluentness.launch(application);

            // todo manage more controllers and views
            List<AbstractMobileController> instances = null;
//            List<AbstractMobileController> instances = Fluentness.getInstances(AbstractMobileController.class);
            AbstractMobileView mobile = instances.get(0).getMobileView();
            AndroidTemplate androidView = (AndroidTemplate) mobile.getTemplate();
            setContentView(androidView.getView());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | PackageManager.NameNotFoundException e) {
//            Log log = Fluentness.getInstance(Log.class);
//            if (log != null) {
//                log.error(e);
//            } else {
                android.util.Log.e(this.getClass().getSimpleName(), "Exception", e);
//            }
        }
    }
}
