package ${package}.flow;

import ${package}.data.Dummy;
import org.fluentness.flow.repository.Repository;
import org.fluentness.flow.repository.RepositoryProvider;

public class Repositories extends RepositoryProvider {

    Repository dummy = forModel(Dummy.class,
        byDummy -> "SELECT d FROM Dummy d WHERE 1 = 1"
    );

}