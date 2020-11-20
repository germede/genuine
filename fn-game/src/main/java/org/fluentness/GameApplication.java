package org.fluentness;

import org.fluentness.controller.GameController;
import org.fluentness.service.algebra.Algebra;
import org.fluentness.service.algebra.AlgebraImpl;
import org.fluentness.service.animator.Animator;
import org.fluentness.service.animator.AnimatorImpl;
import org.fluentness.service.display.Display;
import org.fluentness.service.display.GlfwDisplay;
import org.fluentness.service.injector.DefaultImplementations;
import org.fluentness.service.loader.Loader;
import org.fluentness.service.loader.LoaderImpl;
import org.fluentness.service.looper.Looper;
import org.fluentness.service.looper.LooperImpl;
import org.fluentness.service.memory.Memory;
import org.fluentness.service.memory.MemoryImpl;

public abstract class GameApplication implements Application {

    static {
        DefaultImplementations.set(Loader.class, LoaderImpl.class);
        DefaultImplementations.set(Display.class, GlfwDisplay.class);
        DefaultImplementations.set(Algebra.class, AlgebraImpl.class);
        DefaultImplementations.set(Animator.class, AnimatorImpl.class);
        DefaultImplementations.set(Memory.class, MemoryImpl.class);
        DefaultImplementations.set(Looper.class, LooperImpl.class);
    }

    private final Looper looper;
    private final GameController controller;

    public GameApplication(Looper looper, GameController controller) {
        this.looper = looper;
        this.controller = controller;
    }

    @Override
    public void run(String[] args) throws Exception {
        looper.loop(controller);
    }

}
