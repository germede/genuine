package com.sample.flow;

import com.sample.data.Song;
import org.fluentness.flow.repository.Repository;
import org.fluentness.flow.repository.RepositoryProvider;

public class Repositories extends RepositoryProvider {

    Repository song = forModel(Song.class,
        byTitle -> "SELECT s FROM Song s WHERE s.title LIKE :title"
    );
}