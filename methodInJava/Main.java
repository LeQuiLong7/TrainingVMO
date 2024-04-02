package methodInJava;

public class Main {
    public static void main(String[] args) {
        DemoClass demoClass = new DemoClass();
//        this won't work because demoPrivateMethod is private
//        demoClass.demoPrivateMethod();

//        this works because callPrivateMethod is public
        demoClass.callPrivateMethod();
//        this works because demoProtectedMethod is protected and this is still inside the same package
        demoClass.demoProtectedMethod();

//        this works because demoDefaultMethod is a default method and this is still inside the same package
        demoClass.demoDefaultMethod();

//        this works because demoStaticMethod is a static method so we don't need
//        to create an instance of the class to call to that method
        DemoClass.demoStaticMethod();
    }
}
