package oop;


// abstract classes are classes that have zero or more abstract methods
public abstract class BaseClass {
    private String data;

    // abstract methods are methods that don't have the implementation,
    // just return type, method name and parameters(optional)
    // the implementation will be defined in implementation classes
    // it's like a general sketch
    abstract void doSomething();


    public BaseClass(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void displayData() {
        System.out.println(data);
    }

}
