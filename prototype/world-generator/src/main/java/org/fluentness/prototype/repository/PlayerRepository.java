package org.fluentness.prototype.repository;

import org.fluentness.model.Player;
import org.fluentness.service.loader.Loader;

public class PlayerRepository extends org.fluentness.repository.PlayerRepository {

    public PlayerRepository(Loader loader) {
        Player player = new Player(loader.loadShape("dragon.obj"), loader.loadTexture("white.png"));
        player.rotation.y = 180;
        players.add(player);
    }

}
