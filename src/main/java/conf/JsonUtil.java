package conf;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;

public class JsonUtil {
    private static final Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();

    public static <T> T readJsonObjectFromFile(String pathToFile, Class<T> classType) {
        try (JsonReader reader = new JsonReader(new FileReader(pathToFile))) {
            return GSON.fromJson(reader, classType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
