package lr8.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CreateXMLFile {
    private static final String FILE_PATH = "src/lr8/xml/songs.xml";

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("songs");
            doc.appendChild(rootElement);

            appendSong(doc, rootElement, "Bohemian Rhapsody", "Queen", "1975", "Rock");
            appendSong(doc, rootElement, "Billie Jean", "Michael Jackson", "1982", "Pop");
            appendSong(doc, rootElement, "Smells Like Teen Spirit", "Nirvana", "1991", "Grunge");

            saveDocument(doc);
            System.out.println("XML-файл с музыкальными произведениями успешно создан: " + FILE_PATH);
        } catch (Exception e) {
            System.out.println("Ошибка при создании XML-файла: " + e.getMessage());
        }
    }

    private static void appendSong(Document doc, Element rootElement, String title, String artist, String year, String genre) {
        Element song = doc.createElement("song");
        rootElement.appendChild(song);

        appendElement(doc, song, "title", title);
        appendElement(doc, song, "artist", artist);
        appendElement(doc, song, "year", year);
        appendElement(doc, song, "genre", genre);
    }

    private static void appendElement(Document doc, Element parent, String tagName, String text) {
        Element element = doc.createElement(tagName);
        element.appendChild(doc.createTextNode(text));
        parent.appendChild(element);
    }

    private static void saveDocument(Document doc) throws Exception {
        doc.setXmlStandalone(true);
        doc.normalizeDocument();

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
    }
}
