package lr8.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Scanner;

public class JsonParser {
    private static final String FILE_PATH = "src/lr8/json/songs.json";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Path path = Path.of(FILE_PATH);
            if (!Files.exists(path)) {
                System.out.println("Файл не найден. Сначала запустите JsonCreator.");
                return;
            }

            JSONObject jsonObject = readJson(path);
            JSONArray jsonArray = (JSONArray) jsonObject.get("songs");
            boolean running = true;

            while (running) {
                System.out.println("""

                        1. Показать все музыкальные произведения
                        2. Найти по исполнителю
                        3. Добавить музыкальное произведение
                        4. Удалить по названию
                        0. Выход
                        """);
                System.out.print("Выберите действие: ");
                String command = scanner.nextLine();

                switch (command) {
                    case "1" -> printSongs(jsonArray);
                    case "2" -> searchByArtist(jsonArray, scanner);
                    case "3" -> addSong(jsonObject, jsonArray, scanner, path);
                    case "4" -> deleteByTitle(jsonObject, jsonArray, scanner, path);
                    case "0" -> running = false;
                    default -> System.out.println("Неизвестная команда.");
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка при работе с JSON-файлом: " + e.getMessage());
        }
    }

    private static JSONObject readJson(Path path) throws Exception {
        JSONParser parser = new JSONParser();
        try (InputStreamReader reader = new InputStreamReader(Files.newInputStream(path), StandardCharsets.UTF_8)) {
            return (JSONObject) parser.parse(reader);
        }
    }

    private static void searchByArtist(JSONArray jsonArray, Scanner scanner) {
        System.out.print("Введите исполнителя: ");
        String artist = scanner.nextLine();

        JSONArray result = new JSONArray();
        jsonArray.stream()
                .filter(song -> song instanceof JSONObject)
                .filter(song -> artist.equalsIgnoreCase(String.valueOf(((JSONObject) song).get("artist"))))
                .forEach(result::add);

        printSongs(result);
    }

    private static void addSong(JSONObject jsonObject, JSONArray jsonArray, Scanner scanner, Path path) throws Exception {
        JSONObject newSong = new JSONObject();
        System.out.print("Название: ");
        newSong.put("title", scanner.nextLine());
        System.out.print("Исполнитель: ");
        newSong.put("artist", scanner.nextLine());
        System.out.print("Год выпуска: ");
        newSong.put("year", Integer.parseInt(scanner.nextLine()));
        System.out.print("Жанр: ");
        newSong.put("genre", scanner.nextLine());

        jsonArray.add(newSong);
        saveJson(jsonObject, path);
        System.out.println("Музыкальное произведение добавлено.");
    }

    private static void deleteByTitle(JSONObject jsonObject, JSONArray jsonArray, Scanner scanner, Path path) throws Exception {
        System.out.print("Введите название для удаления: ");
        String title = scanner.nextLine();
        boolean removed = false;

        Iterator iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            JSONObject song = (JSONObject) iterator.next();
            if (title.equalsIgnoreCase(String.valueOf(song.get("title")))) {
                iterator.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            saveJson(jsonObject, path);
            System.out.println("Музыкальное произведение удалено.");
        } else {
            System.out.println("Музыкальное произведение не найдено.");
        }
    }

    private static void printSongs(JSONArray jsonArray) {
        if (jsonArray.isEmpty()) {
            System.out.println("Подходящие музыкальные произведения не найдены.");
            return;
        }

        for (Object o : jsonArray) {
            JSONObject song = (JSONObject) o;
            System.out.println("\nТекущий элемент: song");
            System.out.println("Название: " + song.get("title"));
            System.out.println("Исполнитель: " + song.get("artist"));
            System.out.println("Год выпуска: " + song.get("year"));
            System.out.println("Жанр: " + song.get("genre"));
        }
    }

    private static void saveJson(JSONObject jsonObject, Path path) throws Exception {
        try (OutputStreamWriter writer = new OutputStreamWriter(Files.newOutputStream(path), StandardCharsets.UTF_8)) {
            writer.write(jsonObject.toJSONString());
        }
    }
}
