package org.fluentness.service.persistence;

import org.fluentness.model.PersistableModel;
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
    public <M extends PersistableModel> M retrieve(Class<M> modelClass, long id) {
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
    public <M extends PersistableModel> List<M> retrieve(Class<M> modelClass, String... conditions) {
        // todo implement conditions
        File[] records = new File(getFileDirectory(modelClass)).listFiles();
        return Arrays.stream(records != null ? records : new File[0])
            .map(file -> retrieve(modelClass, Integer.parseInt(file.getName())))
            .collect(Collectors.toList());
    }

    @Override
    public int persist(PersistableModel persistableModel) {
        try {
            Field idField = persistableModel.getClass().getField(PersistableModel.ID_FIELD_NAME);
            long id = (long) idField.get(persistableModel);
            if (id == 0) {
                idField.setAccessible(true);
                idField.set(persistableModel,getNewID(persistableModel));
            }
            FileOutputStream fileOut = new FileOutputStream(getFile(persistableModel.getClass(), id));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(persistableModel);
            out.close();
            fileOut.close();
            return 1;
        } catch (IOException | NoSuchFieldException | IllegalAccessException e) {
            log.error(e);
        }
        return 0;
    }


    @Override
    public <M extends PersistableModel> int remove(Class<M> modelClass, long id) {
        return getFile(modelClass,id).delete() ? 1 : 0;
    }


    @Override
    public int remove(PersistableModel persistableModel) {
        try {
            return remove(persistableModel.getClass(), (Long) persistableModel.getClass().getField(PersistableModel.ID_FIELD_NAME).get(persistableModel));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            log.error(e);
        }
        return 0;
    }

    private long getNewID(PersistableModel persistableModel) {
        try {
            // search for an unused id
            String[] list = new File(getFileDirectory(persistableModel.getClass())).list();
            long id;
            if (list != null) {
                id = list.length;
                while (getFile(persistableModel.getClass(), id).exists()) {
                    id++;
                }
            } else {
                Files.createDirectory(Paths.get(getFileDirectory(persistableModel.getClass())));
                id = 1;
            }
            return id;
        } catch (IOException e) {
            log.error(e);
        }
        return 0;
    }

    private File getFile(Class<? extends PersistableModel> modelClass, long id) {
        return new File(getFileDirectory(modelClass), "/" + id);
    }

    private <M extends PersistableModel> String getFileDirectory(Class<M> modelClass) {
        return dataDirectory + "/" + getPersistenceNameFor(modelClass);
    }
}

