package lr8.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class NewsParserByElements {
    private static final String URL = "http://fat.urfu.ru/index.html";
    private static final String FILE_PATH = "src/lr8/html/news-by-elements.txt";

    public static void main(String[] args) {
        try {
            Document doc = connectWithRetry(URL);
            Elements news = doc.select(".blocktitle, .blockdate");
            List<String> lines = new ArrayList<>();

            for (int i = 0; i + 1 < news.size() && i < 20; i += 2) {
                Element title = news.get(i);
                Element date = news.get(i + 1);
                lines.add("Тема: " + title.text());
                lines.add("Дата: " + date.text());
                lines.add("");
            }

            if (lines.isEmpty()) {
                lines.add("Новости не найдены: структура HTML-страницы изменилась.");
            }

            Files.write(Path.of(FILE_PATH), lines, StandardCharsets.UTF_8);
            lines.forEach(System.out::println);
            System.out.println("Данные сохранены в файл: " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Не удалось получить HTML-код страницы.");
            System.out.println("Проверьте подключение к интернету или доступность сайта: " + URL);
            System.out.println("Подробности ошибки: " + e.getMessage());
        }
    }

    private static Document connectWithRetry(String url) throws IOException {
        IOException lastException = null;
        for (int attempt = 1; attempt <= 3; attempt++) {
            try {
                System.out.println("Попытка подключения " + attempt + " из 3");
                return Jsoup.connect(url).timeout(10_000).get();
            } catch (IOException e) {
                lastException = e;
                System.out.println("Ошибка подключения: " + e.getMessage());
            }
        }
        throw lastException;
    }
}
