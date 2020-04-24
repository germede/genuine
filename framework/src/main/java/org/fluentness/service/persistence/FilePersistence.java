package org.fluentness.service.persistence;

import java.util.List;

public class FilePersistence implements Persistence {

    @Override
    public <M> List<M> select(Class<M> aClass, String sql) {
        return null;
    }

    @Override
    public int persist(String sql) {
        return 0;
    }

    public static void main(String[] args) {
        FilePersistence filePersistence = new FilePersistence();
        Person miguel = new Person("Miguel", 30);



    }
}
