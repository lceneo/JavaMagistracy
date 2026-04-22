package lr5;
import java.util.List;
import java.util.stream.Collectors;

public class Task10 {
    public static List<Integer> lessThan(List<Integer> list, int value) {
        return list.stream()
                .filter(x -> x < value)
                .collect(Collectors.toList());
    }
}