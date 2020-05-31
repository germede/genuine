package org.fluentness.prototype.view;

import org.fluentness.prototype.repository.EntityRepository;
import org.fluentness.prototype.repository.PlayerRepository;
import org.fluentness.prototype.repository.TerrainRepository;
import org.fluentness.view.AbstractGameView;
import org.fluentness.view.environment.background.Background;
import org.fluentness.view.environment.camera.Camera;
import org.fluentness.view.environment.fog.Fog;
import org.fluentness.view.environment.light.Light;

public class GameView extends AbstractGameView {

    public GameView(
        TerrainRepository terrainRepository,
        EntityRepository entityRepository,
        PlayerRepository playerRepository
    ) {
        super("Forest");
        terrainRepository.selectAll().forEach(this::addTerrain);
        entityRepository.selectAll().forEach(this::addEntity);
        playerRepository.selectAll().forEach(this::addEntity);
    }

    @Override
    protected Background background() {
        return new Background(0,0,0.7f);
    }

    @Override
    protected Camera camera() {
        return new Camera(0,50,0);
    }

    @Override
    protected Light light() {
        return new Light(0,0,0);
    }

    @Override
    protected Fog fog() {
        return new Fog(0.0012f, 5.0f);
    }
}
