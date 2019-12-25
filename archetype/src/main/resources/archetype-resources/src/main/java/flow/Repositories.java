package ${package}.flow;

import ${package}.data.Dummy;
import org.fluentness.repository.repository.Repository;
import org.fluentness.repository.repository.RepositoryProducer;

public class Repositories extends RepositoryProducer {

    Repository dummy = forModel(Dummy.class,
        byDummy -> "SELECT d FROM Dummy d WHERE 1 = 1"
    );

}