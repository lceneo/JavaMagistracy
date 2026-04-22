package lr5;
import java.util.Arrays;

public class Task2 {
    public static int[] getCommonElements(int[] a, int[] b) {
        return Arrays.stream(a)
                .filter(x -> Arrays.stream(b).anyMatch(y -> y == x))
                .toArray();
    }
}