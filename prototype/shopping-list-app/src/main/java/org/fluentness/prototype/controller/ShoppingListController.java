package org.fluentness.prototype.controller;

import org.fluentness.controller.MobileController;
import org.fluentness.prototype.view.ShoppingListView;
import org.fluentness.service.log.Log;

public class ShoppingListController extends MobileController<ShoppingListView> {

    public ShoppingListController(ShoppingListView view, Log log) {
        super(view);
        onClick(view.button1, this::changeText);
    }

    private void changeText() {
//\        view.button1.setText(_login);
    }
}
