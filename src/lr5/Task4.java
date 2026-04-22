package lr5;
import java.util.List;
import java.util.stream.Collectors;

public class Task4 {
    public static List<Integer> getSquares(List<Integer> list) {
        return list.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
    }
}