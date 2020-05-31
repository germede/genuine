package org.fluentness.repository;

import org.fluentness.model.Player;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractPlayerRepository implements Repository<Player> {

    protected final List<Player> players = new LinkedList<>();

    @Override
    public List<Player> selectAll() {
        return players;
    }

}
