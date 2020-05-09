package org.fluentness.game;

import org.fluentness.engine.AbstractScene;
import org.fluentness.engine.algebra.Vector3f;

public class MyScene extends AbstractScene {

    private final InputManager inputManager;

    public MyScene() {
        super("My scene");

        setBackground(new Vector3f(0, 0, 0.7f));
        EntityLoader entityLoader = new EntityLoader();
        addEntity(entityLoader.loadTrees());
        addEntity(entityLoader.loadGrasses());
        addEntity(entityLoader.loadFlowers());
        addEntity(entityLoader.loadFerns());
        addEntity(entityLoader.loadTerrain());

        inputManager = new InputManager(this);
        addInput(inputManager);
    }

    @Override
    protected void loop() {
        inputManager.handleCamera();
    }

    public static void main(String[] args) {
        AbstractScene scene = new MyScene();
        scene.run();
    }

}
