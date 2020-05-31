package org.fluentness.prototype.repository;

import org.fluentness.model.Player;
import org.fluentness.repository.AbstractPlayerRepository;
import org.fluentness.service.loader.Loader;

public class PlayerRepository extends AbstractPlayerRepository {

    public PlayerRepository(Loader loader) {
        Player player = new Player(loader.loadShape("dragon.obj"), loader.loadTexture("white.png"));
        player.rotation.y = 180;
        players.add(player);
    }

}
