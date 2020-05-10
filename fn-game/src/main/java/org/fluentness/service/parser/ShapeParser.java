package org.fluentness.service.parser;

import org.fluentness.model.RawShape;
import org.fluentness.service.algebra.Vector2f;
import org.fluentness.service.algebra.Vector3f;
import org.fluentness.service.log.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class ShapeParser implements Parser {

    private BufferedReader reader;

    private List<Vector3f> vertices = new ArrayList<>();
    private List<Vector2f> textures = new ArrayList<>();
    private List<Vector3f> normals = new ArrayList<>();
    private List<Integer> indices = new LinkedList<>();

    private float[] verticesArray;
    private float[] texturesArray;
    private float[] normalsArray;
    private int[] indicesArray;

    private final Log log;

    public ShapeParser(Log log) {
        this.log = log;
    }

    @Override
    public RawShape parse(String path) {
        try {
            process(path);
            return new RawShape(verticesArray, texturesArray, normalsArray, indicesArray);
        } catch (IOException e) {
            log.error(e);
            System.exit(-1);
        }
        return null;
    }

    private void process(String model) throws IOException {
        reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/shapes/" + model)));
        clear();
        readLists();
        readFaces();
    }

    private void clear() {
        vertices.clear();
        textures.clear();
        normals.clear();
        indices.clear();
    }

    private void readLists() throws IOException {
        while (true) {
            String line = reader.readLine();
            if (line == null || line.startsWith("f")) {
                texturesArray = new float[vertices.size() * 2];
                normalsArray = new float[vertices.size() * 3];
                verticesArray = new float[vertices.size() * 3];
                int i = 0;
                for (Vector3f vertex : vertices) {
                    verticesArray[i++] = vertex.x;
                    verticesArray[i++] = vertex.y;
                    verticesArray[i++] = vertex.z;
                }
                break;
            }
            handleList(line);
        }
    }

    private void handleList(String line) {
        String[] words = line.split(" ");
        if ("v".equals(words[0])) {
            vertices.add(new Vector3f(parseFloat(words[1]), parseFloat(words[2]), parseFloat(words[3])));
        } else if ("vt".equals(words[0])) {
            textures.add(new Vector2f(parseFloat(words[1]), parseFloat(words[2])));
        } else if ("vn".equals(words[0])) {
            normals.add(new Vector3f(parseFloat(words[1]), parseFloat(words[2]), parseFloat(words[3])));
        }
    }

    private void readFaces() throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.startsWith("f")) {
                continue;
            }
            String[] current = line.split(" ");
            handleVertex(current[1].split("/"));
            handleVertex(current[2].split("/"));
            handleVertex(current[3].split("/"));
        }
        reader.close();
        indicesArray = indices.stream().mapToInt(i -> i).toArray();
    }

    private void handleVertex(String[] components) {
        int index = parseInt(components[0]) - 1;
        indices.add(index);
        Vector2f texture = textures.get(parseInt(components[1]) - 1);
        texturesArray[index * 2] = texture.x;
        texturesArray[index * 2 + 1] = 1 - texture.y;
        Vector3f normal = normals.get(parseInt(components[2]) - 1);
        normalsArray[index * 3] = normal.x;
        normalsArray[index * 3 + 1] = normal.y;
        normalsArray[index * 3 + 2] = normal.z;
    }

}
