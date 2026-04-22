package lr5;
import java.util.List;
import java.util.stream.Collectors;

public class Task6 {
    public static List<Integer> divisibleBy(List<Integer> list, int divisor) {
        return list.stream()
                .filter(x -> x % divisor == 0)
                .collect(Collectors.toList());
    }
}