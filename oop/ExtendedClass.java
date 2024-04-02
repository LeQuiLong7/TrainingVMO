package oop;


// an Inheritance class will have all attributes, method of the parent class
// if it extends a abstract class, all abstract methods must be implemented
public class ExtendedClass extends BaseClass{
    @Override
    void doSomething() {
        System.out.println("do something");
    }

    public ExtendedClass(String data) {
        super(data);
    }

    // override method of parent class
    @Override
    public void displayData() {
        System.out.println(getData() + " something");
    }

    // add another method
    public void addedMethod() {
        System.out.println("Added method");
    }
}
