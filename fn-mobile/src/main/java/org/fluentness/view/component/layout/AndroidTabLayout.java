package org.fluentness.view.component.layout;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import org.fluentness.view.AbstractMobileView;

public class AndroidTabLayout extends LinearLayout implements TabLayout {


    private final LinearLayout tabNames = new LinearLayout(AbstractMobileView.context);
    private final ViewFlipper tabFlipper = new ViewFlipper(AbstractMobileView.context);
    private final Animation inAnimation = AnimationUtils.loadAnimation(AbstractMobileView.context, android.R.anim.fade_in);
    private final Animation outAnimation = AnimationUtils.loadAnimation(AbstractMobileView.context, android.R.anim.fade_out);

    private int lastActive;
    private int active;

    public AndroidTabLayout(TabLayout.Tab<View>[] tabs) {
        super(AbstractMobileView.context);
        setOrientation(VERTICAL);

        tabFlipper.setInAnimation(inAnimation);
        tabFlipper.setOutAnimation(outAnimation);

        tabNames.setOrientation(HORIZONTAL);
        for (int i = 0; i < tabs.length; i++) {
            Tab tab = tabs[i];
            Button tabName = new Button(AbstractMobileView.context);
            tabName.setText(tab.getName());
            tabName.setBackgroundColor(android.R.color.transparent);
            int finalI = i;
            tabName.setOnClickListener(view -> {
                setActive(finalI);
                tabFlipper.setDisplayedChild(finalI);
            });
            tabNames.addView(tabName);
            tabFlipper.addView((View) tab.getContent());
        }

        addView(tabNames);
        addView(tabFlipper);
    }

    @Override
    public void setActive(int tabIndex) {
        lastActive = this.active;
        this.active = tabIndex;
    }

}
