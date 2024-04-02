package methodInJava;

public class DemoClass {


    //  a static method is a method that belongs to the class itself rather than to any instance of the class.
    //  This means that you can call a static method without creating an instance of the class.
    //  a static method can't access any attributes nor methods of the class that are not static

    public static void demoStaticMethod() {
        System.out.println("Static method");

    }

    // private method can only be called inside this class
    private void demoPrivateMethod() {
        System.out.println("Private method");
    }
    // public method can be called anywhere
    public void callPrivateMethod() {
        System.out.println("Public method");

        // this works because this is still inside the class
        demoPrivateMethod();
    }

    // can be called within the same package or by subclasses (even if the subclass is in a different package).
    protected void demoProtectedMethod() {
        System.out.println("Protected method");
    }

    // can only be called within the same package
     void demoDefaultMethod() {
        System.out.println("Default method");
    }

}
