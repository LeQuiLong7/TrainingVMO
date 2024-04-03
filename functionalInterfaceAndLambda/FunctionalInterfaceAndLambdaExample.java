package functionalInterfaceAndLambda;

import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfaceAndLambdaExample {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 6, -3, 5);

        // traditional style
        MyNumberChecker<Integer> evenNumberChecker1 = new MyNumberChecker<Integer>() {
            @Override
            public boolean check(Integer number) {
                return number % 2 == 0;
            }
        };
        // lambdas style
        MyNumberChecker<Integer> evenNumberChecker2 = n -> n % 2 == 0;


        // without lambdas
        list.stream()
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer > 5;
                    }
                })
                .forEach(System.out::println);
        // with lambdas
        list.stream()
                .filter(n -> n > 5)
                .forEach(System.out::println);

        // method reference style
        list.stream()
                .filter(MyNumberChecker::positive)
                .forEach(System.out::println);
    }
}
