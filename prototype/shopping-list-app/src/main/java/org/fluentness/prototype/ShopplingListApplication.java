package org.fluentness.prototype;

import org.fluentness.application.MobileApplication;
import org.fluentness.Fluentness;
import org.fluentness.prototype.controller.ShoppingListController;
import org.fluentness.service.instantiation.InstantiationException;

public class ShopplingListApplication extends MobileApplication {

    public ShopplingListApplication(ShoppingListController controller) {
        super(controller);
    }

    public static void main(String[] args) throws InstantiationException {
        Fluentness.launch(ShopplingListApplication.class, args);
    }
}
