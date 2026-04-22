package lr5;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    public static List<String> getCapitalized(List<String> list) {
        return list.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }
}