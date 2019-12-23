package ${package}.flow;

import ${package}.data.Dummy;
import org.fluentness.model.repository.Repository;
import org.fluentness.model.repository.RepositoryProducer;

public class Repositories extends RepositoryProducer {

    Repository dummy = forModel(Dummy.class,
        byDummy -> "SELECT d FROM Dummy d WHERE 1 = 1"
    );

}