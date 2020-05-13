package org.fluentness.service.persistence;

import org.fluentness.repository.CrudModel;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.configuration.Setting;
import org.fluentness.service.log.Log;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilePersistence implements Persistence {

    public static final Setting<String> DATA_DIRECTORY = new Setting<>("database");

    private final Log log;

    private String dataDirectory;

    public FilePersistence(Configuration configuration, Log log) throws IOException {
        this.log = log;
        this.dataDirectory = configuration.get(DATA_DIRECTORY);
        if (Files.notExists(Paths.get(dataDirectory))) {
            Files.createDirectory(Paths.get(dataDirectory));
        }
    }

    protected FilePersistence(String dataDirectory, Log log) throws IOException {
        this.log = log;
        this.dataDirectory = dataDirectory;
    }

    @Override
    public <M extends CrudModel> M retrieve(Class<M> modelClass, int id) {
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
    public <M extends CrudModel> List<M> retrieve(Class<M> modelClass, Condition... conditions) {
        // todo implement conditions
        File[] records = new File(getFileDirectory(modelClass)).listFiles();
        return Arrays.stream(records != null ? records : new File[0])
            .map(file -> retrieve(modelClass, Integer.parseInt(file.getName())))
            .collect(Collectors.toList());
    }

    @Override
    public int persist(CrudModel crudModel) {
        try {
            if (crudModel.getId() == 0) {
                crudModel.setId(getNewID(crudModel));
            }
            FileOutputStream fileOut = new FileOutputStream(getFile(crudModel.getClass(), crudModel.getId()));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(crudModel);
            out.close();
            fileOut.close();
            return 1;
        } catch (IOException e) {
            log.error(e);
        }
        return 0;
    }

    @Override
    public <M extends CrudModel> int remove(Class<M> modelClass, int id) {
        return getFile(modelClass,id).delete() ? 1 : 0;
    }

    private int getNewID(CrudModel crudModel) {
        try {
            // search for an unused id
            String[] list = new File(getFileDirectory(crudModel.getClass())).list();
            int id;
            if (list != null) {
                id = list.length;
                while (getFile(crudModel.getClass(), id).exists()) {
                    id++;
                }
            } else {
                Files.createDirectory(Paths.get(getFileDirectory(crudModel.getClass())));
                id = 1;
            }
            return id;
        } catch (IOException e) {
            log.error(e);
        }
        return 0;
    }

    private File getFile(Class<? extends CrudModel> modelClass, int id) {
        return new File(getFileDirectory(modelClass), "/" + id);
    }

    private <M extends CrudModel> String getFileDirectory(Class<M> modelClass) {
        return dataDirectory + "/" + getTableName(modelClass);
    }
}
