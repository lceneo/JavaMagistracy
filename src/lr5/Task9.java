package lr5;
import java.util.List;
import java.util.stream.Collectors;

public class Task9 {
    public static List<String> onlyLetters(List<String> list) {
        return list.stream()
                .filter(s -> s.matches("[a-zA-Zа-яА-Я]+"))
                .collect(Collectors.toList());
    }
}