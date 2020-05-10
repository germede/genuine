package com.sample;

import org.fluentness.controller.Input;
import org.fluentness.repository.EntityRepository;
import org.fluentness.view.Scene;
import org.fluentness.service.algebra.Vector3f;

public class MyScene extends Scene {

    private final Input input;

    public MyScene() {
        super("My scene");

        setBackground(new Vector3f(0, 0, 0.7f));
        EntityRepository entityRepository = new EntityRepository();
        addEntity(entityRepository.loadTrees());
        addEntity(entityRepository.loadGrasses());
        addEntity(entityRepository.loadFlowers());
        addEntity(entityRepository.loadFerns());
        addEntity(entityRepository.loadTerrain());

        input = new Input(this);
        addInput(input);
    }


    public static void main(String[] args) {
        Scene scene = new MyScene();
        scene.run();
    }

}
