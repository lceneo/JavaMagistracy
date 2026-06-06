package lr8.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonCreator {
    private static final String FILE_PATH = "src/lr8/json/songs.json";

    public static void main(String[] args) {
        JSONObject songList = new JSONObject();
        JSONArray songs = new JSONArray();

        songs.add(createSong("Bohemian Rhapsody", "Queen", 1975, "Rock"));
        songs.add(createSong("Billie Jean", "Michael Jackson", 1982, "Pop"));
        songs.add(createSong("Smells Like Teen Spirit", "Nirvana", 1991, "Grunge"));

        songList.put("songs", songs);

        try (OutputStreamWriter file = new OutputStreamWriter(
                Files.newOutputStream(Path.of(FILE_PATH)), StandardCharsets.UTF_8)) {
            file.write(songList.toJSONString());
            System.out.println("JSON-файл с музыкальными произведениями успешно создан: " + FILE_PATH);
        } catch (Exception e) {
            System.out.println("Ошибка при создании JSON-файла: " + e.getMessage());
        }
    }

    private static JSONObject createSong(String title, String artist, int year, String genre) {
        JSONObject song = new JSONObject();
        song.put("title", title);
        song.put("artist", artist);
        song.put("year", year);
        song.put("genre", genre);
        return song;
    }
}
