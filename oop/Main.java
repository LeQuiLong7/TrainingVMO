package oop;

public class Main {
    public static void main(String[] args) {


        // use parent class to represent the child class
        // then we can only access methods, attributes the exists in the parent class

        // when we create new objects, the actual object will be stored on the heap memory
        // and the variable name is just a pointer pointing to the actual object stored in heap
        BaseClass baseClassInstance1 = new ExtendedClass("abc");
        // this won't work
        // baseClassInstance1.addedMethod();

        // this will call the overridden version of the child class
        baseClassInstance1.displayData();


        // now both baseClassInstance1 and baseClassInstance2 are pointing to the same object
        BaseClass baseClassInstance2 = baseClassInstance1;
        baseClassInstance2.setData("new data");
        System.out.println(baseClassInstance1.getData());


    }
}
