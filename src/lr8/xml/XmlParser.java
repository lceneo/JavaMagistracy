package lr8.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class XmlParser {
    private static final String FILE_PATH = "src/lr8/xml/songs.xml";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                System.out.println("Файл не найден. Сначала запустите CreateXMLFile.");
                return;
            }

            Document doc = loadDocument(file);
            boolean running = true;
            while (running) {
                System.out.println("""

                        1. Показать все музыкальные произведения
                        2. Добавить музыкальное произведение
                        3. Найти по исполнителю
                        4. Найти по году выпуска
                        5. Удалить по названию
                        0. Выход
                        """);
                System.out.print("Выберите действие: ");
                String command = scanner.nextLine();

                switch (command) {
                    case "1" -> printSongs(getSongs(doc));
                    case "2" -> addSong(doc, scanner);
                    case "3" -> searchByTag(doc, scanner, "artist", "исполнителя");
                    case "4" -> searchByTag(doc, scanner, "year", "год выпуска");
                    case "5" -> deleteByTitle(doc, scanner);
                    case "0" -> running = false;
                    default -> System.out.println("Неизвестная команда.");
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка при работе с XML-файлом: " + e.getMessage());
        }
    }

    private static Document loadDocument(File file) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        return doc;
    }

    private static List<Element> getSongs(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("song");
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            nodes.add(nodeList.item(i));
        }

        return nodes.stream()
                .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                .map(node -> (Element) node)
                .collect(Collectors.toList());
    }

    private static void addSong(Document doc, Scanner scanner) throws Exception {
        System.out.print("Название: ");
        String title = scanner.nextLine();
        System.out.print("Исполнитель: ");
        String artist = scanner.nextLine();
        System.out.print("Год выпуска: ");
        String year = scanner.nextLine();
        System.out.print("Жанр: ");
        String genre = scanner.nextLine();

        Element song = doc.createElement("song");
        doc.getDocumentElement().appendChild(song);
        appendElement(doc, song, "title", title);
        appendElement(doc, song, "artist", artist);
        appendElement(doc, song, "year", year);
        appendElement(doc, song, "genre", genre);

        saveDocument(doc);
        System.out.println("Музыкальное произведение добавлено.");
    }

    private static void searchByTag(Document doc, Scanner scanner, String tagName, String label) {
        System.out.print("Введите " + label + ": ");
        String query = scanner.nextLine();

        List<Element> songs = getSongs(doc).stream()
                .filter(song -> getText(song, tagName).equalsIgnoreCase(query))
                .collect(Collectors.toList());

        printSongs(songs);
    }

    private static void deleteByTitle(Document doc, Scanner scanner) throws Exception {
        System.out.print("Введите название для удаления: ");
        String title = scanner.nextLine();

        List<Element> songs = getSongs(doc);
        boolean removed = false;
        for (Element song : songs) {
            if (getText(song, "title").equalsIgnoreCase(title)) {
                Node parentNode = song.getParentNode();
                parentNode.removeChild(song);
                removed = true;
                break;
            }
        }

        if (removed) {
            saveDocument(doc);
            System.out.println("Музыкальное произведение удалено.");
        } else {
            System.out.println("Музыкальное произведение не найдено.");
        }
    }

    private static void printSongs(List<Element> songs) {
        if (songs.isEmpty()) {
            System.out.println("Подходящие музыкальные произведения не найдены.");
            return;
        }

        for (Element song : songs) {
            System.out.println("\nТекущий элемент: song");
            System.out.println("Название: " + getText(song, "title"));
            System.out.println("Исполнитель: " + getText(song, "artist"));
            System.out.println("Год выпуска: " + getText(song, "year"));
            System.out.println("Жанр: " + getText(song, "genre"));
        }
    }

    private static String getText(Element element, String tagName) {
        return element.getElementsByTagName(tagName).item(0).getTextContent();
    }

    private static void appendElement(Document doc, Element parent, String tagName, String text) {
        Element element = doc.createElement(tagName);
        element.appendChild(doc.createTextNode(text));
        parent.appendChild(element);
    }

    private static void saveDocument(Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
    }
}
