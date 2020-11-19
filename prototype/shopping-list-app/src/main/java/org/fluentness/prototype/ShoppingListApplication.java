package org.fluentness.prototype;

import org.fluentness.MobileApplication;
import org.fluentness.prototype.controller.ShoppingListController;
import org.fluentness.service.injector.ConstructorInjector;

public class ShoppingListApplication extends MobileApplication {

    public ShoppingListApplication(ShoppingListController controller) {
        super(controller);
    }

    public static void main(String[] args) throws Exception {
        new ConstructorInjector().inject(ShoppingListApplication.class).run(args);
    }
}
