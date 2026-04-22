package lr5;
import java.util.List;
import java.util.stream.Collectors;

public class Task7 {
    public static List<String> longerThan(List<String> list, int length) {
        return list.stream()
                .filter(s -> s.length() > length)
                .collect(Collectors.toList());
    }
}