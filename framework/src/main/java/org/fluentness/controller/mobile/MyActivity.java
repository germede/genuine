package org.fluentness.controller.mobile;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MyActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView text = new TextView(this);
        text.setText("test");
        setContentView(text);
    }
}
