package functionalInterfaceAndLambda;

@FunctionalInterface
public interface MyNumberChecker<T extends Number>{

    boolean check(T number);
    static <T extends Number> boolean positive(T number) {
        return number.doubleValue() > 0;
    }
    static <T extends Number> boolean negative(T number) {
        return number.doubleValue() < 0;
    }

    static <T extends Number> boolean prime(T number) {
        double num = number.doubleValue();
        for(int i = 2; i < Math.sqrt(num); i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
