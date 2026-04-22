package lr5;
import java.util.List;
import java.util.stream.Collectors;

public class Task8 {
    public static List<Integer> greaterThan(List<Integer> list, int value) {
        return list.stream()
                .filter(x -> x > value)
                .collect(Collectors.toList());
    }
}