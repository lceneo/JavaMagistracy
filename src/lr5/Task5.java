package lr5;
import java.util.List;
import java.util.stream.Collectors;

public class Task5 {
    public static List<String> containsSubstring(List<String> list, String sub) {
        return list.stream()
                .filter(s -> s.contains(sub))
                .collect(Collectors.toList());
    }
}