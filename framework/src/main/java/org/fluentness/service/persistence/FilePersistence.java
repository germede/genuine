package org.fluentness.service.persistence;

import org.fluentness.repository.Model;
import org.fluentness.service.logger.Logger;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilePersistence implements Persistence {

    private final Logger logger;

    public FilePersistence(Logger logger) throws IOException {
        this.logger = logger;
        if (Files.notExists(Paths.get("data"))){
            Files.createDirectory(Paths.get("data"));
        }
    }

    @Override
    public <M extends Model> M retrieve(Class<M> modelClass, long id) {
        try {
            FileInputStream fileIn = new FileInputStream(getFilePath(modelClass, id));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Model model = (Model) in.readObject();
            in.close();
            fileIn.close();
            return (M) model;
        } catch (IOException | ClassNotFoundException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public <M extends Model> List<M> retrieve(Class<M> modelClass, String... conditions) {
        // todo implement conditions
        File[] records = new File(getFileDirectory(modelClass)).listFiles();
        return Arrays.stream(records != null ? records : new File[0])
            .map(file -> retrieve(modelClass, Long.parseLong(file.getName())))
            .collect(Collectors.toList());
    }

    @Override
    public int persist(Model model) {
        try {
            if (model.getId() == 0) {
                setNewID(model);
            }

            Path path = Paths.get(getFilePath(model.getClass(), model.getId()));
            if (Files.notExists(path)) {
                Files.createFile(path);
            }
            FileOutputStream fileOut = new FileOutputStream(getFilePath(model.getClass(), model.getId()));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(model);
            out.close();
            fileOut.close();
            return 1;
        } catch (IOException e) {
            logger.error(e);
        }
        return 0;
    }

    @Override
    public int remove(Model model) {
        try {
            Files.delete(Paths.get(getFilePath(model.getClass(), model.getId())));
            return 1;
        } catch (IOException e) {
            logger.error(e);
        }
        return 0;
    }

    private void setNewID(Model model) {
        try {
            // search for an unused id
            String[] list = new File(getFileDirectory(model.getClass())).list();
            long id;
            if (list != null) {
                id = list.length;
                while (Files.exists(Paths.get(getFilePath(model.getClass(), id)))) {
                    id++;
                }
            } else {
                Files.createDirectory(Paths.get(getFileDirectory(model.getClass())));
                id = 1;
            }
            Field idField = Model.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(model, id);
        } catch (NoSuchFieldException | IllegalAccessException | IOException e) {
            logger.error(e);
        }
    }

    private <M extends Model> String getFilePath(Class<M> modelClass, long id) {
        return getFileDirectory(modelClass) + "/" + id;
    }

    private <M extends Model> String getFileDirectory(Class<M> modelClass) {
        return "data/" + modelClass.getSimpleName().toLowerCase();
    }
}
