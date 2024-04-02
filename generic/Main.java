package generic;

import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Integer[] a = {1, 6, 3, 8};

        // pass in an array of Integer so T is Integer then the return type will be List<Integer>
        List<Integer> list = fromArrayToList(a);

        // the first argument is an array of Integer so T is Integer
        // then the second argument must be a function that takes in an Integer and return some type
        // here the mapping function return String so G is String
        // then the return type (List<G>) will be a List of String
        List<String> customList = fromArrayToCustomList(a, i -> i + "");

        // because Integer class already implemented Comparable interface so this works
       countGreaterThan(a, 6);
        // this won't work because List<Integer> is not a subclass of List<Number>
       // sumWithoutWildCard(list);

        // this will work because Integer is a subclass of Number
        printNumberUsingWildCard(list);
    }


    // Generic method
    // whatever array type is passed in as parameter, the return type will be a list of that type
    // T here is just an arbitrary name, we can name it whatever we want
    public static <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).toList();
    }


    // Generic method with two generic types T and G
    public static <T, G> List<G> fromArrayToCustomList(T[] a, Function<T, G> mapperFunction) {
        return Arrays.stream(a)
                .map(mapperFunction)
                .toList();
    }

    // bounded generic
    // only classes that implement the comparable interface are allowed
    // since only classes that implement the comparable interface are allowed,
    // we can call the compareTo method on generic T type
    public static <T extends Comparable<T>> void countGreaterThan(T[] anArray, T elem) {
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                System.out.println(e);
    }


    // this will only accept List<Number> as parameter
    // List<Integer>, List<Double>,... are not allowed
    public static void printNumberWithoutWildCard(List<Number> list) {
        for(Number n : list) {
            System.out.println();
        }
    }

    // this will accept List<Integer>, List<Double>,...as parameter
    // but we can not insert into the list
    // we can still remove element, clear list and read
    public static void printNumberUsingWildCard(List<? extends Number> list) {
        for(Number n : list) {
            System.out.println(n);
        }
    }
    //List<Object> and List<?> are not the same.
    // We can insert an Object, or any subtype of Object, into a List<Object>.
    // But you can only insert null into a List<?>
    // so List<?> is only for reading and each element will be considered an Object
    public static void printListOfAnyType(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }
}
