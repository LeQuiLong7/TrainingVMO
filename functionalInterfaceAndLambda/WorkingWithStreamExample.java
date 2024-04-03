package functionalInterfaceAndLambda;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WorkingWithStreamExample {

    public static void main(String[] args) {

        workingWithStream();
    }

    static void workingWithStream() {
        creatingStream();
        intermediateOperations();
        terminalOperations();
        streamPipeline();
    }

    static void creatingStream() {
        List<Integer> list = List.of(1, 6, 3, 5);
        int[] arr = {5, 7, 3, 7};

        // create a stream from a collection by calling stream() or parallelStream()
        // stream() and parallelStream() are default methods of Collection Interface
        Stream<Integer> stream1 = list.stream();

        // create a stream from a collection by calling Arrays.stream()
        IntStream stream2 = Arrays.stream(arr);
    }

    static void intermediateOperations() {
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape");

        // filter
        // to filter out only elements that satisfy the predicate
        List<String> result1 = fruits.stream()
                .filter(fruit -> fruit.startsWith("a"))
                .toList();

        // map
        // transform each element into another represent by applying a function
        // that takes the first argument as type of stream elements
        List<Integer> result2 = fruits.stream()
                .map(String::length)
                .toList();

        // sort
        // sort elements based on a comparator (either custom or implemented by the element)
        List<String> result3 = fruits.stream()
                .sorted()
                .toList();
    }

    // the stream won't start unless it has 1 terminal operation
    static void terminalOperations() {
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape");
        // collect
        // to collect elements into a collection (List, Set, Map,...)
        // can apply custom logic
        List<String> result1 = fruits.stream()
                .collect(Collectors.toList());


        // collect element into a map base on the first character
        Map<Character, Set<String>> collect = fruits.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.toSet()));


        // reduce
        // collect elements into a single object
        // can apply custom logic
        String result2 = fruits.stream()
                .reduce("", (s1, s2) -> s1 + " " + s2);

        // forEach
        // loop through all elements
        fruits.stream().forEach(System.out::println);

        // find
        // find an element: findFirst, findAny
        fruits.stream().findFirst();

        // match: all match, none match, match any
        fruits.stream().allMatch(s -> s.length() > 5);
    }

    // Streams can be combined in a pipeline where the output of one operation becomes the input of the next operation.
    static void streamPipeline() {
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape");
        fruits.stream()
                .map(String::length)
                .filter(length -> length > 2)
                .forEach(System.out::println);
    }

}
