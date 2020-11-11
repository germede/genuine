package org.fluentness.service.persistence;

import org.fluentness.model.Model;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.configuration.Setting;
import org.fluentness.service.log.Log;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilePersistence implements Persistence {

    public static final Setting<String> DATA_DIRECTORY = new Setting<>("database");

    private final Log log;
    private final String dataDirectory;

    public FilePersistence(Configuration configuration, Log log) throws IOException {
        this.log = log;
        this.dataDirectory = configuration.get(DATA_DIRECTORY);
        if (Files.notExists(Paths.get(dataDirectory))) {
            Files.createDirectory(Paths.get(dataDirectory));
        }
    }

    protected FilePersistence(String dataDirectory, Log log) {
        this.log = log;
        this.dataDirectory = dataDirectory;
    }

    @Override
    public <M extends Model> M retrieve(Class<M> modelClass, long id) {
        try {
            FileInputStream fileIn = new FileInputStream(getFile(modelClass, id));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object model = in.readObject();
            in.close();
            fileIn.close();
            return (M) model;
        } catch (IOException | ClassNotFoundException e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public <M extends Model> List<M> retrieve(Class<M> modelClass, String... conditions) {
        // todo implement conditions
        File[] records = new File(getFileDirectory(modelClass)).listFiles();
        return Arrays.stream(records != null ? records : new File[0])
            .map(file -> retrieve(modelClass, Integer.parseInt(file.getName())))
            .collect(Collectors.toList());
    }

    @Override
    public int persist(Model model) {
        try {
            Field idField = model.getClass().getField(Model.ID_NAME);
            long id = (long) idField.get(model);
            if (id == 0) {
                idField.setAccessible(true);
                idField.set(model,getNewID(model));
            }
            FileOutputStream fileOut = new FileOutputStream(getFile(model.getClass(), id));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(model);
            out.close();
            fileOut.close();
            return 1;
        } catch (IOException | NoSuchFieldException | IllegalAccessException e) {
            log.error(e);
        }
        return 0;
    }


    @Override
    public <M extends Model> int remove(Class<M> modelClass, long id) {
        return getFile(modelClass,id).delete() ? 1 : 0;
    }


    @Override
    public int remove(Model model) {
        try {
            return remove(model.getClass(), (Long) model.getClass().getField(Model.ID_NAME).get(model));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            log.error(e);
        }
        return 0;
    }

    private long getNewID(Model model) {
        try {
            // search for an unused id
            String[] list = new File(getFileDirectory(model.getClass())).list();
            long id;
            if (list != null) {
                id = list.length;
                while (getFile(model.getClass(), id).exists()) {
                    id++;
                }
            } else {
                Files.createDirectory(Paths.get(getFileDirectory(model.getClass())));
                id = 1;
            }
            return id;
        } catch (IOException e) {
            log.error(e);
        }
        return 0;
    }

    private File getFile(Class<? extends Model> modelClass, long id) {
        return new File(getFileDirectory(modelClass), "/" + id);
    }

    private <M extends Model> String getFileDirectory(Class<M> modelClass) {
        return dataDirectory + "/" + getPersistenceNameFor(modelClass);
    }
}

