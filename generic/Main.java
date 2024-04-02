package generic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {


        Integer[] a = {1, 6, 3, 8};

        List<Integer> list = fromArrayToList(a);
        list.forEach(System.out::println);

    }

    public static <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).toList();
    }

    public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
        return Arrays.stream(a)
                .map(mapperFunction)
                .toList();
    }
}
