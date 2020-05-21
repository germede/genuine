package org.fluentness.view.interaction;

public interface Clickable<C extends Clickable> {

    void onClick(OnClickAction<C> onClickAction);

    interface OnClickAction<C extends Clickable> {
        void handle(C clickable);
    }
}
