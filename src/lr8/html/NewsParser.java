package lr8.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class NewsParser {
    private static final String URL = "http://fat.urfu.ru/index.html";
    private static final String FILE_PATH = "src/lr8/html/news.txt";
    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {
        try {
            Document doc = connectWithRetry(URL);
            Elements newsParent = doc.select(
                    "body > table > tbody > tr > td > div > table > tbody > tr:nth-child(5) > "
                            + "td:nth-child(3) > table > tbody > tr > td:nth-child(1)");

            List<String> newsLines = parseNews(newsParent);
            Files.write(Path.of(FILE_PATH), newsLines, StandardCharsets.UTF_8);

            newsLines.forEach(System.out::println);
            System.out.println("Данные сохранены в файл: " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Не удалось получить HTML-код страницы.");
            System.out.println("Проверьте подключение к интернету или доступность сайта: " + URL);
            System.out.println("Подробности ошибки: " + e.getMessage());
        }
    }

    private static Document connectWithRetry(String url) throws IOException {
        IOException lastException = null;
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            try {
                System.out.println("Попытка подключения " + attempt + " из " + MAX_ATTEMPTS);
                return Jsoup.connect(url).timeout(10_000).get();
            } catch (IOException e) {
                lastException = e;
                System.out.println("Ошибка подключения: " + e.getMessage());
            }
        }
        throw lastException;
    }

    private static List<String> parseNews(Elements newsParent) {
        List<String> result = new ArrayList<>();
        if (newsParent.isEmpty()) {
            result.add("Новости не найдены: структура HTML-страницы изменилась.");
            return result;
        }

        List<Node> nodes = newsParent.get(0).childNodes();
        for (int i = 3; i < 20 && i < nodes.size(); i++) {
            if (i % 2 != 0 && nodes.get(i) instanceof Element element) {
                String title = element.getElementsByClass("blocktitle").get(0).text();
                String date = element.getElementsByClass("blockdate").get(0).text();
                result.add("Тема: " + title);
                result.add("Дата: " + date);
                result.add("");
            }
        }
        return result;
    }
}
