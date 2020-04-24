package org.fluentness.service.persistence;

import org.fluentness.repository.Model;
import org.fluentness.service.logger.Logger;

import java.io.*;
import java.util.List;

public class FilePersistence implements Persistence {

    private final Logger logger;

    public FilePersistence(Logger logger) {
        this.logger = logger;
    }

    public static void main(String[] args) {
        FilePersistence filePersistence = new FilePersistence(null);
        Person miguel = new Person("Miguel", 30);
        filePersistence.persist(miguel);

        filePersistence.retrieve(Person.class, miguel.getId());
        System.out.println(miguel.getAge() + miguel.getName());
    }

    @Override
    public <M extends Model> M retrieve(Class<M> modelClass, long id) {
        Model model = null;
        try {
            FileInputStream fileIn = new FileInputStream("data/" + modelClass.getSimpleName().toLowerCase() + "/" + id);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            model = (Model) in.readObject();
            in.close();
            fileIn.close();
            return (M) model;
        } catch (IOException | ClassNotFoundException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public <M extends Model> List<M> retrieve(Class<M> aClass, String... conditions) {
        // todo implement
        return null;
    }

    @Override
    public int persist(Model model) {
        try {
            FileOutputStream fileOut = new FileOutputStream("/tmp/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(model);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

        return 0;
    }

    @Override
    public int remove(Model model) {
        // todo implement
        return 0;
    }
}
