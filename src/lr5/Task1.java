package lr5;

import java.util.Arrays;

public class Task1 {
    public static int[] getEvenNumbers(int[] array) {
        return Arrays.stream(array)
                .filter(x -> x % 2 == 0)
                .toArray();
    }
}